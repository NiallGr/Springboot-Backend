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
		//retrieve the order data info from dto
		Order order = purchase.getOrder();
		
		// generate tracking number
		String orderTrackingNumber = generateOrderTrackingNumber();
		order.setOrderTrackingNumber(orderTrackingNumber);
		
		// populate order with orderItems
		Set<OrderItem> orderItems = purchase.getOrderItems();
		orderItems.forEach(item -> order.add(item));
		
		//Populate order with billing address and shipping address
		order.setBillingAddress(purchase.getBillingAddress());
		order.setShippingAddress(purchase.getShippingAddress());
		Customer customer = purchase.getCustomer();
		
//		// check if this is an existing customer
//        String theEmail = customer.getEmail();
//
//        Customer customerFromDB = CustomerRepository.findByEmail(theEmail);
//
//        if (customerFromDB != null) {
//            // we found them ... let's assign them accordingly
//            customer = customerFromDB;
//        }

		
		customer.add(order);
		
		// Save to the database
		customerRepository.save(customer);
		
		return new PurchaseResponse(orderTrackingNumber);
	}
	private String generateOrderTrackingNumber() {
		// Generate a random UUID Number 
		return UUID.randomUUID().toString();
	}

}
