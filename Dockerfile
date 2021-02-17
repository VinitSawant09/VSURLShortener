FROM tomcat:latest
COPY ./build/libs/vsurlshortener.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD [ "catalina.sh", "run" ]
