# Student-management-system
Starting project | Java EE assignment | JU19 | ITHS

Endpoints:

## GET
GET student by ID     `/se.iths/api/v1/student/{id}` 

GET all students    `/se.iths/api/v1/student/getall`

GET student by last name    `/se.iths/api/v1/student/getbylastname/{name}`
Be aware that the name field is case-sensitive.

## POST
POST    `/se.iths/api/v1/student/new`

Json data for student creation is formatted according to the following template:

```
{
    "firstName": "Emily",
    "lastname": "Inns",
    "email": "example@examplemail.com",
    "phoneNumber": "1234567890"
}
```

All fields above are required except for `phoneNumber`.


## PUT
PUT     `/se.iths/api/v1/student/new`

## DELETE
DELETE  `/se.iths/api/v1/student/{id}`



