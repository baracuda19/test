SHS services project
====================

Created from shs-template (http://SG0xxxxxx@git.sabre.com/scm/~sg0xxxxxx/shs-template.git) project

#Project Setup
------------------

* Ensure that you have the following Maven mirror in your ~/.m2/settings.xml file:

    <mirror>
      <id>sabre-central</id>
      <mirrorOf>central</mirrorOf>
      <name>Central mirror</name>
      <url>http://maven.sabre.com/content/groups/public/</url>
    </mirror>
    
Key functionalities:
--------------------
- Annotation-based logging of metrics using EI API (@LogMetrics)
- Health Check monitoring (http://localhost:8080/shs-services/admin/health/checks) framework.
- eLogging web console - http://localhost:8080/shs-services/admin/monitor/elogging/MonitorSummary
- Couchbase client 
- List of all endpoints - http://localhost:8080/shs-services/admin/endpoints
- Monitor TPS (helpful when load testing the app) - http://localhost:8080/shs-services/admin/monitor/metrics/tps
- Spring for REST APIs
- Uses Radius (http://techteams2.sabre.com/EnterpriseServices/EnterpriseArch/radius/Wiki%20Pages/Session%20Pooling%20using%20radius-session.jar.aspx) for Sabre Web Services session pooling

Dependencies:
------------
Project is dependent on following projects:
- darwin-commons (http://git.dev.sabre.com/git/darwin-commons)
- darwin-parent (http://git.dev.sabre.com/git/darwin-parent)

Running the project:
--------------------
- Set -Denviornment=local to run the project locally
- Configuration file (application.properties) per environment is under src/main/resources folder.
- Requires Java 8


