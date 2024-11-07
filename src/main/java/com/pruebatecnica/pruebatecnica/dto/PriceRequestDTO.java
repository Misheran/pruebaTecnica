package com.pruebatecnica.pruebatecnica.dto;

import java.time.LocalDateTime;

public class PriceRequestDTO {
    private Long productId;
    private Long brandId;
    private LocalDateTime applicationDate;

    public Long getProductId() {
        return productId;
    }
    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public Long getBrandId() {
        return brandId;
    }
    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }
    public LocalDateTime getApplicationDate() {
        return applicationDate;
    }
    public void setApplicationDate(LocalDateTime applicationDate) {
        this.applicationDate = applicationDate;
    }

    

}
