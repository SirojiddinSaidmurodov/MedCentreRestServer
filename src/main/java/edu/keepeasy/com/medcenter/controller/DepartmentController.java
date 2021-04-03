package edu.keepeasy.com.medcenter.controller;

import edu.keepeasy.com.medcenter.domain.Department;
import edu.keepeasy.com.medcenter.exceptions.DepartmentNotFoundException;
import edu.keepeasy.com.medcenter.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentRepo repo;

    public DepartmentController(@Autowired DepartmentRepo repo) {
        this.repo = repo;
    }

    @GetMapping
    public @ResponseBody
    List<Department> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Department getOne(@PathVariable Long id) {
        return repo.findById(id).orElseThrow(() -> new DepartmentNotFoundException(id));
    }

    @PostMapping
    public Department newDepartment(@RequestBody Department department) {
        return repo.save(department);
    }

    @PutMapping("/{id}")
    public Department replaceDepartment(@RequestBody Department newDepartment, @PathVariable Long id) {
        return repo.findById(id)
                .map(department -> {
                    department.copy(newDepartment);
                    return repo.save(department);
                })
                .orElseGet(() -> {
                    newDepartment.setId(id);
                    return repo.save(newDepartment);
                });
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
