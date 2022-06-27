package challenge.ecommerce.dtos;

import challenge.ecommerce.models.PurchaseProduct;
import lombok.Data;

@Data
public class PurchaseProductDto {
    private String productName;
    private Integer quantity;
    private String image;
    public PurchaseProductDto(){}
    public PurchaseProductDto(PurchaseProduct purchaseProduct){
        this.productName = purchaseProduct.getProduct().getName();
        this.quantity = purchaseProduct.getQuantity();
        this.image = purchaseProduct.getProduct().getImg();
    }
}
