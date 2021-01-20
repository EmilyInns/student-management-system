# Student-management-system
Starting project | Java EE assignment | JU19 | ITHS

Endpoints:

## GET
GET student by ID     `/se.iths/api/v1/student/{id}` 

GET all students    `/se.iths/api/v1/student/getall`

GET student by last name    `/se.iths/api/v1/student/getbylastname/{name}`
Be aware that the name field is case-sensitive.

GET all subjects `/se.iths/api/v1/subject/getall`

GET all teachers `/se.iths/api/v1/teacher/getall`

## POST

### Creation
POST new student   `/se.iths/api/v1/student/new`

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



POST new Teacher `/se.iths/api/v1/teacher/new`

```
    "firstName": "John",
    "lastname": "Doe",
    "email": "example@examplemail.com"
 
```

The only required field is `firstName`

POST new Subject `/se.iths/api/v1/subject/new`

```
    "subjectName":"Art"
```
### Misc POST

To add a teacher to a subject, POST to `/se.iths/api/v1/subject/{subjectId}/addTeacher/{studentId}`

To add a student to a subject, POST to `/se.iths/api/v1/subject/{subjectId}/addStudent/{studentId}`

No body is required for these methods.


## PUT
PUT     `/se.iths/api/v1/student/new`

## DELETE
DELETE  `/se.iths/api/v1/student/{id}`





