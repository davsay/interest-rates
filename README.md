# interest_rates

## Build and Run
Ensure you have that latest version of maven
https://maven.apache.org/download.cgi

This Project is running on openjdk-20 [Oracle OpenJDK version 20.0.1]

Build project in the base directory with command
```
mvn clean install
```

Run Application with command
```
java -jar target/interest_rates_test-1.0-SNAPSHOT-jar-with-dependencies.jar 1001

```
1001 is the amount passed to generate interest for. You can pass any number. These can be space seperated to pass multiple amount to calculate for.