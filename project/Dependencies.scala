package xyz.funnycoding.sbt

import sbt._

object Dependencies {
  // Misc
  lazy val enumeratumVersion = "1.5.13"

  // Test
  lazy val scalaTestVersion = "3.0.5"

  // ZIO
  lazy val zioVersion = "1.0-RC4"

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

  lazy val all = zioDependencies ++ testDependencies ++ miscDependencies
}
