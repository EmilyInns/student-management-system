package se.iths.rest;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;
import se.iths.service.SubjectService;
import se.iths.service.TeacherService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Set;

    @Path("teacher")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public class TeacherRest {

        @Inject
        TeacherService teacherService;

        @Path("new")
        @POST
        public Response newTeacher(Teacher teacher){
            teacherService.createTeacher(teacher);
            return Response.ok(teacher).build();
        }

        @Path("getall")
        @GET
        public List<Teacher> getAllTeachers() {
            return teacherService.getAllTeachers();
        }



    }


