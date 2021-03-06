name := "recogito-plugin-sdk"

organization := "org.pelagios"

version := "2.0-RC"

scalaVersion := "2.11.11"

// Do not append Scala versions to the generated artifacts
crossPaths := false

// This forbids including Scala related libraries into the dependency
autoScalaLibrary := false

/** Runtime dependencies **/
libraryDependencies ++= Seq()

/** Test dependencies **/
libraryDependencies ++= Seq(
  "junit" % "junit" % "4.11" % "test",
  "com.novocode" % "junit-interface" % "0.11" % Test exclude("junit", "junit-dep")
)
