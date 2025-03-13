package com.csc340.mvc_demo2.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Provides the actual database transactions.
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> getStudentsByMajor(String major);

    @Query(value = "select * from students s where s.gpa >= ?1", nativeQuery = true)
    List<Student> getHonorsStudents(double gpa);

    @Query(value = "select * from students s where s.name like %?1% ", nativeQuery = true)
    List<Student> getStudentsByName(String name);

    @Query(value = "select * from students s where s.team_id = ?1", nativeQuery = true)
    List<Student> getStudentsByTeamId(int teamId);
}
