#!/bin/sh
# ----------------------------------------------------------------------------
# Maven Wrapper Script for Unix / macOS
# ----------------------------------------------------------------------------
set -e

# Detect working Java Runtime
if ! java -version >/dev/null 2>&1; then
    if [ -d "/Applications/IntelliJ IDEA.app/Contents/jbr/Contents/Home" ]; then
        export JAVA_HOME="/Applications/IntelliJ IDEA.app/Contents/jbr/Contents/Home"
        export PATH="$JAVA_HOME/bin:$PATH"
    fi
fi

# Detect Maven if not in PATH
if ! mvn -version >/dev/null 2>&1; then
    if [ -x "/Applications/IntelliJ IDEA.app/Contents/plugins/maven/lib/maven3/bin/mvn" ]; then
        exec "/Applications/IntelliJ IDEA.app/Contents/plugins/maven/lib/maven3/bin/mvn" "$@"
    elif [ -x "/Applications/Apache NetBeans.app/Contents/Resources/netbeans/java/maven/bin/mvn" ]; then
        exec "/Applications/Apache NetBeans.app/Contents/Resources/netbeans/java/maven/bin/mvn" "$@"
    fi
fi

if mvn -version >/dev/null 2>&1; then
    exec mvn "$@"
fi

echo "Para executar pelo terminal, certifique-se de que o Java e o Maven estejam configurados."
echo "Ou simplesmente abra a pasta marcasluxo no IntelliJ IDEA e execute a classe MarcasLuxoApplication!"
exit 1
