package StoreBackend.Springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import StoreBackend.Springboot.model.FoodItem;
import StoreBackend.Springboot.repository.foodItemRepository;

// connect between Angular and Spring
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
public class foodItemController {

	@Autowired
	private foodItemRepository FoodItemRepository;

// get all fooditems

	@GetMapping("/foodItems")
	public List<FoodItem> getAllFoodItem() {
		return FoodItemRepository.findAll();
	}


// Create FoodItem 
	@PostMapping("/foodItems")
	public FoodItem createFoodItem(@RequestBody FoodItem fooditem) {
		return FoodItemRepository.save(fooditem);
	}
	
}