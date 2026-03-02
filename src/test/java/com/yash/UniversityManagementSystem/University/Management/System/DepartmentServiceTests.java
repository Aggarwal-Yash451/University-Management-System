package com.yash.UniversityManagementSystem.University.Management.System;

import com.yash.UniversityManagementSystem.University.Management.System.entity.Department;
import com.yash.UniversityManagementSystem.University.Management.System.entity.Professor;
import com.yash.UniversityManagementSystem.University.Management.System.service.DepartmentService;
import com.yash.UniversityManagementSystem.University.Management.System.service.ProfessorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DepartmentServiceTests {

    @Autowired
    ProfessorService professorService;

    @Autowired
    DepartmentService departmentService;

    @Test
    public void addProfessorToDepartment(){
        Department department = Department.builder().departmentCode("D1").name("Computer Science").build();
        departmentService.createDepartment(department);

        Professor professor = Professor.builder().name("Yash").employeeCode("P1").designation("Head").build();
        professorService.createProfessor(professor);

        departmentService.assignProfessorToDepartment(professor.getId(), department.getId());
    }
}
