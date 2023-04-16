import laika.ast.Path.Root
import laika.ast._
import laika.config.ConfigBuilder
import laika.config.LaikaKeys
import laika.helium.Helium
import laika.helium.config._
import laika.rewrite.link.ApiLinks
import laika.rewrite.link.SourceLinks
import laika.rewrite.link.LinkConfig
import laika.theme._
import org.typelevel.sbt.TypelevelSitePlugin
import org.typelevel.sbt.TypelevelSitePlugin.autoImport.*
import org.typelevel.sbt.TypelevelVersioningPlugin.autoImport.*
import laika.sbt.LaikaPlugin.autoImport.*
import sbt._
import sbt.Keys._

object Yaml4sSitePlugin extends AutoPlugin {
  override def requires: Plugins = TypelevelSitePlugin

  override def projectSettings: Seq[Def.Setting[_]] = Seq(
    tlSiteRelatedProjects := Seq(
      "Scala K8S" -> url("https://github.com/hnaderi/scala-k8s"),
      "Circe" -> url("https://github.com/circe/circe"),
      "ZIO-json" -> url("https://github.com/zio/zio-json"),
      "Spray json" -> url("https://github.com/spray/spray-json"),
      "Play json" -> url("https://github.com/playframework/play-json"),
      "Json4s" -> url("https://github.com/json4s/json4s")
    ),
    tlSiteHeliumConfig ~= {
      _.site
        .favIcons(Favicon.internal(Root / "logo.svg", "32x32"))
        .site
        .topNavigationBar(
          homeLink = ImageLink
            .internal(Root / "index.md", Image.internal(Root / "logo.svg")),
          navLinks = Seq(
            IconLink
              .external("https://github.com/hnaderi/yaml4s/", HeliumIcon.github)
          )
        )

    }
  )
}
