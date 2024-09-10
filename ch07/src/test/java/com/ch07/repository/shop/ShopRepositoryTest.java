package com.ch07.repository.shop;

import com.ch07.entity.shop.Customer;
import com.ch07.entity.shop.Order;
import com.ch07.entity.shop.OrderItem;
import com.ch07.entity.shop.Product;
import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class ShopRepositoryTest {

    @Autowired private CustomerRepository customerRepository;
    @Autowired private OrderRepository orderRepository;
    @Autowired private OrderItemRepository orderItemRepository;
    @Autowired private ProductRepository productRepository;

    // 테스트1
    @Test
    public void insertCustomer() {
        Customer customer = Customer.builder()
                .custId("a101")
                .name("김춘추")
                .age(20)
                .hp("010-1111-1111")
                .addr("부산진구")
                .build();

        customerRepository.save(customer);
    }

    // 테스트2

    @Test
    public void insertProduct() {
        Product product1 = Product.builder()
                .prodName("포카칩")
                .price(1900)
                .stock(100)
                .build();

        Product product2 = Product.builder()
                .prodName("마가렛트")
                .price(3000)
                .stock(50)
                .build();

        productRepository.save(product1);
        productRepository.save(product2);
    }

    @Test
    public void insertOrder() {
        Customer customer = Customer.builder()
                .custId("a101")
                .build();

        Product product1 = Product.builder().prodId(1).build();
        Product product2 = Product.builder().prodId(2).build();

        Order order = Order.builder()
                .customer(customer)
                .orderPrice(3000)
                .orderStatus(1)
                .build();

        orderRepository.save(order);
    }

    @Test
    public void insertOrderItem(){

        Order order = Order.builder().orderId(1).build();
        Product product1 = Product.builder().prodId(1).build();
        Product product2 = Product.builder().prodId(2).build();

        OrderItem item1 = OrderItem.builder()
                .order(order)
                .product(product1)
                .count(2)
                .build();

        OrderItem item2 = OrderItem.builder()
                .order(order)
                .product(product2)
                .count(3)
                .build();

        orderItemRepository.save(item1);
        orderItemRepository.save(item2);
    }

    // 테스트5 - 주문 조회
    @Transactional
    @Test
    public void selectOrder(){
        List<Order> orders = orderRepository.findAll();
        System.out.println(orders);
    }



}