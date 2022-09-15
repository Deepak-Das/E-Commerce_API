package com.example.ecommerce.model.Product_models.orders;

import com.example.ecommerce.model.Address;
import com.example.ecommerce.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_order")
public class TbOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long orderId;

    private Date orderDate;
    @Column(nullable = false)
    private int Gst;

    @Column(nullable = false)
    private int discount;

    @Column(nullable = false)
    private int totalAmt;

    @Column(nullable = false,length = 20)
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;
    @ManyToOne
    @JoinColumn(name = "order_detail_id")
    private TbOrderDetail orderDetail;

}