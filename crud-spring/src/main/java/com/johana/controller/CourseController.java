package com.johana.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.johana.dto.CourseDTO;
import com.johana.dto.CoursePageDTO;
import com.johana.service.CourseService;

@Validated
@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public CoursePageDTO list(@RequestParam(defaultValue = "0") @PositiveOrZero int page,
            @RequestParam(defaultValue = "10") @Positive @Max(100) int pageSize) {
        return courseService.list(page, pageSize);
    }

    // @GetMapping
    // public List<CourseDTO> list() {
    // return courseService.list();
    // }

    @GetMapping("/{id}")
    public CourseDTO findById(@PathVariable @NotNull @Positive Long id) {
        return courseService.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CourseDTO create(@RequestBody @Valid @NotNull CourseDTO course) {
        return courseService.create(course);
    }
}
