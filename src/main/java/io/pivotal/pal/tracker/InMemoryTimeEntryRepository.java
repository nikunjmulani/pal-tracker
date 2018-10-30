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
        timeEntry.setTimeEntryId(timeEntryId);
        this.data.put(timeEntryId, timeEntry);

        return timeEntry;
    }

    @Override
    public TimeEntry find(long timeEntryId) {

        if (Objects.isNull(this.data) || !this.data.containsKey(timeEntryId)) {
            return null;
        }

        return this.data.get(timeEntryId);
    }

    @Override
    public List<TimeEntry> list() {
        if (Objects.isNull(this.data)) {
            return null;
        }
        
        return this.data.values().stream().collect(Collectors.toList()) ;
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {
        if (Objects.isNull(this.data) || !this.data.containsKey(id)) {
            return null;
        }

        timeEntry.setTimeEntryId(id);
        this.data.put(id, timeEntry);
        return timeEntry;
    }

    @Override
    public void delete(long id)  {
        if (Objects.isNull(this.data) || !this.data.containsKey(id)) {
            return;
        }


        this.data.remove(id);

    }


}
