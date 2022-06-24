package challenge.ecommerce.dtos;

import challenge.ecommerce.models.Purchase;
import challenge.ecommerce.models.PurchaseProduct;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class PurchaseDto {
    private Long id;
    private List<PurchaseProductDto> purchaseProductDtos;

    public PurchaseDto(){}
    public PurchaseDto(Purchase purchase){
        this.id = purchase.getId();
        this.purchaseProductDtos = purchase.getPurchaseProducts().stream().map(PurchaseProductDto::new).collect(Collectors.toList());
    }
}
