#!/bin/bash
#static var's
application_Loc="grails-app/conf/application.yml"

echo "Data Assessment App compile script"
echo "Application.yml editable items"

URL_DEFAULT="jdbc:postgresql://localhost:5432/CS481"
read -p "Please enter database url [$URL_DEFAULT]: " URL
URL="${URL:-$URL_DEFAULT}"
USERNAME_DEFAULT="postgres"
read -p "Please enter database username [$USERNAME_DEFAULT]: " USERNAME
USERNAME="${USERNAME:-$USERNAME_DEFAULT}"
read -sp "Please enter database password: " PASSWORD
CONTEXT_PATH_DEFAULT="/DAA"
read -p "Please enter Context Path [$CONTEXT_PATH_DEFAULT]: " CONTEXT_PATH
CONTEXT_PATH="${CONTEXT_PATH:-$CONTEXT_PATH_DEFAULT}"

echo "applying changes to application.yml"
sed -i "116s|url: \"jdbc:postgresql://localhost:5432/CS481\"|url: \"$URL\" |" $application_Loc
sed -i "120s|username: postgres|username: $USERNAME|" $application_Loc
sed -i "121s|password: mage1996|password: $PASSWORD|" $application_Loc
sed -i "121s|'contextPath': '/DAA'|'contextPath': '$CONTEXT_PATH'|" $application_Loc

echo "compiling program"
./grailsw package

echo "moving war to home directory"
cp build/libs/Assessment-App-0.1.war Assessment-App.war
