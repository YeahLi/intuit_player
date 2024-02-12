1. How to run app in prod mode:
   - Run cmd 
   
      `docker compose -f docker/compose.yml up -d` 
   
   The compose file will first start a `mysql` container, then start our `player-rest` container. Our application container will first use liquibase to load the csv file into mysql DB, then it will start up the web service listening on port 8888.
   
   - The swagger link is: `http://localhost:8888/swagger-ui/index.html`


2. How to run app in local:
   - a. Start up local mysql docker container:
      
       `docker compose -f docker/local/compose.yml up -d`
   
   - b. Run application under `api/src/main/java/com/intuit/player/Application.java`
   - c. Server will start and listen on port 8080.
   - d. Swagger link is: `http://localhost:8080/swagger-ui/index.html`


3. How to run test:
   - a. Start local mysql docker container. Kill the previous running one if necessary. The test will use a small part of csv file for the testing purpose. More details is here: `dao/src/test/resources`
   - b. Under base directory, run command:

      `mvn -Dtest="**/*IT" -Dsurefire.failIfNoSpecifiedTests=false test`
   

4. How to release the app as docker image:
   - a. Run test as mentioned above
   - b. Under base directory, run `mvn package`. As the tests are named as `xxxIT` and not specially configured the test plugin, the test will be skipped for real world release process.
   - c. Go to `api` directory and run cmd `docker build -t liye198995/player-rest .`
   
    The prepared built image is located at: https://hub.docker.com/repository/docker/liye198995/player-rest/general