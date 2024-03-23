package com.project.professor.allocation.repository;

import com.project.professor.allocation.entity.Allocation;
import com.project.professor.allocation.entity.Course;
import com.project.professor.allocation.entity.Professor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import java.sql.Time;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
class AllocationRepositoryTest {
    @Autowired
    private AllocationRepository allocationRepository;

    @Test
    public void saveAllocation() {
        Professor professor = new Professor();
        professor.setId(1L);

        Course course = new Course();
        course.setId(1L);

        Allocation allocation = new Allocation();
        allocation.setId(null);
        allocation.setDayOfWeek(DayOfWeek.SUNDAY);
        allocation.setStartHour(Time.valueOf(LocalTime.of(19, 00)));
        allocation.setEndHour(Time.valueOf(LocalTime.of(20, 00)));
        allocation.setProfessor(professor);
        allocation.setCourse(course);

        allocation = allocationRepository.save(allocation);

        System.out.println(allocation);
    }

    @Test
    public void findAll() {
        List<Allocation> allocations = allocationRepository.findAll();
        allocations.forEach(System.out::println);
    }

    @Test
    public void findById() {
        Long id = 1L;
        Allocation allocation = allocationRepository.findById(id).orElse(null);
        System.out.println(allocation);
    }
}