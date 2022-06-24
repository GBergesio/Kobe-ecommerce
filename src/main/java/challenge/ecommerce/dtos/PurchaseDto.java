package challenge.ecommerce.dtos;

import challenge.ecommerce.models.Purchase;
import challenge.ecommerce.models.PurchaseProduct;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class PurchaseDto {
    private Long id;
    private LocalDateTime purchaseDate;
    private String address;
    private Integer zipCode;
    private List<PurchaseProductDto> purchaseProductDtos;

    public PurchaseDto(){}
    public PurchaseDto(Purchase purchase){
        this.id = purchase.getId();
        this.purchaseDate = purchase.getPurchaseDate();
        this.address = purchase.getAddress();
        this.zipCode = purchase.getZipCode();
        this.purchaseProductDtos = purchase.getPurchaseProducts().stream().map(PurchaseProductDto::new).collect(Collectors.toList());
    }
}
