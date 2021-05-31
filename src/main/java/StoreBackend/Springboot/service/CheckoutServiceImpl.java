package StoreBackend.Springboot.service;

import java.util.Set;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import StoreBackend.Springboot.dto.Purchase;
import StoreBackend.Springboot.dto.PurchaseResponse;
import StoreBackend.Springboot.model.Customer;
import StoreBackend.Springboot.model.Order;
import StoreBackend.Springboot.model.OrderItem;
import StoreBackend.Springboot.repository.CustomerRepository;

@Service
public class CheckoutServiceImpl implements CheckoutService{

		private CustomerRepository customerRepository;
		
		@Autowired
		public CheckoutServiceImpl(CustomerRepository customerRepository) {
			this.customerRepository = customerRepository;
					
		}
	@Override
	@Transactional
	public PurchaseResponse placeOrder(Purchase purchase) {
		//
		Order order = purchase.getOrder();
		//
		String orderTrackingNumber = generateOrderTrackingNumber();
		order.setOrderTrackingNumber(orderTrackingNumber);
		//
		Set<OrderItem> orderItems = purchase.getOrderItems();
		orderItems.forEach(item -> order.add(item));
		//
		order.setBillingAddress(purchase.getBillingAddress());
		order.setShippingAddress(purchase.getShippingAddress());
		//
		Customer customer = purchase.getCustomer();
		customer.add(order);
		//
		customerRepository.save(customer);
		//
		return new PurchaseResponse(orderTrackingNumber);
	}
	private String generateOrderTrackingNumber() {
		
		return UUID.randomUUID().toString();
	}

}
