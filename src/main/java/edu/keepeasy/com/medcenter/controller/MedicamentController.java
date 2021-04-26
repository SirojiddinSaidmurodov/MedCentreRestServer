package edu.keepeasy.com.medcenter.controller;

import edu.keepeasy.com.medcenter.domain.Medicament;
import edu.keepeasy.com.medcenter.exceptions.MedicamentNotFoundException;
import edu.keepeasy.com.medcenter.repository.MedicamentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/medicaments")
public class MedicamentController {
    private final MedicamentRepo repo;

    public MedicamentController(@Autowired MedicamentRepo repo) {
        this.repo = repo;
    }

    @GetMapping()
    public @ResponseBody
    List<Medicament> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Medicament getOne(@PathVariable Long id) {
        return repo.findById(id).orElseThrow(() -> new MedicamentNotFoundException(id));
    }

    @PostMapping()
    public Medicament newMedicament(@RequestBody Medicament newMedicament) {
        return repo.save(newMedicament);
    }

    @PutMapping("/{id}")
    public Medicament replaceMedicament(@RequestBody Medicament newMedicament, @PathVariable Long id) {
        return repo.findById(id)
                .map(Medicament -> {
                    Medicament.copy(newMedicament);
                    return repo.save(Medicament);
                })
                .orElseGet(() -> {
                    newMedicament.setId(id);
                    return repo.save(newMedicament);
                });
    }

    @DeleteMapping("/{id}")
    public void deleteMedicament(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
