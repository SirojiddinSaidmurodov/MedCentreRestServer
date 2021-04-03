package edu.keepeasy.com.medcenter.controller;

import edu.keepeasy.com.medcenter.domain.Doctor;
import edu.keepeasy.com.medcenter.exceptions.DoctorNotFoundException;
import edu.keepeasy.com.medcenter.repository.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/doctors")
public class DoctorController {
    private final DoctorRepo repo;

    public DoctorController(@Autowired DoctorRepo repo) {
        this.repo = repo;
    }

    @GetMapping()
    public @ResponseBody
    List<Doctor> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Doctor getOne(@PathVariable Long id) {
        return repo.findById(id).orElseThrow(() -> new DoctorNotFoundException(id));
    }

    @PostMapping()
    public Doctor newDoctor(@RequestBody Doctor Doctor) {
        return repo.save(Doctor);
    }

    @PutMapping("/{id}")
    public Doctor replaceDoctor(@RequestBody Doctor newDoctor, @PathVariable Long id) {
        return repo.findById(id)
                .map(Doctor -> {
                    Doctor.copy(newDoctor);
                    return repo.save(Doctor);
                })
                .orElseGet(() -> {
                    newDoctor.setId(id);
                    return repo.save(newDoctor);
                });
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id) {
        repo.deleteById(id);
    }


}
