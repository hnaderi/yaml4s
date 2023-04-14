ThisBuild / githubWorkflowBuildMatrixFailFast := Some(
  false
) // This is a huge build matrix! so it's better to find problems rather than failing prematurely.
ThisBuild / githubWorkflowOSes :=
  Seq(
    "ubuntu-latest",
    "ubuntu-20.04",
    "ubuntu-22.04",
    "macos-11",
    "macos-12",
    "windows-2022"
  )

ThisBuild / githubWorkflowJobSetup ++= Seq(
  WorkflowStep.Run(
    List("sudo apt-get update", "sudo apt-get install libyaml-dev"),
    name = Some("Install libyaml (ubuntu)"),
    cond = Some("startsWith(matrix.os, 'ubuntu')")
  ),
  WorkflowStep.Run(
    List("brew install libyaml"),
    name = Some("Install libyaml (macos)"),
    cond = Some("startsWith(matrix.os, 'macos')")
  ),
  WorkflowStep.Run(
    List(
      "vcpkg integrate install",
      "vcpkg install --triplet x64-windows libyaml"
    ),
    name = Some("Install libyaml (windows)"),
    cond = Some("startsWith(matrix.os, 'windows')")
  )
)
