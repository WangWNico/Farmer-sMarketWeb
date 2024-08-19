#!/bin/bash

# Navigate to the project directory
cd "$(dirname "$0")/.."

# Ensure the docs directory exists
mkdir -p docs

# Compile Javadoc and place it in the docs folder
./mvnw javadoc:javadoc -DoutputDirectory=docs

# Output the location of the generated Javadoc
echo "Javadoc generated in docs"