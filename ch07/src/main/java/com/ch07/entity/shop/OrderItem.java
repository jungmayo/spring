package com.ch07.entity.shop;

import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "order")
@Builder
@Entity
@Table(name = "shop_order_item")
public class OrderItem {

    @Id
    private int orderItemId;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "prodId")
    private Product product;

    private int count;
}