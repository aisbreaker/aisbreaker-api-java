#!/bin/bash

# required environment variables:
# - ORG_GRADLE_PROJECT_signingInMemoryKey
# - ORG_GRADLE_PROJECT_signingInMemoryKeyPassword
# - ORG_GRADLE_PROJECT_mavenCentralUsername
# - ORG_GRADLE_PROJECT_mavenCentralPassword

# check if the required environment variables are set
if [ -z "$ORG_GRADLE_PROJECT_signingInMemoryKey" ]; then
  echo "ERROR: Environment variable ORG_GRADLE_PROJECT_signingInMemoryKey is not set but required"
  exit 1
fi
if [ -z "$ORG_GRADLE_PROJECT_signingInMemoryKeyPassword" ]; then
  echo "ERROR: Environment variable ORG_GRADLE_PROJECT_signingInMemoryKeyPassword is not set but required"
  exit 1
fi
if [ -z "$ORG_GRADLE_PROJECT_mavenCentralUsername" ]; then
  echo "ERROR: Environment variable ORG_GRADLE_PROJECT_mavenCentralUsername is not set but required"
  exit 1
fi
if [ -z "$ORG_GRADLE_PROJECT_mavenCentralPassword" ]; then
  echo "ERROR: Environment variable ORG_GRADLE_PROJECT_mavenCentralPassword is not set but required"
  exit 1
fi

# publish to Maven Central
#./gradlew clean build publishAndReleaseToMavenCentral --no-configuration-cache --info
./gradlew publishAndReleaseToMavenCentral --no-configuration-cache --info
