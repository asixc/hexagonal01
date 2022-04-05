package com.example.adapters.in.api.rest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record CartDTO(Long id, Long clientId, LocalDateTime created, UUID idPayment, List<ProductDTO> products) {
}
