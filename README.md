# aisbreaker-api-java

## Deprecation

**This repository will no longer be actively developed. For more details, please read: [AIsBreaker API is Now Deprecated - We Recommend Using LangChain Instead](https://aisbreaker.org/blog/2024-09-08-aisbreaker-api-deprecation-langchain-recommendation)**


## aisbreaker-api-java

This is the source code of the JVM API for [AIsBreaker.org](https://aisbreaker.org/)
to use the AIsBreaker in your Java, Kotlin or any other JVM application.

Java package: `org.aisbreaker:aisbreaker-api-java`


## Use the Library
Docs and more: [AIsBreaker.org: Getting Started - with Java/Kotlin/JVM](https://aisbreaker.org/docs/getting-started-with-java)

Simple usage example: see [aisbreaker-example-simple-chat-java](https://github.com/aisbreaker/aisbreaker-example-simple-chat-java/)


## Live Demo
_NOT AVAILABLE YET:_
https://onecompiler.com/java/426kgznmj


## Build the Library
_(will be done automatically by the GitHub CI/CD pipeline)_

Build and test the project:
```bash
./gradlew clean build test --info
```

Publish the project:
```bash
./gradlew-publishAndReleaseToMavenCentral.sh
```

### Change Default Java Version on Ubuntu
```
sudo update-alternatives --config java
```




