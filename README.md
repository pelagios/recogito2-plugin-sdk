# Recogito Plugin SDK

Base classes to build plugins for [Recogito](http://github.com/pelagios/recogito2).
__Work in progress!__ Currently, Recogito provides only a single extension point, which
allows plugging in alternative Named Entity Recognition engines. Need something else?
Get in touch via the [Recogito Users Forum](http://commons.pelagios.org/groups/recogito-users/)
or open a ticket on the [issue tracker](https://github.com/pelagios/recogito2-plugin-sdk/issues).

# Creating your own Plugin

The Recogito plugin API is based on the Java Virtual Machine (JVM). Tools that are written in Java
or any other [JVM language](https://en.wikipedia.org/wiki/List_of_JVM_languages) can be turned
natively into a Recogito plugin. In to do that, you need to provide a wrapper that implements the
`org.pelagios.recogito.sdk.ner.NERInterface`. See the
[examples](https://github.com/pelagios/recogito2-plugin-sdk/tree/master/src/main/java/org/pelagios/recogito/sdk/examples/ner)
for a minimal plugin that illustrates how the interface works.

The use of non-JVM programming languages or external Web services is also possible. But you will
still need to provide a JVM wrapper that calls out to the tools or service.

## Using the SDK

To use the SDK, add the `recogito-plugin-sdk-0.0.1.jar` file to your project, either as an
unmanaged dependency [(download here)](https://github.com/pelagios/recogito2-plugin-sdk/releases/download/v0.0.1/recogito-plugin-sdk-0.0.1.jar)
or by adding it to your build path with your favourite build tool. E.g. example for SBT:

```
libraryDependencies ++= "org.pelagios" % "recogito-plugin-sdk" % "0.0.1" from "https://github.com/pelagios/recogito2-plugin-sdk/releases/download/v0.0.1/recogito-plugin-sdk-0.0.1.jar"
 ```

## Building the SDK

Just in case you want to build the SDK from source, use `sbt package`. The SDK .jar will be
in the `target` folder.
