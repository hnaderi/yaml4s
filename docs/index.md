## yaml4s

## Setup

This library is currently available for Scala binary versions 2.12, 2.13 and 3.2 on JVM, JS and Native.

To use the latest version, include the following in your `build.sbt`:

```scala
libraryDependencies ++= Seq(
  // Cross platform yaml parsing and printing
  "dev.hnaderi" %%% "yaml4s-backend" % "@VERSION@",

  // JSON library integrations
  "dev.hnaderi" %%% "yaml4s-circe" % "@VERSION@",
  "dev.hnaderi" %%% "yaml4s-json4s" % "@VERSION@",
  "dev.hnaderi" %%% "yaml4s-play-json" % "@VERSION@",
  "dev.hnaderi" %%% "yaml4s-zio-json" % "@VERSION@",
  "dev.hnaderi" %%% "yaml4s-spray-json" % "@VERSION@",

  // Or specific backends
  // libyaml is a native only backend using official libyaml C library
  "dev.hnaderi" %%% "yaml4s-libyaml" % "@VERSION@",
  // snake yaml is a jvm only backend
  "dev.hnaderi" %%% "yaml4s-snake" % "@VERSION@",
  // js yaml is a js only backend using `js-yaml` library
  "dev.hnaderi" %%% "yaml4s-jsyaml" % "@VERSION@",
)
```

## Usage

When using `yaml4s-backend`, you can simply use the following:
```scala mdoc
import dev.hnaderi.yaml4s._

Backend.parse[YAML]("""
data:
  - 1
  - 2
  - 3
""")

// Or print to string
Backend.print(
  YAML.obj("data" -> YAML.arr(
      YAML.number(1),
      YAML.number(2),
      YAML.number(3)
    )
  )
)
```

You can also use json data structures from your favorite json library:

### Circe
```scala mdoc:nest
import dev.hnaderi.yaml4s.circe._
import io.circe.Json

Backend.parse[Json]("""
data:
  - 1
  - 2
  - 3
""")

// Or print to string
Backend.print(
  Json.obj("data" -> Json.arr(
      Json.fromInt(1),
      Json.fromInt(2),
      Json.fromInt(3)
    )
  )
)
```

### Zio Json
```scala mdoc:nest
import dev.hnaderi.yaml4s.ziojson._
import zio.json.ast.Json

Backend.parse[Json]("""
data:
  - 1
  - 2
  - 3
""")

```

### Play json
```scala mdoc:nest
import dev.hnaderi.yaml4s.playjson._
import play.api.libs.json.JsValue

Backend.parse[JsValue]("""
data:
  - 1
  - 2
  - 3
""")

```

### Spray json
```scala mdoc:nest
import dev.hnaderi.yaml4s.sprayjson._
import spray.json.JsValue

Backend.parse[JsValue]("""
data:
  - 1
  - 2
  - 3
""")

```

### json4s json
```scala mdoc:nest
import dev.hnaderi.yaml4s.json4s._
import org.json4s.JValue

Backend.parse[JValue]("""
data:
  - 1
  - 2
  - 3
""")

```
