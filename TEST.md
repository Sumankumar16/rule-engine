# How to test this application end to end:

# Case1:

## Create rule which you want to apply on streaming signal

### POST: localhost:8080/createRule
### Content-Type : application/json

```
Request body:

{
	"lower_boundry_of_date": "2016-06-13T05:30:00+05",
	"upper_boundry_of_date":"2017-06-13T05:30:00+05",
	"lower_boundry_of_int": "220",
	"upper_boundry_of_int": "240",
	"string_value_type": "LOW"
}

Response :

{
    "metadata": {
        "message": "Rule Created Successfully!",
        "code": 201
    },
    "data": {
        "ruleId": 24,
        "rules": [
            {
                "id": 24,
                "lower_boundry_of_date": "2016-06-13T06:00:00+05",
                "upper_boundry_of_date": "2017-06-13T06:00:00+05",
                "lower_boundry_of_int": 220,
                "upper_boundry_of_int": 240,
                "string_value_type": "LOW"
            }
        ],
        "signals": null
    }
}

Where id is the ruleId for created rule

```
## How to apply created rule on signal


### POST: http://localhost:8080/applyRule/{ruleId}
### POST: http://localhost:8080/applyRule/24
### Content-type : application/json

```
Request Body: 

[{
	"signal": "ATL9",
	"value_type": "Datetime",
	"value": "2017-9-13 22:40:10"
},
{
	"signal": "ATL9",
	"value_type": "Integer",
	"value": "240.4433"
},{
	"signal": "ATL13",
	"value_type": "String",
	"value": "sdkdskhf"
},
{
	"signal": "ATL3",
	"value_type": "String",
	"value": "LOW"
},{
	"signal": "ATL9",
	"value_type": "Datetime",
	"value": "2013-9-13 22:40:10"
},
{
	"signal": "ATL9",
	"value_type": "Integer",
	"value": "199.4433"
}]

Response Body:

{
    "metadata": {
        "message": "Rule Applied Successfully!",
        "code": 200
    },
    "data": {
        "ruleId": 24,
        "rules": null,
        "signals": [
            {
                "id": null,
                "signal": "ATL9",
                "value_type": "Datetime",
                "value": "2017-9-13 22:40:10"
            },
            {
                "id": null,
                "signal": "ATL9",
                "value_type": "Datetime",
                "value": "2013-9-13 22:40:10"
            },
            {
                "signal": "ATL13",
                "value_type": "String",
                "value": "sdkdskhf"
            },
            {
                "id": null,
                "signal": "ATL9",
                "value_type": "Integer",
                "value": "199.4433"
            }
        ]
    }
}

```

### Response Description:

```
It has filtered those signal which are not in the range of date boundry as well as int boundry.
For sting value type it has filtered those signal where value is anything aprt form LOW.
```

# Case2:

### Create rule
### POST: localhost:8080/createRule
### Content-Type : application/json
```
Request body:

{
	"lower_boundry_of_date": "2016-06-13T05:30:00+05",
	"upper_boundry_of_date":"",
	"lower_boundry_of_int": "220",
	"upper_boundry_of_int": "240",
	"string_value_type": "HIGH"
}


Response body:

{
    "metadata": {
        "message": "List of all existing rules",
        "code": 200
    },
    "data": {
        "ruleId": 25,
        "rules": [
            {
                "id": 25,
                "lower_boundry_of_date": "2016-06-13T06:00:00+05",
                "upper_boundry_of_date": "",
                "lower_boundry_of_int": 220,
                "upper_boundry_of_int": 240,
                "string_value_type": "HIGH"
            }
        ],
        "signals": null
    }
}
```
### Apply rule
### POST: http://localhost:8080/applyRule/{ruleId}
### POST: http://localhost:8080/applyRule/25
### Content-type : application/json
```
Request Body: 

[{
	"signal": "ATL9",
	"value_type": "Datetime",
	"value": "2017-9-13 22:40:10"
},
{
	"signal": "ATL9",
	"value_type": "Integer",
	"value": "240.4433"
},{
	"signal": "ATL3",
	"value_type": "String",
	"value": "LOW"
},
{
	"signal": "ATL3",
	"value_type": "String",
	"value": "LOW"
},{
	"signal": "ATL9",
	"value_type": "Datetime",
	"value": "2013-9-13 22:40:10"
},
{
	"signal": "ATL9",
	"value_type": "Integer",
	"value": "199.4433"
}]

Response Body:

{
    "metadata": {
        "message": "Rule Applied Successfully!",
        "code": 200
    },
    "data": {
        "ruleId": 25,
        "rules": null,
        "signals": [
            {
                "id": null,
                "signal": "ATL3",
                "value_type": "String",
                "value": "LOW"
            },
            {
                "id": null,
                "signal": "ATL3",
                "value_type": "String",
                "value": "LOW"
            },
            {
                "id": null,
                "signal": "ATL9",
                "value_type": "Datetime",
                "value": "2013-9-13 22:40:10"
            },
            {
                "id": null,
                "signal": "ATL9",
                "value_type": "Integer",
                "value": "199.4433"
            }
        ]
    }
}

```
### Response Description:

```
Since rule has only lower boundry of date which means all signal are valid after 2016-06-13T06:00:00+05.
For sting value type it has filtered those signal where value is anything aprt form HIGH.
```



# Case 3: 
### Create rule
### POST: localhost:8080/createRule
### Content-Type : application/json
```
Request body:

{
	"lower_boundry_of_date": "",
	"upper_boundry_of_date":"2016-06-13T05:30:00+05",
	"lower_boundry_of_int": "220",
	"upper_boundry_of_int": "240",
	"string_value_type": "HIGH"
}


Response body:

{
    "metadata": {
        "message": "Rule Created Successfully!",
        "code": 201
    },
    "data": {
        "ruleId": 26,
        "rules": [
            {
                "id": 26,
                "lower_boundry_of_date": null,
                "upper_boundry_of_date": "2016-06-13T06:00:00+05",
                "lower_boundry_of_int": 220,
                "upper_boundry_of_int": 240,
                "string_value_type": "HIGH"
            }
        ],
        "signals": null
    }
}

```
### Apply rule
### POST: http://localhost:8080/applyRule/{ruleId}
### POST: http://localhost:8080/applyRule/26
### Content-type : application/json
```
Request Body: 

[{
	"signal": "ATL9",
	"value_type": "Datetime",
	"value": "2017-9-13 22:40:10"
},
{
	"signal": "ATL9",
	"value_type": "Integer",
	"value": "240.4433"
},{
	"signal": "ATL3",
	"value_type": "String",
	"value": "LOW"
},
{
	"signal": "ATL3",
	"value_type": "String",
	"value": "LOW"
},{
	"signal": "ATL9",
	"value_type": "Datetime",
	"value": "2013-9-13 22:40:10"
},
{
	"signal": "ATL9",
	"value_type": "Integer",
	"value": "199.4433"
}]

Response Body:

{
    "metadata": {
        "message": "Rule Applied Successfully!",
        "code": 200
    },
    "data": {
        "ruleId": 26,
        "rules": null,
        "signals": [
            {
                "id": null,
                "signal": "ATL9",
                "value_type": "Datetime",
                "value": "2017-9-13 22:40:10"
            },
            {
                "id": null,
                "signal": "ATL3",
                "value_type": "String",
                "value": "LOW"
            },
            {
                "id": null,
                "signal": "ATL3",
                "value_type": "String",
                "value": "LOW"
            },
            {
                "id": null,
                "signal": "ATL9",
                "value_type": "Integer",
                "value": "199.4433"
            }
        ]
    }
}

```
### Response Description:

```
Since rule has only lower boundry of date which means all signal are valid before 2016-06-13T06:00:00+05.
For sting value type it has filtered those signal where value is anything aprt form HIGH.
```

Same Case follows for Intger too.




