ThisBuild / tlBaseVersion := "0.0"

ThisBuild / organization := "dev.hnaderi"
ThisBuild / organizationName := "Hossein Naderi"
ThisBuild / startYear := Some(2023)
ThisBuild / licenses := Seq(License.Apache2)
ThisBuild / developers := List(
  tlGitHubDev("hnaderi", "Hossein Naderi")
)

ThisBuild / tlSonatypeUseLegacyHost := false

ThisBuild / tlSitePublishBranch := Some("main")
ThisBuild / tlCiReleaseBranches := Nil

val Scala3 = "3.2.2"

ThisBuild / scalaVersion := Scala3

lazy val root = tlCrossRootProject.aggregate(
  core,
  libyaml,
  docs
)

lazy val core = crossProject(NativePlatform, JSPlatform, JVMPlatform)
  .crossType(CrossType.Pure)
  .in(file("modules/core"))
  .settings(
    name := "yaml4s"
  )

lazy val libyaml = crossProject(NativePlatform)
  .crossType(CrossType.Pure)
  .in(file("modules/libyaml"))
  .dependsOn(core)
  .settings(
    name := "yaml4s-libyaml",
    nativeConfig ~= { _.withLinkingOptions(Seq("-lyaml")) }
  )

lazy val docs = project.in(file("site")).enablePlugins(TypelevelSitePlugin)
