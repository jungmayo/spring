
package com.ch07.repository.shop;

import com.ch07.entity.shop.Customer;
import com.ch07.repository.shop.custom.CustomerRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

//jpa로도(~~frombyId, customerRepository) 실행가능하고 확장클래스로도 실행 가능함
public interface CustomerRepository extends JpaRepository<Customer, String> , CustomerRepositoryCustom {
}