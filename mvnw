#!/bin/sh
# ----------------------------------------------------------------------------
# Maven Wrapper Script for Unix / macOS
# ----------------------------------------------------------------------------
set -e

[ -z "$MAVEN_HOME" ] || MAVEN_HOME=''

case "`uname`" in
  CYGWIN* ) cygwin=true ;;
  MINGW* ) mingw=true ;;
esac

PRG="$0"
while [ -h "$PRG" ] ; do
  ls=`ls -ld "$PRG"`
  link=`expr "$ls" : '.*-> \(.*\)$'`
  if expr "$link" : '/.*' > /dev/null; then
    PRG="$link"
  else
    PRG="`dirname "$PRG"`/$link"
  fi
done
SAVED="`pwd`"
cd "`dirname \"$PRG\"`" >/dev/null
APP_HOME="`pwd -P`"
cd "$SAVED" >/dev/null

WRAPPER_JAR="$APP_HOME/.mvn/wrapper/maven-wrapper.jar"
WRAPPER_PROP="$APP_HOME/.mvn/wrapper/maven-wrapper.properties"

if command -v mvn >/dev/null 2>&1; then
    exec mvn "$@"
fi

if [ -f "$WRAPPER_JAR" ]; then
    exec java -jar "$WRAPPER_JAR" "$@"
fi

echo "Maven ou Java precisam estar instalados no seu ambiente para executar o Maven Wrapper."
echo "Abra o projeto na sua IDE favorita (IntelliJ IDEA, Eclipse ou VS Code) para compilar e rodar facilmente!"
exit 1
