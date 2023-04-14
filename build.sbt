import sbtcrossproject.CrossProject

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

val Scala212 = "2.12.17"
val Scala213 = "2.13.10"
val Scala3 = "3.2.2"

ThisBuild / scalaVersion := Scala212
ThisBuild / crossScalaVersions := Seq(Scala3, Scala213, Scala212)

lazy val root = tlCrossRootProject.aggregate(
  core,
  libyaml,
  jsyaml,
  snakeyaml,
  docs
)

def module(mname: String): CrossProject => CrossProject =
  _.in(file(s"modules/$mname"))
    .settings(
      name := s"module-$mname",
      libraryDependencies ++= Seq(
        "org.scalameta" %%% "munit" % "1.0.0-M7" % Test,
        "org.scalameta" %%% "munit-scalacheck" % "1.0.0-M7" % Test
      ),
      moduleName := s"yaml4s-$mname"
    )

lazy val core = module("core") {
  crossProject(NativePlatform, JSPlatform, JVMPlatform)
    .crossType(CrossType.Pure)
}

lazy val libyaml = module("libyaml") {
  crossProject(NativePlatform)
    .crossType(CrossType.Pure)
    .dependsOn(core)
}

lazy val jsyaml = module("jsyaml") {
  crossProject(JSPlatform)
    .crossType(CrossType.Pure)
    .dependsOn(core)
    .settings(
      Compile / npmDependencies ++= Seq("js-yaml" -> "4.1.0"),
      scalaJSUseMainModuleInitializer := true,
      scalaJSLinkerConfig ~= (_.withModuleKind(ModuleKind.CommonJSModule))
    )
    .enablePlugins(ScalaJSBundlerPlugin)
}

lazy val snakeyaml = module("snake") {
  crossProject(JVMPlatform)
    .crossType(CrossType.Pure)
    .dependsOn(core)
    .settings(
      libraryDependencies += "org.snakeyaml" % "snakeyaml-engine" % "2.6"
    )
}

lazy val docs = project.in(file("site")).enablePlugins(TypelevelSitePlugin)
