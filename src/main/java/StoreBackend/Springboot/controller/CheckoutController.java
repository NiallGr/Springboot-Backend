package StoreBackend.Springboot.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import StoreBackend.Springboot.dto.Purchase;
import StoreBackend.Springboot.dto.PurchaseResponse;
import StoreBackend.Springboot.service.CheckoutService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/checkout")
public class CheckoutController {
	
		private CheckoutService checkoutService;
		
		public CheckoutController(CheckoutService checkoutService) {
			this.checkoutService = checkoutService;
		}

		
		@PostMapping("purchase")
		public PurchaseResponse palceorder(@RequestBody Purchase purchase) {
			
			PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);
			
			return purchaseResponse;
		}
}
