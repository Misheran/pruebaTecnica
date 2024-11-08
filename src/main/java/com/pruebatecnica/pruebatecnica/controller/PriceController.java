package com.pruebatecnica.pruebatecnica.controller;

import java.util.Optional;

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
        Optional<PriceResponseDTO> optDto = priceService.getApplicablePrice(requestDTO);
        return optDto.isPresent() ? ResponseEntity.ok(optDto.get()) : ResponseEntity.status(HttpStatus.NOT_FOUND).build(); //En caso de que el resultado sea distinto de null se devuelve el dto con la información, si es igual a null se devuelve un error 404 NOT_FOUND
    }

}
