// This is a huge build matrix! so it's better to find problems rather than failing prematurely.
val LTSJava = JavaSpec.temurin("17")
ThisBuild / githubWorkflowJavaVersions := Seq(LTSJava)
ThisBuild / githubWorkflowBuildMatrixFailFast := Some(false)
ThisBuild / tlSiteJavaVersion := LTSJava
ThisBuild / githubWorkflowOSes := Seq(
  "ubuntu-latest",
  // "windows-2022", // disable for now, there is some linking problem
  "macos-13",
  "macos-latest"
)

ThisBuild / githubWorkflowBuildMatrixExclusions ++= githubWorkflowOSes.value
  .filter(_ != "ubuntu-latest")
  .flatMap(os =>
    Seq(
      MatrixExclude(Map("project" -> "rootJS", "os" -> os)),
      MatrixExclude(Map("project" -> "rootJVM", "os" -> os))
    )
  )

ThisBuild / githubWorkflowJobSetup ++= Seq(
  WorkflowStep.Run(
    List("sudo apt-get update", "sudo apt-get install libyaml-dev"),
    name = Some("Install libyaml (ubuntu)"),
    cond =
      Some("startsWith(matrix.os, 'ubuntu') && matrix.project == 'rootNative'")
  ),
  WorkflowStep.Run(
    List("brew install libyaml"),
    name = Some("Install libyaml (macos)"),
    cond =
      Some("startsWith(matrix.os, 'macos') && matrix.project == 'rootNative'")
  ),
  WorkflowStep.Run(
    List(
      "vcpkg integrate install",
      "vcpkg install --triplet x64-windows libyaml"
    ),
    name = Some("Install libyaml (windows)"),
    cond =
      Some("startsWith(matrix.os, 'windows') && matrix.project == 'rootNative'")
  )
)

ThisBuild / githubWorkflowAddedJobs += WorkflowJob(
  id = "post-build",
  name = "post build",
  needs = List("build"),
  steps = List(
    WorkflowStep.Run(
      commands = List("echo success!"),
      name = Some("post build")
    )
  ),
  scalas = Nil,
  javas = Nil
)

// NOTE apparently githubWorkflowCheck does not work as intended on windows
// due to file separator differences
ThisBuild / githubWorkflowGeneratedCI ~= {
  _.map { job =>
    if (job.id == "build")
      job.copy(
        steps = job.steps.map {
          case step: WorkflowStep.Run
              if step.commands.exists(_ contains "githubWorkflowCheck") =>
            step.copy(cond = Some("!startsWith(matrix.os, 'windows')"))
          case other => other // unchanged
        }
      )
    else job
  }
}
