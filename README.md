<p align="center">
  <img src="./docs/logo.svg" height="100px" alt="Yaml4s icon" />
  <br/>
  <strong>Yaml4s</strong>
  <i>(Cross platform YAML for Scala, Scala.js and scala native)</i>
</p>

[![yaml4s-core Scala version support](https://index.scala-lang.org/hnaderi/yaml4s/yaml4s-core/latest.svg?style=flat-square)](https://index.scala-lang.org/hnaderi/yaml4s/yaml4s-core)
[![javadoc](https://javadoc.io/badge2/dev.hnaderi/yaml4s-docs_3/scaladoc.svg?style=flat-square)](https://javadoc.io/doc/dev.hnaderi/yaml4s-docs_3) 
<img alt="GitHub Workflow Status" src="https://img.shields.io/github/actions/workflow/status/hnaderi/yaml4s/ci.yml?style=flat-square">
<img alt="GitHub" src="https://img.shields.io/github/license/hnaderi/yaml4s?style=flat-square">  
[![Scala Steward badge](https://img.shields.io/badge/Scala_Steward-helping-blue.svg?style=flat-square&logo=data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAA4AAAAQCAMAAAARSr4IAAAAVFBMVEUAAACHjojlOy5NWlrKzcYRKjGFjIbp293YycuLa3pYY2LSqql4f3pCUFTgSjNodYRmcXUsPD/NTTbjRS+2jomhgnzNc223cGvZS0HaSD0XLjbaSjElhIr+AAAAAXRSTlMAQObYZgAAAHlJREFUCNdNyosOwyAIhWHAQS1Vt7a77/3fcxxdmv0xwmckutAR1nkm4ggbyEcg/wWmlGLDAA3oL50xi6fk5ffZ3E2E3QfZDCcCN2YtbEWZt+Drc6u6rlqv7Uk0LdKqqr5rk2UCRXOk0vmQKGfc94nOJyQjouF9H/wCc9gECEYfONoAAAAASUVORK5CYII=)](https://scala-steward.org)

## What is this library?
This library is a cross platform yaml parsing and printing library that supports full yaml spec (1.2 on jvm and js, 1.1 on native),
that focuses on simplicity, extensibility while remaining ecosystem agnostic.  
Aside from its own data model (named `YAML`), this library also supports and provides several integrations with popular json libraries,
in which you can parse to and print from directly, without any intermediate object generation.  
Current integrations include: `circe`, `zio json`, `play json`, `json4s`, `spray json`, 
also integrations can be added very easily, open an issue or submit a PR if you want any other integrations with other major libraries.

## What this library is not?
If you want a full blown yaml manipulation library with direct yaml AST support, this library is not the solution to your problem;
however if you want using YAML as a serialization format this library is the perfect choice, as it adds support for latest YAML spec to your
favorite JSON library and you don't need to learn something new or deal with complex YAML syntax!

## Why this library?
<p align="center">
  <img src="./docs/meme.jpg" alt="Angel tells a man: It says you should be in hell, but since you were a YAML engineer, we will consider that as time served." />
</p>

YAML can easily be the worst serialization format you may encounter in your career, but it's life and we need to do shit sometimes!  
This library is a pragmatic solution that tries to empower the scala ecosystem and all of its tribes by adding the YAML support to other existing libraries.  
If all you want is reading and writing YAML, with complete spec support, without trying to implement it from scratch in Scala, this library is the perfect fit.

Besides that, it's here to warm your heart in those dark times you need to work with YAML!

## Getting started
visit [Project site](https://projects.hnaderi.dev/yaml4s/) to see tutorials and docs.

