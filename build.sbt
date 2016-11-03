name := "recogito-plugin-sdk"

version := "0.0.1"

scalaVersion := "2.11.7"

resolvers += "typesafe" at "http://repo.typesafe.com/typesafe/releases/"

/** Runtime dependencies **/
libraryDependencies ++= Seq()

/** Test dependencies **/
libraryDependencies ++= Seq(
  "junit" % "junit" % "4.11" % "test"
)
