package com.likelion.springprac.theater.api;

import com.likelion.springprac.theater.api.dto.TheaterDto;
import com.likelion.springprac.theater.application.TheaterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TheaterController {
    private final TheaterService theaterService;

    @PostMapping("theaters")
    public void save(@RequestBody TheaterDto theaterDto) {
        theaterService.saveTheater(theaterDto);
    }

    @GetMapping("theaters/{theater_id}")
    public TheaterDto getTheater(@PathVariable Long theater_id) {
        return theaterService.findTheaterById(theater_id);
    }

    @GetMapping("theaters")
    public List<TheaterDto> findAllTheaters() {
        return theaterService.findAllTheater();
    }

    @PatchMapping("theaters/{theater_id}")
    public void updateTheaterById(@PathVariable Long theater_id, @RequestBody TheaterDto theaterDto) {
        theaterService.updateTheaterById(theater_id, theaterDto);
    }

    @DeleteMapping("theaters/{theater_id}")
    public void deleteTheaterById(@PathVariable Long theater_id) {
        theaterService.deleteTheaterById(theater_id);
    }
}
