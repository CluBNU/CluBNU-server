#!/bin/bash

cd ../clubnu-external-api/ || exit 1

if [ ! -f application.pid ]; then
  echo "PID 파일이 존재하지 않습니다. 애플리케이션이 실행 중인지 확인하세요."
  exit 1
fi

PID=$(cat application.pid)

if kill -0 "$PID" > /dev/null 2>&1; then
  echo "애플리케이션(PID: $PID)을 종료합니다..."
  kill "$PID"
  rm -f application.pid
else
  echo "PID $PID 프로세스가 존재하지 않습니다. 이미 종료되었을 수 있습니다."
  rm -f application.pid
fi
