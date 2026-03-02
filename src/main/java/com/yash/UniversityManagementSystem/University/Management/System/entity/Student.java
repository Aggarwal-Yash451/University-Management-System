package com.yash.UniversityManagementSystem.University.Management.System.entity;

import com.yash.UniversityManagementSystem.University.Management.System.enums.EnrollmentStatusEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String rollNumber;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private Profile profile;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Enrollment> enrollments = new ArrayList<>();

    public void setProfile(Profile profile){
        this.profile = profile;

        if(profile != null){
            profile.setStudent(this);
        }
    }

    public void enrollInCourse(Course course){
        Enrollment enrollment = new Enrollment();
        enrollment.setCourse(course);
        enrollment.setStudent(this);
        enrollment.setEnrollmentDate(LocalDate.now());
        enrollment.setStatus(EnrollmentStatusEnum.ACTIVE);

        this.enrollments.add(enrollment);
        course.getEnrollments().add(enrollment);

    }

    public void dropCourse(Course course) {
        Iterator<Enrollment> iterator = enrollments.iterator();

        while (iterator.hasNext()) {
            Enrollment enrollment = iterator.next();

            if (enrollment.getCourse().getId().equals(course.getId())) {
                iterator.remove();
                course.getEnrollments().remove(enrollment);
                enrollment.setStudent(null);
                enrollment.setCourse(null);
            }
        }
    }

}
