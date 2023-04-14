ThisBuild / githubWorkflowBuildMatrixFailFast := Some(
  false
) // This is a huge build matrix! so it's better to find problems rather than failing prematurely.
ThisBuild / githubWorkflowOSes := Seq("ubuntu-latest")

ThisBuild / githubWorkflowBuildMatrixInclusions ++= Seq(
  MatrixInclude(Map("project" -> "rootNative"), Map("os" -> "ubuntu-latest")),
  MatrixInclude(Map("project" -> "rootNative"), Map("os" -> "ubuntu-20.04")),
  MatrixInclude(Map("project" -> "rootNative"), Map("os" -> "windows-2022")),
  MatrixInclude(Map("project" -> "rootNative"), Map("os" -> "macos-11")),
  MatrixInclude(Map("project" -> "rootNative"), Map("os" -> "macos-12"))
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
