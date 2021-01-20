package se.iths.rest;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.service.SubjectService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Set;

    @Path("subject")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public class SubjectRest {

        @Inject
        SubjectService subjectService;

        @Path("{subjectId}/addStudent/{studentId}")
        @POST
        public Subject addStudent(@PathParam("subjectId") Long subjectId, @PathParam("studentId") Long studentId) {
            return subjectService.addStudent(subjectId, studentId);
        }

        @Path("{subjectId}/addTeacher/{teacherId}")
        @POST
        public Subject addTeacher(@PathParam("subjectId") Long subjectId, @PathParam("teacherId")  Long teacherId) {
            return subjectService.addTeacher(subjectId, teacherId);
        }

        @Path("new")
        @POST
        public Response newSubject(Subject subject) {
            subjectService.createSubject(subject);
            return Response.ok(subject).build();
        }

        @Path("getall")
        @GET
        public List<Subject> getAllSubjects() {
            return subjectService.getAllSubjects();
        }

    }
