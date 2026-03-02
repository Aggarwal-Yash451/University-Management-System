package com.yash.UniversityManagementSystem.University.Management.System.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String departmentCode;

    @Column(nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(
            name = "dept_professors",
            joinColumns = @JoinColumn(name = "department_id"),
            inverseJoinColumns = @JoinColumn(name = "professor_id")
    )
    Set<Professor> professors = new HashSet<>();

    public void addProfessor(Professor professor){
        this.getProfessors().add(professor);
        professor.getDepartments().add(this);
    }

    public void removeProfessor(Professor professor){
        this.getProfessors().remove(professor);
        professor.getDepartments().remove(this);
    }
}
