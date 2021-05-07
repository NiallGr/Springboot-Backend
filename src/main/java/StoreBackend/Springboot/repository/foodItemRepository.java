package StoreBackend.Springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import StoreBackend.Springboot.model.FoodItem;

@Repository
public interface foodItemRepository extends JpaRepository<FoodItem, Long>{

}
