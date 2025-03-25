package com.csc340.mvc_demo2.student;


import com.csc340.mvc_demo2.team.Team;
import com.csc340.mvc_demo2.team.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * StudentController.java.
 * Includes all MVC mappings for the Student object.
 */
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @Autowired
    private TeamService teamService;

    /**
     * Get a list of all Students in the database.
     * http://localhost:8081/students/all
     *
     * @return a list of Students  objects.
     */
    @GetMapping("/all")
    public Object getAllStudents() {
        return new ResponseEntity<>(service.getAllStudents(), HttpStatus.OK);
    }

    /**
     * Get a specific Student by Id.
     * http://localhost:8081/students/2
     *
     * @param studentId the unique Id for a Student.
     * @return One Student object.
     */
    @GetMapping("/{studentId}")
    public Object getOneStudent(@PathVariable int studentId) {
        return new ResponseEntity<>(service.getStudentById(studentId), HttpStatus.OK);


    }

    /**
     * Get a list of students with a name that contains the given string.
     * http://localhost:8081/students/name?search=alex
     *
     * @param search the search key
     * @return list of Student objects matching the search key.
     */
    @GetMapping("/name")
    public Object getStudentsByName(@RequestParam(name = "search", defaultValue = "") String search) {
        return new ResponseEntity<>(service.getStudentsByName(search), HttpStatus.OK);


    }

    /**
     * Get a list of Students based on their major.
     * http://localhost:8081/students/major/csc
     *
     * @param major the search key.
     * @return A list of Student objects matching the search key.
     */
    @GetMapping("/major/{major}")
    public Object getStudentsByMajor(@PathVariable String major) {
        return new ResponseEntity<>(service.getStudentsByMajor(major), HttpStatus.OK);

    }

    /**
     * Get a list of students with a GPA above a threshold.
     * http://localhost:8081/students/honors?gpa=3.6
     *
     * @param gpa the minimum GPA
     * @return list of Student objects matching the search key.
     */
    @GetMapping("/honors")
    public Object getHonorsStudents(@RequestParam(name = "gpa", defaultValue = "3.0") double gpa) {
        return new ResponseEntity<>(service.getHonorsStudents(gpa), HttpStatus.OK);

    }

    /**
     * Create a new Student entry.
     * http://localhost:8081/students/register
     * <p>
     *
     * @param student the new Student object.
     * @return the updated list of Students.
     */
    @PostMapping("/register")
    public Object addNewStudent(@RequestBody Student student) {
        service.addNewStudent(student);
        return new ResponseEntity<>("New Student Successfully Created!", HttpStatus.CREATED);
    }


    /**
     * Update an existing Student object.
     * http://localhost:8081/students/update/2
     * <p>
     *
     * @param studentId the unique Student Id.
     * @param student   the new update Student details.
     * @return the updated Student object.
     */
    @PostMapping("/update/{studentId}")
    public Object updateStudent(@PathVariable int studentId, @RequestBody Student student) {
        service.updateStudent(student);
        return new ResponseEntity<>(service.getStudentById(studentId), HttpStatus.CREATED);

    }

    /**
     * Add existing Student to an existing Team.
     * http://localhost:8081/students/assign-team/11/3
     * @param studentId the student Id
     * @param teamId the team Id.
     * @return the updated student
     */

    @PostMapping("/assign-team/{studentId}/{teamId}")
    public Object assignStudentTeam(@PathVariable int studentId, @PathVariable int teamId) {
        Student student = service.getStudentById(studentId);
        student.setTeam(new Team(teamId));
        service.updateStudent(student);
        return new ResponseEntity<>(service.getStudentById(studentId), HttpStatus.CREATED);

    }

    /**
     * Delete a Student object.
     * http://localhost:8081/students/ban/2
     *
     * @param studentId the unique Student Id.
     * @return the updated list of Students.
     */
    @DeleteMapping("/ban/{studentId}")
    public Object deleteStudentById(@PathVariable int studentId) {
        service.deleteStudentById(studentId);
        return new ResponseEntity<>(service.getAllStudents(), HttpStatus.OK);

    }
}
