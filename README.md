# eipa-Solution
Solution for fetching EIPA data.

Project is developed on `project` branch.

The approach for this project is to fetch all data from `eipa.udt.gov.pl` and proccess it into events.

In this approach I assumed that for the consumer newset data are more important.

The cron job is runing every 30 seconds and it's consuming dynamic data from `eipa.udt.gov.pl/reader/export-data/dynamic/` endpoint.
Then all data's are filtered, and in next step all data's are converted to a propper event object. After conversion the event object is beeing send into POST endpoint that You can configure from `application.yml` file.

---

Project is runinng on Spring Boot with Java 11. 

To startup project you need to provide API_KEY by VM options `-Dapi_key=YourFancyApiKey`. Or if you for some reason don't like the VM options, you can modify the `application.yml` file.

The Project is using PostgreSQL, you can run this through docker-compose (I've added files in docker folder) `docker-compose up -d`
For setting up database, you ony need to run mvn command `mvn compile package` Liquibase will take his part and create database (Awesome! :rocket:)

To startup project you can:

(I assume that You have instaled java 11 and maven on your machine.)

1) Import project into inteliJ, change `api_key:` propperty in `application.yml` file. Then use `mvn clean package` and run program from intelij.
2) Go to project folder, run command `mvn clean package` after sucessufly instalation go to `target` folder and run `java -jar -Dapi_key=YourApiKey EIPA-0.0.1-SNAPSHOT.jar` command! 

---

In `application.yml` file You can edit other fancy settings!

You can change scheduler settings
```
event:
  crone:
    time: "*/30 * * * * *" #every 30 second
    zone: "Europe/Warsaw"
```

or You can change on which endpoint, events will be send!
```
event:
  response:
    post:
      url: "http://localhost:8080/api/eipa/event/consumer"
```

---

NOTE!: There is an POST endpoint created only for testing purpose. It does nothing, only consuming event object and logging it into console. You can find it in `EipaController` or under `POST: /api/eipa/event/consumer` endpoint.

Have Fun with checking my solution! (I'am still learning, if you see any improvement that could be done, tell me! cheers:beer:) :rocket: :moon:
