package challenge.ecommerce.dtos;

import challenge.ecommerce.enums.TypePayment;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class PurchaseApplicationDto {
    private Double totalAmount;
    private TypePayment typePayment;
    private List<OrderDto> orders = new ArrayList<>();
    private String address;
    private String zipCode;
    public PurchaseApplicationDto(){}
    public PurchaseApplicationDto(ArrayList<OrderDto> orders, String address, String zipCode,
                                  Double totalAmount, TypePayment typePayment) {
        this.orders = orders;
        this.address = address;
        this.zipCode = zipCode;
        this.totalAmount = totalAmount;
        this.typePayment = typePayment;
    }
}
