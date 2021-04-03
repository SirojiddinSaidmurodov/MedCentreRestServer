package edu.keepeasy.com.medcenter.controller;

import edu.keepeasy.com.medcenter.domain.Patient;
import edu.keepeasy.com.medcenter.exceptions.PatientNotFoundException;
import edu.keepeasy.com.medcenter.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/patients")
public class PatientController {
    private final PatientRepo repo;

    public PatientController(@Autowired PatientRepo repo) {
        this.repo = repo;
    }

    @GetMapping()
    public @ResponseBody
    List<Patient> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Patient getOne(@PathVariable Long id) {
        return repo.findById(id).orElseThrow(() -> new PatientNotFoundException(id));
    }

    @PostMapping()
    public Patient newPatient(@RequestBody Patient patient) {
        return repo.save(patient);
    }

    @PutMapping("/{id}")
    public Patient replacePatient(@RequestBody Patient newPatient, @PathVariable Long id) {
        return repo.findById(id)
                .map(patient -> {
                    patient.copy(newPatient);
                    return repo.save(patient);
                })
                .orElseGet(() -> {
                    newPatient.setId(id);
                    return repo.save(newPatient);
                });
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        repo.deleteById(id);
    }


}
