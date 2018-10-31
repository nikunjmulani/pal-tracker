package io.pivotal.pal.tracker;

import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;


@Repository
public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    private Map<Long, TimeEntry> data;


    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        if (Objects.isNull(this.data)) {
            this.data = new HashMap<>();
        }

        long timeEntryId = (long) this.data.size() + 1;
        timeEntry.setId(timeEntryId);
        this.data.put(timeEntryId, timeEntry);

        return timeEntry;
    }

    @Override
    public TimeEntry find(Long timeEntryId) {

        if (Objects.isNull(this.data) || !this.data.containsKey(timeEntryId)) {
            return null;
        }

        return this.data.get(timeEntryId);
    }

    @Override
    public List<TimeEntry> list() {
        if (Objects.isNull(this.data)) {
            return new ArrayList<>();
        }
        
        return this.data.values().stream().collect(Collectors.toList()) ;
    }

    @Override
    public TimeEntry update(Long id, TimeEntry timeEntry) {
        if (Objects.isNull(this.data) || !this.data.containsKey(id)) {
            return null;
        }

        timeEntry.setId(id);
        this.data.put(id, timeEntry);
        return timeEntry;
    }

    @Override
    public void delete(Long id)  {
        if (Objects.isNull(this.data) || !this.data.containsKey(id)) {
            return;
        }


        this.data.remove(id);

    }


}
