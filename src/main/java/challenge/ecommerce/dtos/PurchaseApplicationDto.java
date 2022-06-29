package challenge.ecommerce.dtos;

import challenge.ecommerce.enums.TypePayment;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class PurchaseApplicationDto {
    private Double totalAmount;
    private TypePayment typePayment;
    private Map<Long, Integer> orders = new HashMap<>();
    private String address;
    private String zipCode;
    public PurchaseApplicationDto(){}
    public PurchaseApplicationDto(Map<Long, Integer> orders, String address, String zipCode, Double totalAmount, TypePayment typePayment) {
        this.orders = orders;
        this.address = address;
        this.zipCode = zipCode;
        this.totalAmount = totalAmount;
        this.typePayment = typePayment;
    }
}
