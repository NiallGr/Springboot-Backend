package StoreBackend.Springboot.service;

import StoreBackend.Springboot.dto.Purchase;
import StoreBackend.Springboot.dto.PurchaseResponse;

public interface CheckoutService {
	
	PurchaseResponse placeOrder(Purchase purchase);

}
