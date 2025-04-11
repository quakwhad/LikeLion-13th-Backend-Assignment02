package com.likelion.springprac.theater.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class MemoryTheaterRepository implements TheaterRepository {

    private static Map<Long, Theater> database = new HashMap<>();

    @Override
    public void save(Theater theater) {
        database.put(theater.getTheater_id(), theater);
    }

    @Override
    public Theater findById(Long theater_id) {
        return database.get(theater_id);
    }

    @Override
    public List<Theater> findAll() {
        return database.values().stream().toList();
    }

    @Override
    public void updateById(Long theater_id, Theater theater) {
        database.put(theater_id, theater);
    }

    @Override
    public void deleteById(Long theater_id) {
        database.remove(theater_id);
    }
}
