package com.example.ecommerce.model.Product_models.orders;

import com.example.ecommerce.model.Product_models.Product;
import com.example.ecommerce.model.Product_models.details.ProductColor;
import com.example.ecommerce.model.Product_models.details.ProductShape;
import com.example.ecommerce.model.Product_models.details.ProductSize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "order_detail")
public class TbOrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderDetailId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;




    private Integer amount;

    @ManyToOne()
    @JoinColumn(name = "order_id")
    private TbOrder Tborder;

    @OneToOne
    @JoinColumn(name = "track_id",referencedColumnName = "trackId")
    private Tracking tracking;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "color_id")
    private ProductColor productColor;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "shape_id")
    private ProductShape productShape;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "size_id")
    private ProductSize productSize;

}