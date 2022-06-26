package challenge.ecommerce.dtos;

import challenge.ecommerce.enums.TypePayment;
import challenge.ecommerce.models.Purchase;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class PurchaseDto {
    private Long id;
    private Double totalAmount;
    private TypePayment typePayment;
    private LocalDateTime purchaseDate;
    private String address;
    private Integer zipCode;
    private List<PurchaseProductDto> purchaseProductDtos;

    public PurchaseDto(){}

    public PurchaseDto(Purchase purchase) {
        this.id = purchase.getId();
        this.totalAmount = purchase.getTotalAmount();
        this.typePayment = purchase.getTypePayment();
        this.purchaseDate = purchase.getPurchaseDate();
        this.address = purchase.getAddress();
        this.zipCode = purchase.getZipCode();
        this.purchaseProductDtos = getPurchaseProductDtos();
    }
}
