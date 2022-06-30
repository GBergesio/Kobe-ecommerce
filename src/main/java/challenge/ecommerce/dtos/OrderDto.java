package challenge.ecommerce.dtos;

import lombok.Data;

@Data
public class OrderDto {
    private Long productId;
    private Integer quantity;

    public OrderDto(){}
    public OrderDto(Long productId, Integer quantity){
        this.productId = productId;
        this.quantity = quantity;
    }

    public boolean isSomePropertuNull() {
        return this.productId == null || this.quantity == null;
    }
}
