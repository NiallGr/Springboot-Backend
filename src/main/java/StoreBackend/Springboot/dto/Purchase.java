package StoreBackend.Springboot.dto;

import java.util.Set;

import StoreBackend.Springboot.model.Address;
import StoreBackend.Springboot.model.Customer;
import StoreBackend.Springboot.model.Order;
import StoreBackend.Springboot.model.OrderItem;
import lombok.Data;

@Data
public class Purchase {

	private Customer customer;
	private Address shippingAddress;
	private Address billingAddress;
	private Order order;
	private Set<OrderItem> orderItems;
	
}
