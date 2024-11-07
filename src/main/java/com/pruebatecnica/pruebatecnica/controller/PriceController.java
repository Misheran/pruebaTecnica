package com.pruebatecnica.pruebatecnica.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebatecnica.pruebatecnica.dto.PriceRequestDTO;
import com.pruebatecnica.pruebatecnica.dto.PriceResponseDTO;
import com.pruebatecnica.pruebatecnica.service.PriceService;

@RestController
@RequestMapping("api/prices")
public class PriceController {

    private final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping
    public ResponseEntity<PriceResponseDTO> getPrice(PriceRequestDTO requestDTO) {
        return priceService.getApplicablePrice(requestDTO)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

}
