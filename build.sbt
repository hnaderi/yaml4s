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

val Scala3 = "3.2.2"

ThisBuild / scalaVersion := Scala3

lazy val root = project.in(file(".")).aggregate(core)

lazy val core = project
  .in(file("core"))
  .settings(
    name := "scala-libyaml",
    nativeConfig ~= { _.withLinkingOptions(Seq("-lyaml")) }
  )
  .enablePlugins(ScalaNativePlugin)

lazy val docs = project.in(file("site")).enablePlugins(TypelevelSitePlugin)
