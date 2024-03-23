package com.project.professor.allocation.repository;

import com.project.professor.allocation.entity.Department;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
class DepartmentRepositoryTest {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    public void saveDepartment() {
        Department department = new Department();
        department.setId(1L);
        department.setName("Física");

        department = departmentRepository.save(department);

        System.out.println(department);
    }

    @Test
    public void findAll() {
        List<Department> departments = departmentRepository.findAll();
        departments.forEach(System.out::println);
    }

    @Test
    public void findById() {
        Long id = 1L;
        Department department = departmentRepository.findById(id).orElse(null);
        System.out.println(department);
    }
}