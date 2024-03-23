package com.project.professor.allocation.repository;

import com.project.professor.allocation.entity.Department;
import com.project.professor.allocation.entity.Professor;
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
class ProfessorRepositoryTest {
    @Autowired
    private ProfessorRepository professorRepository;

    @Test
    public void saveProfessor() {
        Department department = new Department();
        department.setId(1L);

        Professor professor = new Professor();
        professor.setId(1L);
        professor.setName("Fernanda Melo");
        professor.setCpf("12345678910");
        professor.setDepartment(department);

        professor = professorRepository.save(professor);

        System.out.println(professor);
    }

    @Test
    public void findAll() {
        List<Professor> professors = professorRepository.findAll();
        professors.forEach(System.out::println);
    }

    @Test
    public void findById() {
        Long id = 1L;
        Professor professor = professorRepository.findById(id).orElse(null);
        System.out.println(professor);
    }
}