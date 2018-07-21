# Rule Engine

Readme v1.0


## Build

### Build fat jar
To build a fat jar (jar + all dependencies), execute:

```
mvn clean build
```

### Build by skipping the test
To build a fat jar (jar + all dependencies), execute:

```
mvn clean build -DskipTests
```


### Testing
To run the unit tests, execute:

```
mvn clean test
```

### Docker build
```
docker build -t rule-engine:{var} .
e.g: docker build -t rule-engine:test .
```

## Configuration

Configuration file 'application.${env}.properties' is present in resource directory.

## Running the app


### Docker run
```
specify environment in SPRING_PROFILES_ACTIVE : valid entries are dev , uat , prod
Mount volume for application logs : The container path is /logs/

To get the images id.

Docker images 

docker run -e SPRING_PROFILES_ACTIVE=dev ${IMAGE_ID} | ${docker images name}
```
