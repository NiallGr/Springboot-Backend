package StoreBackend.Springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="foodItems")
public class FoodItem {
	
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			private long id;
			
			@Column(name = "food_name")
			private String Name;
			
			@Column(name = "food_group")
			private String FoodGroup; 
			
			@Column(name = "food_price")
			private float Price;
			
			@Column(name = "img_url")
			private String ImgUrl;
			
			

			public FoodItem() {
				
			}
		
			public FoodItem(String name, String foodGroup, float price, String imgUrl) {
				super();
				Name = name;
				FoodGroup = foodGroup;
				Price = price;
				ImgUrl = imgUrl;
			}
			
			public long getId() {
				return id;
			}
			public void setId(long id) {
				this.id = id;
			}
			public String getName() {
				return Name;
			}
			public void setName(String name) {
				Name = name;
			}
			public String getFoodGroup() {
				return FoodGroup;
			}
			public void setFoodGroup(String foodGroup) {
				FoodGroup = foodGroup;
			}
			public float getPrice() {
				return Price;
			}
			public void setPrice(float price) {
				Price = price;
			}
			public String getImgUrl() {
				return ImgUrl;
			}

			public void setImgUrl(String imgUrl) {
				ImgUrl = imgUrl;
			}
			
			
}
