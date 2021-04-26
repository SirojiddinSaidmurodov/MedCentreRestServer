package edu.keepeasy.com.medcenter.controller;

import edu.keepeasy.com.medcenter.domain.PhTG;
import edu.keepeasy.com.medcenter.exceptions.PhTGNotFoundException;
import edu.keepeasy.com.medcenter.repository.PhTGRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/phTGs")
public class PhTGController {
    private final PhTGRepo repo;

    public PhTGController(@Autowired PhTGRepo repo) {
        this.repo = repo;
    }

    @GetMapping()
    public @ResponseBody
    List<PhTG> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public PhTG getOne(@PathVariable Long id) {
        return repo.findById(id).orElseThrow(() -> new PhTGNotFoundException(id));
    }

    @PostMapping()
    public PhTG newPhTG(@RequestBody PhTG newPhTG) {
        return repo.save(newPhTG);
    }

    @PutMapping("/{id}")
    public PhTG replacePhTG(@RequestBody PhTG newPhTG, @PathVariable Long id) {
        return repo.findById(id)
                .map(PhTG -> {
                    PhTG.copy(newPhTG);
                    return repo.save(PhTG);
                })
                .orElseGet(() -> {
                    newPhTG.setId(id);
                    return repo.save(newPhTG);
                });
    }

    @DeleteMapping("/{id}")
    public void deletePhTG(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
