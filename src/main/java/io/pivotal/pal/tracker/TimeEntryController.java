package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/time-entries")
public class TimeEntryController {


    @Autowired
    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }


    @PostMapping
    public ResponseEntity create(@RequestBody TimeEntry timeEntryToCreate) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.timeEntryRepository.create(timeEntryToCreate));
    }


    @GetMapping("/{timeEntryId}")
    public ResponseEntity<TimeEntry> read(@PathVariable long timeEntryId) {
        TimeEntry timeEntry = this.timeEntryRepository.find(timeEntryId);

        if (Objects.nonNull(timeEntry)) {
            return ResponseEntity.ok(timeEntry);

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping
    public ResponseEntity<List<TimeEntry>> list() {
        return ResponseEntity.ok(this.timeEntryRepository.list());
    }


    @PutMapping("/{timeEntryId}")
    public ResponseEntity update(@PathVariable long timeEntryId, @RequestBody TimeEntry timeEntry) {
        timeEntry = this.timeEntryRepository.update(timeEntryId, timeEntry);

        if (Objects.nonNull(timeEntry)) {
            return ResponseEntity.ok(timeEntry);

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();




    }

    @DeleteMapping("/{timeEntryId}")
    public ResponseEntity<TimeEntry> delete(@PathVariable long timeEntryId) {
        this.timeEntryRepository.delete(timeEntryId);
        return ResponseEntity.noContent().build();

    }
}
