# CS481-Project
# Assessment Web App

# Install Instructions
* in the Applicaton.yml located under grails-app/conf/ directory edit the environments: production: dataSource: url:, username:, password: values to your postgreSQL database info.

* next edit the server: 'contextPath': item to desired contextPath

* to acutally compile the application run the command listed in the table based on oprating system

Windows | OSX | Linux 
 --- | --- | ---
grailsw.bat package | ./grailsw package | ./grailsw package 

* the runnable war file will be located in build/libs named CS481-Project-0.1.war 

* the war file can be ran in standared java way with the recomaned command of 

java -server -Xmx921M -Dgrails.env=prod -jar DAA.war
