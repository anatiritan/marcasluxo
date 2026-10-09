@REM ----------------------------------------------------------------------------
@REM Maven Wrapper Script for Windows
@REM ----------------------------------------------------------------------------
@echo off
setlocal

WHERE mvn >nul 2>nul
IF %ERRORLEVEL% EQU 0 (
    mvn %*
    exit /b %ERRORLEVEL%
)

echo Execute este projeto atraves da sua IDE preferida (IntelliJ IDEA, Eclipse, VS Code).
echo Basta abrir a pasta marcasluxo e rodar a classe MarcasLuxoApplication.
