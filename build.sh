#!/bin/bash

export JAVA_HOME="/Users/kalakshetra2/Documents/tools/jdk-17.0.2.jdk/Contents/Home"
export MAVEN_HOME="/Users/kalakshetra2/Documents/tools/apache-maven-3.9.4"
export M2_HOME="/Users/kalakshetra2/Documents/tools/apache-maven-3.9.4"
export PATH="/Users/kalakshetra2/Documents/tools/jdk-17.0.2.jdk/Contents/Home/bin:/Users/kalakshetra2/Documents/tools/apache-maven-3.9.4/bin:$PATH"
echo $PATH
mvn clean install -U
mvn eclipse:clean -Dwtpversion=2.0
mvn eclipse:eclipse -Dwtpversion=2.0
pause




