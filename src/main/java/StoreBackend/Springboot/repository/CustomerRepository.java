package StoreBackend.Springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import StoreBackend.Springboot.model.Customer;
//	
public interface CustomerRepository extends JpaRepository<Customer, Long>{
   
	Customer findByEmail(String theEmail);
}