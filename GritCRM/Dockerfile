# Step 1 - Select a base image
FROM tomcat:11.0-jdk25

# Step 2 - Remove the default application
RUN rm -rf /usr/local/tomcat/webapps/ROOT

# Step 3 - Copy new default application
COPY target/*.war /usr/local/tomcat/webapps/ROOT.war

# Steg 4 - Expose tomcats default port
EXPOSE 8080

# Step 5 - Start tomcat
CMD ["catalina.sh", "run"]