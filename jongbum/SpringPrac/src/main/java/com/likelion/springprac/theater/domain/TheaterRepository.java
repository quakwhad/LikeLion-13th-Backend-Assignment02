package com.likelion.springprac.theater.domain;

import java.util.List;

public interface TheaterRepository {
    void save(Theater theater);
    Theater findById(Long theater_id);
    List<Theater> findAll();
    void updateById(Long theater_id, Theater theater);
    void deleteById(Long theater_id);
}