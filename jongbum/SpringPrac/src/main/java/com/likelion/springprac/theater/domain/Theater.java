package com.likelion.springprac.theater.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Theater {
    private Long theater_id;
    private String name;
    private Long count;

    @Builder
    public Theater(Long theater_id, String name, Long count) {
        this.theater_id = theater_id;
        this.name = name;
        this.count = count;
    }

    public void update(String name, Long count) {
        this.name = name;
        this.count = count;
    }
}
