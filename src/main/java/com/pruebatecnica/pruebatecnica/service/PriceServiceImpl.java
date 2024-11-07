package com.pruebatecnica.pruebatecnica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pruebatecnica.pruebatecnica.dto.PriceRequestDTO;
import com.pruebatecnica.pruebatecnica.dto.PriceResponseDTO;
import com.pruebatecnica.pruebatecnica.entities.Price;
import com.pruebatecnica.pruebatecnica.repository.PriceRepository;

@Service
public class PriceServiceImpl implements PriceService{

    private final PriceRepository priceRepository;

    public PriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public Optional<PriceResponseDTO> getApplicablePrice(PriceRequestDTO priceRequestDTO) {
        List<Price> prices = priceRepository.findApplicablePrices(
            priceRequestDTO.getProductId(), 
            priceRequestDTO.getBrandId(), 
            priceRequestDTO.getApplicationDate());

        if (prices.isEmpty()) return Optional.empty();

        Price applicablePrice = prices.get(0);
        return Optional.of(mapEntityToResponseDTO(applicablePrice));
    }

    private PriceResponseDTO mapEntityToResponseDTO(Price price) {
        return new PriceResponseDTO(
            price.getProductId(),
            price.getBrandId(),
            price.getPriceList(),
            price.getStartDate(),
            price.getEndDate(),
            price.getPrice(),
            price.getCurrency()
        );
    }

}
