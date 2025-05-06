#!/bin/bash

cd .. || exit 1

./gradlew clean build || { echo "Gradle build failed"; exit 1; }

cd clubnu-external-api/ || exit 1

JAR=$(find build/libs -name "*SNAPSHOT.jar" ! -name "*-plain.jar" | head -n 1)

if [ -z "$JAR" ]; then
  echo "JAR 파일을 찾을 수 없습니다."
  exit 1
fi

echo "실행 중: $JAR"
java -Dspring.profiles.active=local -jar "$JAR" &
echo $! > application.pid
