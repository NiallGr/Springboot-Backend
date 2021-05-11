package StoreBackend.Springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

// get all FoodItems

	@GetMapping("/foodItems")
	public List<FoodItem> getAllFoodItem() {
		return FoodItemRepository.findAll();
	}


// Create FoodItem 
	@PostMapping("/foodItems")
	public FoodItem createFoodItem(@RequestBody FoodItem fooditem) {
		return FoodItemRepository.save(fooditem);
	}

// Get FoodItem by ID 
	@GetMapping("/foodItems/{id}")
	public ResponseEntity<FoodItem> getFoodItemById(@PathVariable Long id) {
		
		FoodItem fooditem = FoodItemRepository.findById(id)
				.orElseThrow(() -> new resourceNotFoundException("Food Item does not exist with id :" + id));
			return ResponseEntity.ok(fooditem);
		}
}