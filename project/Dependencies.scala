package xyz.funnycoding.sbt

import sbt._

object Dependencies {
  // Misc
  lazy val enumeratumVersion = "1.5.13"

  // Test
  lazy val scalaTestVersion = "3.0.5"
  // JSon
  lazy val circeVersion = "0.12.0-M3"
  // ZIO
  lazy val zioVersion = "1.0-RC4"
  // functional lib
  lazy val catsVersion = "2.0.0-M4"

  lazy val jsonDependencies = List(
    "io.circe" %% "circe-core",
    "io.circe" %% "circe-generic",
    "io.circe" %% "circe-parser"
  ).map(_ % circeVersion)

  lazy val functionalDependencies = List(
    "org.typelevel" %% "cats-core" % catsVersion
  )
  lazy val zioDependencies = List(
    "org.scalaz" %% "scalaz-zio" % zioVersion,
    "org.scalaz" %% "scalaz-zio-streams" % zioVersion
  )

  lazy val testDependencies = List(
    "org.scalatest" %% "scalatest" % "3.0.5" % Test
  )

  lazy val miscDependencies = List(
    "com.beachape" %% "enumeratum" % enumeratumVersion
  )

  lazy val all = zioDependencies ++ testDependencies ++ miscDependencies ++ jsonDependencies ++ functionalDependencies
}
