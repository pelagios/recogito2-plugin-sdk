# Recogito Plugin SDK

Base classes to build plugins for [Recogito](http://github.com/pelagios/recogito2).
__Work in progress!__ Currently, Recogito provides only a single extension point, which
allows plugging in alternative Named Entity Recognition engines. Need something else?
Get in touch via the [Recogito Users Forum](http://commons.pelagios.org/groups/recogito-users/)
or open a ticket on the [issue tracker](https://github.com/pelagios/recogito2-plugin-sdk/issues).

## Writing your own Plugin

The Recogito plugin API is based on the Java Virtual Machine (JVM). Tools that are written in Java
or any [JVM language](https://en.wikipedia.org/wiki/List_of_JVM_languages) can be turned
into a Recogito plugin natively.

Simply provide a wrapper that implements the
[`org.pelagios.recogito.sdk.ner.NERPlugin`](https://github.com/pelagios/recogito2-plugin-sdk/blob/master/src/main/java/org/pelagios/recogito/sdk/ner/NERPlugin.java) interface. See the
[examples](https://github.com/pelagios/recogito2-plugin-sdk/tree/master/src/main/java/org/pelagios/recogito/sdk/examples/ner)
for a minimal plugin that shows how the interface works. A more comprehensive example that
wraps the [Stanford CoreNLP](http://stanfordnlp.github.io/CoreNLP/) Named Entity Recognition library is [available here](https://github.com/pelagios/recogito2/tree/master/plugins/org.pelagios/recogito.plugins.ner.stanford).

The use of non-JVM programming
languages (or external Web services) is also possible. However, you still need to provide a
JVM wrapper that calls out to the external tool or service.

To use the SDK in your code, add the `recogito-plugin-sdk-0.0.1.jar` file to your project, either
as an unmanaged dependency [(download here)](https://github.com/pelagios/recogito2-plugin-sdk/releases/download/v0.0.1/recogito-plugin-sdk-0.0.1.jar),
or by adding it to your build path with your favourite build tool. E.g. in SBT:

```
libraryDependencies ++= "org.pelagios" % "recogito-plugin-sdk" % "0.0.1" from "https://github.com/pelagios/recogito2-plugin-sdk/releases/download/v0.0.1/recogito-plugin-sdk-0.0.1.jar"
 ```

## Building your plugin

Build your plugin as a .jar file. Make sure you add a [provider configuration file](http://docs.oracle.com/javase/7/docs/api/java/util/ServiceLoader.html) to the jar, so
that Recogito can load it. The configuration file is a simple text file, named
`org.pelagios.recogito.sdk.ner.NERPlugin`, located in the `META-INF/services` folder.
The file must contain a single line: the fully qualified name of your class that implements
the interface. E.g.: `com.example.recogito.plugins.MyNERPlugin`.

## Using your plugin

To use your plugin in Recogito, place it anywhere in the `plugins` folder (preferably a subfolder
you create), and restart Recogito.

## Building the SDK

Just in case you want to build the SDK from source, use `sbt package`. The SDK .jar will be
in the `target` folder.
