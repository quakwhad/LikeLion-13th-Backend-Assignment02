package com.likelion.springprac.theater.application;

import com.likelion.springprac.theater.api.dto.TheaterDto;
import com.likelion.springprac.theater.domain.Theater;
import com.likelion.springprac.theater.domain.TheaterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TheaterService {

    private final TheaterRepository theaterRepository;
    private static Long sequence = 0L;

    public void saveTheater(TheaterDto requestDto) {
        Theater theater = Theater.builder()
                .theater_id(++sequence)
                .name(requestDto.name())
                .count(requestDto.count())
                .build();

        theaterRepository.save(theater);
    }

    public TheaterDto findTheaterById(Long theater_id) {
        Theater theater = theaterRepository.findById(theater_id);
        if(theater == null) {
            throw new IllegalArgumentException("해당하는 극장이 없습니다. theater = " + theater_id);
        }
        return toDto(theater);
    }

    public List<TheaterDto> findAllTheater() {
        return theaterRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public Theater updateTheaterById(Long theater_id, TheaterDto requestDto) {
        Theater theater = theaterRepository.findById(theater_id);
        if(theater == null) {
            throw new IllegalArgumentException("해당하는 극장이 없습니다. theater_id = " + theater_id);
        }

        theater.update(requestDto.name(), requestDto.count());
        theaterRepository.updateById(theater_id, theater);
        return theater;
    }

    public void deleteTheaterById(Long theater_id) {
        theaterRepository.deleteById(theater_id);
    }

    private TheaterDto toDto(Theater theater) {
        return TheaterDto.builder()
                .theater_id(theater.getTheater_id())
                .name(theater.getName())
                .count(theater.getCount())
                .build();
    }
}
