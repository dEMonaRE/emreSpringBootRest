http://127.0.0.1:8080/getAllUsers

[
    {
        "name": "Emre",
        "surname": "Zorlu",
        "mail": "ahmetx@xemrezorlu.com",
        "username": "xaemrexzorlu",
        "age": 30
    },
    {
        "name": "asdasd",
        "surname": "vvvv",
        "mail": "asd@asdddd.com",
        "username": "asdasd",
        "age": 22
    },
    {
        "name": "xxx",
        "surname": "xxxx",
        "mail": "xxxxx@xxxxx.com",
        "username": "xxxx",
        "age": 111
    }
]


http://127.0.0.1:8080/getAllUsersWithUsername

{
    "xaemrezorlu": {
         "name": "Emre",
        "surname": "Zorlu",
        "mail": "ahmetx@xemrezorlu.com",
        "username": "xaemrexzorlu",
        "age": 30
    },
    "asdasd": {
        "name": "asdasd",
        "surname": "vvvv",
        "mail": "asd@asdddd.com",
        "username": "asdasd",
        "age": 22
    },
    "xxx": {
        "name": "xxx",
        "surname": "xxxx",
        "mail": "xxxxx@xxxxx.com",
        "username": "xxxx",
        "age": 111
    }
}


http://127.0.0.1:8080/saveUser
REQUEST
{
        "name": "Emre",
        "surname": "Zorlu",
        "mail": "ahmet.com",
        "username": "xxaemrezorlu",
        "age": 33
}

RESPONSE

{
    "errorDesc": "validation error",
    "errorCode": 1923,
    "errorObjs": [
        {
            "errorDesc": "must be a well-formed email address",
            "errorCode": 1111,
            "errorObjs": null
        },
        {
            "errorDesc": "email 10dan kücük olamaz",
            "errorCode": 1111,
            "errorObjs": null
        }
    ]
}
