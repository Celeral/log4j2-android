# log4j2-android
[![Master Build Status](https://travis-ci.org/Celeral/log4j2-android.svg?branch=master)](https://travis-ci.org/Celeral/log4j2-android)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.celeral/log4j2-android/badge.svg)](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.celeral%22%20AND%20a%3A%22log4j2-android%22)
[![Javadoc](https://javadoc.io/badge/com.celeral/log4j2-android.svg)](https://www.javadoc.io/doc/com.celeral/log4j2-android)
[![Sonatype Nexus (Snapshots)](https://img.shields.io/nexus/s/https/oss.sonatype.org/com.celeral/log4j2-android.svg)](https://oss.sonatype.org/#nexus-search;gav~com.celeral~log4j2-android~~~)

Use log4j2 logger with Android projects
# Get it!

Functionality of this package is contained in Java package `com.celeral.android.logging.log4j2`

## Gradle
To use the package, you need to use the following gradle dependency. Note the scope being `runtime` since it's a runtime dependency:
```gradle
dependencies {
  runtimeOnly 'com.celeral:log4j2-android:1.0.0'
}
```

## Maven


To use the package, you need to use following Maven dependency. Note the scope being `runtime` since it's a runtime dependency:

```xml
<properties>
  ...
  <!-- Use the latest version whenever possible. -->
  <celeral.version.log4j2.android>1.0.0</celeral.version.log4j2.android>
  ...
</properties>

<dependencies>
  ...
  <dependency>
    <groupId>com.celeral</groupId>
    <artifactId>log4j2-android</artifactId>
    <version>${celeral.version.log4j2.android}</version>
    <scope>runtime</scope>
  </dependency>
  ...
</dependencies>
```

or download jars from [Central Maven repository](http://repo1.maven.org/maven2/com/celeral/log4j2-android/).

## Non-Maven

For non-Maven use cases, you download jars from [Central Maven repository](http://repo1.maven.org/maven2/com/celeral/log4j2-android/).

# Special Attention
   * Ensure that the dependency you provide is `runtime` or its equivalent
   * Ensure that from the final deployment `log4j2-core` is excluded
   * Ensure that you are not using the files in this jar anywhere in your code; if you are then there is a chance that you are doing something wrong!
