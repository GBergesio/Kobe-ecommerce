package challenge.ecommerce.dtos;

import lombok.Data;

@Data
public class OrderDto {
    private Long productId;
    private Short quantity;

    public OrderDto(){}
    public OrderDto(Long productId, Short quantity){
        this.productId = productId;
        this.quantity = quantity;
    }

    public boolean isSomePropertyNull() {
        return this.productId == null || this.quantity == null;
    }
}
