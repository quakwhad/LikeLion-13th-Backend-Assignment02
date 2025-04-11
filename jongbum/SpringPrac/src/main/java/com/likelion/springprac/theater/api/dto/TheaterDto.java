package com.likelion.springprac.theater.api.dto;

import lombok.Builder;

@Builder
public record TheaterDto(
        Long theater_id,
        String name,
        Long count
) {
}