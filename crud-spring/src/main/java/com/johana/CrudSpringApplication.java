package com.johana;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.johana.model.Course;
import com.johana.repository.CourseRepository;

@SpringBootApplication
public class CrudSpringApplication {

  public static void main(String[] args) {
    SpringApplication.run(CrudSpringApplication.class, args);
  }

  @Bean
  CommandLineRunner runner(CourseRepository repository) {
    return (args) -> {

      repository.deleteAll();

      Course course = new Course();

      course.setName("Java");
      course.setCategory("Java");

      repository.save(course);
    };
  }
}
