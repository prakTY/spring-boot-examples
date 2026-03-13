@echo off
setlocal enabledelayedexpansion

set APP_NAME=demo
set JAR_FILE=target\demo-0.0.1-SNAPSHOT.jar

if "%1"=="start" (
    echo Starting application...
    if not exist logs mkdir logs
    start java -jar %JAR_FILE%
    echo Application started successfully
) else if "%1"=="stop" (
    echo Stopping application...
    taskkill /F /IM java.exe
    echo Application stopped
) else (
    echo Usage: %0 start^|stop
)