package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * order 为 SQL 的保留字, 所以表名要避开
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Builder
@Table(name = "orders")
public class Order extends BaseModel {
    @Enumerated(value = EnumType.STRING)
    private OrderStatus status;

    /**
     * 单向多对一关系: 多个订单 -- 一个地址
     */
    @ManyToOne
    private Address address;

    /**
     * 双向多对一: 多个订单 -- 一个用户
     */
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;
}
