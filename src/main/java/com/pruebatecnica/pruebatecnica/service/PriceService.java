package com.pruebatecnica.pruebatecnica.service;

import java.util.Optional;

import com.pruebatecnica.pruebatecnica.dto.PriceRequestDTO;
import com.pruebatecnica.pruebatecnica.dto.PriceResponseDTO;

public interface PriceService {
    Optional<PriceResponseDTO> getApplicablePrice(PriceRequestDTO priceRequestDTO);
}
