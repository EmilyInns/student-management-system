package se.iths.rest;


import se.iths.entity.Student;
import se.iths.service.StudentService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

 @Path("student")
 @Consumes(MediaType.APPLICATION_JSON)
 @Produces(MediaType.APPLICATION_JSON)
public class StudentRest {

    @Inject
    StudentService studentService;

    @Path("new")
    @POST
    public Response createStudent(Student student){
        studentService.createStudent(student);
        return Response.ok(student).build();
    }

    @Path("new")
    @PUT
    public Response updateStudent(Student student){
        studentService.updateStudent(student);
        return Response.ok(student).build();
    }

    @Path("{id}")
    @GET
    public Student getStudent(@PathParam("id") Long id){
        return studentService.findStudentById(id);
    }


     @Path("getbylastname/{name}")
     @GET
     public List<Student> getStudentBylastName(@PathParam("name") String lastName){
         if (!studentService.getByLastName(lastName).isEmpty())
             return studentService.getByLastName(lastName);

         throw new StudentNotFoundException("No students with last name " + lastName + " found.");

     }
    @Path("getall")
    @GET
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

     @Path("{id}")
     @Produces(MediaType.TEXT_PLAIN)
     @DELETE
     public Response deleteItem(@PathParam("id") Long id) {
         Student foundItem = studentService.findStudentById(id);
         if (foundItem != null) {
             studentService.deleteStudent(id);
             return Response.ok().entity("Student with ID " + id + " was successfully deleted.").build();
         } else {
             throw new StudentNotFoundException("Student with ID " + id + " not found.");
         }
     }

}
