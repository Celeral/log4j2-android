# log4j2-android
[![Master Build Status](https://travis-ci.org/Celeral/log4j2-android.svg?branch=master)](https://travis-ci.org/Celeral/log4j2-android)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.celeral/log4j2-android/badge.svg)](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.celeral%22%20AND%20a%3A%22log4j2-android%22)
[![Javadoc](https://javadoc.io/badge/com.celeral/log4j2-android.svg)](https://www.javadoc.io/doc/com.celeral/log4j2-android)
[![Sonatype Nexus (Snapshots)](https://img.shields.io/nexus/s/https/oss.sonatype.org/com.celeral/log4j2-android.svg)](https://oss.sonatype.org/#nexus-search;gav~com.celeral~log4j2-android~~~)

Use log4j2 API within your Android projects instead of Android's Log API. A side effect is that log4j2 logger in dependencies also work seamlessly on Android as it does in non-android projects.  

# Special Attention
   * Ensure that the dependency you provide for log4j2-android is `runtime` or its equivalent
   * Ensure that from the final deployment `log4j-core` library is excluded. log4j2-android is a functional replacement for log4j-core, including both might create unexpected behavior.
   * log4j2-android is a runtime library. Naturally, you do not need to modify your android code in any way. You just need to change the dependencies. If you are referencing the classes included in log4j2-android in your code, then there is a good chance that you are doing something wrong!
   * FWIW - I use the following build.gradle snippet in my Android project so that I am able to use log4j-core for junit testing, and log4j2-android for Android testing in the same project. 
   ```groovy
configurations.all {
    config -> {
        if (config.name.startsWith("test") || config.name.contains("Test") && !config.name.contains("Android")) {
            exclude group: "com.celeral", module: "log4j2-android"
        } else {
            exclude group:"org.apache.logging.log4j", module:"log4j-core"
        }
    }
    resolutionStrategy {
        force "org.apache.logging.log4j:log4j-api:2.17.2"
    }
}

dependencies {
    implementation "org.apache.logging.log4j:log4j-api:2.17.2"
    testRuntimeOnly "org.apache.logging.log4j:log4j-core:2.17.2"
    runtimeOnly "com.celeral:log4j2-android:1.0.0"
}
   ```

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
