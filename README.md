# Spock Global Unroll extension
[![Build Status](https://travis-ci.org/szpak/spock-global-unroll.svg?branch=master)](https://travis-ci.org/szpak/spock-global-unroll)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/info.solidsoft.spock/spock-global-unroll/badge.svg)](https://maven-badges.herokuapp.com/maven-central/info.solidsoft.spock/spock-global-unroll)

Spock extension automatically enabling parametrized tests unrolling in the whole project.

## Quick start

It is enough to put the spock-gradle-unroll JAR on a classpath. No additional configuration is required.
All parametrized tests (features) will unrolled automatically as the `@Unroll` annotation would be put on it.

## Configuration in a project

spock-global-unroll jars are available in Maven Central.

### Gradle

```
testCompile 'info.solidsoft.spock:spock-global-unroll:0.5.0'
testCompile 'org.spockframework:spock-core:1.0-groovy-2.4'  //required as spock-global-unroll assumes that spock-core is provided
```

### Maven

```
<dependency>
    <groupId>info.solidsoft.spock</groupId>
    <artifactId>spock-global-unroll</artifactId>
    <version>0.5.0</version>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>org.spockframework</groupId>
    <artifactId>spock-core</artifactId>
    <version>1.0-groovy-2.4</version>
    <scope>test</scope>
</dependency>
```

**Please note** that to make it easier to use spock-global-unroll with different Spock versions (like 1.0-groovy-2.0 and 1.0-groovy-2.3)
the plugin does not have compile dependency on Spock and a proper spock-core jar has to be explicitly defined in a build configuration.

## Spock compatibility

spock-global-unroll should be compatible with Spock 1.0 and possibly with its further versions.

## Usage

### Basic usage

spock-global-unroll is implemented as Spock global extension. It means that it enabled automatically when the spock-global-unroll jar is put on
a classpath. No further configuration is required.

### Disable automatic unrolling for a class

Automatic unrolling can be disabled for a particular class by putting `@DisableGlobalUnroll` on it.
 
Please note that the `@Unroll` annotations manually placed at the test (feature) level can be used to unroll particular tests anyway.

### Overriding default test name

To override default test name expanding (with `#placeHolders` in a test name) `@Unroll` annotation with a custom text can used on top of
a feature method or at the specification level.

## Rationale

I've been always frustrated with the need to add `@Unroll` annotation for every parametrized test/feature (or at least at the class/specification
level) to make unrolling works. It was even worse to deal with code with already missing `@Unroll` annotations and cryptic test results.
Being able to implement automatic tests unrolling in a few lines of code I decided to share it with others.

## Additional information 

spock-global-unroll has been written by Marcin Zajączkowski. The author can be contacted directly via email: mszpak ATT wp DOTT pl.
There is also Marcin's blog available: [Solid Soft](http://blog.solidsoft.info/) - working code is not enough.

Issues and features requests can be raised using the [issue tracker](https://github.com/szpak/spock-global-unroll/issues).
Question can be asked using the Spock [mailing list/forum](https://groups.google.com/forum/#!forum/spockframework).

Please note that spock-global-unroll is a separate project and is NOT supported by The Spock Core Team.

The library is licensed under the terms of [the Apache License, Version 2.0](https://www.apache.org/licenses/LICENSE-2.0.txt).
