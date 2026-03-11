package com.yash.UniversityManagementSystem.University.Management.System.service;

import com.yash.UniversityManagementSystem.University.Management.System.entity.Course;
import com.yash.UniversityManagementSystem.University.Management.System.entity.Profile;
import com.yash.UniversityManagementSystem.University.Management.System.entity.Student;
import com.yash.UniversityManagementSystem.University.Management.System.repositories.CourseRepository;
import com.yash.UniversityManagementSystem.University.Management.System.repositories.ProfileRepository;
import com.yash.UniversityManagementSystem.University.Management.System.repositories.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public Student createNewStudent(Student student){
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id){
        return studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student with id not found"));
    }

    @Transactional
    public Student assignProfileToStudent(Profile profile, Long id){
        Student student = studentRepository.findById(id).orElseThrow();
        student.setProfile(profile);

        return student;
    }

    @Transactional
    public Student removeProfileOfStudent(Long id){
        Student student = studentRepository.findById(id).orElseThrow();
        student.setProfile(null);
        return student;
    }

    @Transactional
    public void deleteStudent(Long id){
        Student student = studentRepository.findById(id).orElseThrow();
        studentRepository.delete(student);
    }

    @Transactional
    public void enrollInACourse(Long studentId , Long courseId){
        Student student = studentRepository.findById(studentId).orElseThrow();
        Course course = courseRepository.findById(courseId).orElseThrow();
        student.enrollInCourse(course);
    }

}
