package com.example.ecommerce.model.Product_models.orders;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tracking")
public class Tracking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private long trackId;

    @Column(nullable = false,length = 100)
    private String shipment,delivery,dispatch,currentStatus;
    private Boolean isCancel,isReqReturn;

    private Date deliveryDate,shipmentDate,dispatchDate;

    @OneToOne
    @JoinColumn(name = "order_detail_id",referencedColumnName = "OrderDetailId")
    private TbOrderDetail orderDetail;
}