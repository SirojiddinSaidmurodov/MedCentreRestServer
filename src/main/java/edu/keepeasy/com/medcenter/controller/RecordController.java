package edu.keepeasy.com.medcenter.controller;

import edu.keepeasy.com.medcenter.domain.Record;
import edu.keepeasy.com.medcenter.exceptions.RecordNotFoundException;
import edu.keepeasy.com.medcenter.repository.RecordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/doctors")
public class RecordController {
    private final RecordRepo repo;

    public RecordController(@Autowired RecordRepo repo) {
        this.repo = repo;
    }

    @GetMapping()
    public @ResponseBody
    List<Record> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Record getOne(@PathVariable Long id) {
        return repo.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    @PostMapping("/{id}")
    public Record replaceRecord(@RequestBody Record newRecord, @PathVariable Long id) {
        return repo.findById(id)
                .map(record -> {
                    record.copy(newRecord);
                    return repo.save(record);
                })
                .orElseGet(() -> {
                    newRecord.setId(id);
                    return repo.save(newRecord);
                });
    }

    @DeleteMapping("/{id}")
    public void deleteRecord(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
