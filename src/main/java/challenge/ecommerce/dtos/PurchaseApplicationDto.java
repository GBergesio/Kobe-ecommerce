package challenge.ecommerce.dtos;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class PurchaseApplicationDto {
    private Map<Long, Integer> orders = new HashMap<>();
    private String address;
    private String zipCode;
    public PurchaseApplicationDto(){}

    public PurchaseApplicationDto(Map<Long, Integer> orders, String address, String zipCode) {
        this.orders = orders;
        this.address = address;
        this.zipCode = zipCode;
    }
}
