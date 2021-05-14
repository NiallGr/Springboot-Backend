package StoreBackend.Springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import StoreBackend.Springboot.exception.resourceNotFoundException;
import StoreBackend.Springboot.model.FoodItem;
import StoreBackend.Springboot.repository.foodItemRepository;

// connect between Angular and Spring
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
public class foodItemController {

	@Autowired
	private foodItemRepository FoodItemRepository;

// get all FoodItems API

	@GetMapping("/foodItems")
	public List<FoodItem> getAllFoodItem() {
		return FoodItemRepository.findAll();
	}


// Create FoodItem API
	@PostMapping("/foodItems")
	public FoodItem createFoodItem(@RequestBody FoodItem fooditem) {
		return FoodItemRepository.save(fooditem);
	}

// Get FoodItem by ID API
	@GetMapping("/foodItems/{id}")
	public ResponseEntity<FoodItem> getFoodItemById(@PathVariable Long id) {
		
		FoodItem fooditem = FoodItemRepository.findById(id)
				.orElseThrow(() -> new resourceNotFoundException("Food Item does not exist with id :" + id));
			return ResponseEntity.ok(fooditem);
		}
	
// updated FoodItem API
	@PutMapping("/foodItems/{id}")
	public ResponseEntity<FoodItem> updateFoodItem(@PathVariable Long id, @RequestBody FoodItem foodItemDetails) {
		  
		FoodItem fooditem = FoodItemRepository.findById(id)
				.orElseThrow(() -> new resourceNotFoundException("Food Item does not exist with id :" + id));
		
		fooditem.setName(foodItemDetails.getName());
		fooditem.setFoodGroup(foodItemDetails.getFoodGroup());
		fooditem.setPrice(foodItemDetails.getPrice());
		
		FoodItem updateFoodItem = FoodItemRepository.save(fooditem);
		return ResponseEntity.ok(updateFoodItem);
	}
	
// Delete FoodItem API
	@DeleteMapping("/foodItems/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteFoodItem(@PathVariable Long id) {
		FoodItem fooditem = FoodItemRepository.findById(id)
				.orElseThrow(() -> new resourceNotFoundException("Food Item does not exist with id :" + id));
		
		FoodItemRepository.delete(fooditem);
		Map<String, Boolean> responce = new HashMap<>();
		responce.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(responce);
	}
}