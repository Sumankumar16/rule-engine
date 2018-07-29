# Rule Engine
Readme v1.0

A rule engine which will allow user to create rule based on value_type for 
incoming data and would allow to apply created rule to filter those data which voilated the rule.
 
## Problem Statement 
```
It Should allow user to do following:
 1. Allow users to create rules on incoming data stream
 2.Execute rules on incoming stream and show the data that violates a rule.
 
 Incoming data stream is a tagged data stream. Each incoming data is a hashmap with following syntax 
 { 'signal': 'ATL1', 'value': '234.98', 'value_type': 'Integer'} 
 { 'signal': 'ATL2', 'value': 'HIGH', 'value_type': 'String'}
 { 'signal': 'ATL3', 'value': '23/07/2017 13:24:00.8765', 'value_type': 'Datetime'} ... ... ...
 
 
 In general, a data unit would have three keys
 signal: This key specifies the source ID of the signal. It could be any valid alphanumeric combo. ex: ATL1, ATL2, ATL3, ATL4 
 
 value: This would be the actual value of the signal. This would always be a string. ex: '234', 'HIGH', 'LOW', '23/07/2017' 
 
 value_type: This would specify how the value is to interpreted. It would be one of the following Integer: In this case the value is interpreted to be an integer. Ex: '234' would be interpreted as 234 String: In this case the value is interpreted to be a String. Ex: 'HIGH' would be interpreted as 'HIGH' Datetime: In this case the value is interpreted to be a Date Time.
 
 Rules can be specified for a signal and in accordance to the value_type. Some examples of rules are:
 ATL1 value should not rise above 240.00 
 ATL2 value should never be LOW
 ATL3 should not be in future
```

##Solution Approach
```
Solution can be decomposed in two part:
1. Create a dynamic rule.
Based on problem statement a rule can be created on value_type and
it also says there can be three type of value : "Datetime", "Integer", "String".

Hence there are bassically total eight types of rules are possible.
```

###Possible rules for value_type Integer:
```
1. Given a integer value x, create a rule which will voilate a data set
whose value are lesser then x. (Here x can be any integer).

2. Given a integer value x, create a rule which will voilate a data set
whose value are greater then x. (Here x can be any integer).

3. Given a integer value x, and y, create a rule which will voilate a data set
whose value are in range x and y. (Here x and y can be any integer).
```

###Possible rules for value_type as Datetime:
```
1. Given a Date as x, create a rule which will voilate a data set
whose value are lesser then Date x.

2. Given a Date as x, create a rule which will voilate a data set
whose value are greater then Date x.

3. Given a Date x, y, create a rule which will voilate a data set
whose value are in range x and y.
``` 

###Possible rules for value_type as String: 
```
VALUE can be either 'HIGH' or 'LOW'

```


#Getting Started 
```
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.
```

##Prerequisites
```
1. JDK 1.8
2. Maven 3.3
3. postgresql
4. Docker(optional)

```
## Cloning in local system

```
git clone https://github.com/Sumankumar16/rule-engine.git

```

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


### Docker build
```
docker build -t rule-engine:{var} .
e.g: docker build -t rule-engine:test .
```

## Configuration

Configuration file 'application.${env}.properties' is present in resource directory.

## Running the app
```
To run and test this application first it requires to setup database in local
postgres server or any cloud based db (ex: AWS RDS).

For local testing it is better to use local postgres server.

To create a db and table script is checked in under src/main/db and crossponding configuration is present in src/resource/ *.properties file.

spring.datasource.driverClassName: org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://localhost:5432/ruleengine
spring.datasource.username=postgres
spring.datasource.password=postgres

```


### Docker run
```
specify environment in SPRING_PROFILES_ACTIVE : valid entries are dev , uat , prod
Mount volume for application logs : The container path is /logs/

To get the images id.

Docker images 

docker run -e SPRING_PROFILES_ACTIVE=dev ${IMAGE_ID} | ${docker images name}
```


Author
```
Suman Kumar
```

License
```
This project is licensed under Apache License Version 2.0.
```