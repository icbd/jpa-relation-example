package com.example.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Builder
public class User extends BaseModel {
    @Size(max = 255)
    private String name;

    @Email
    @Column(unique = true)
    private String email;

    /**
     * 单向一对多关系: 一个用户 -- 多个地址
     */
    @OneToMany(fetch = FetchType.LAZY)
    @JsonManagedReference
    @OrderBy("updatedAt DESC")
    @JoinColumn(name = "user_id")
    private List<Address> addresses = new ArrayList<Address>();


    /**
     * 双向一对多: 一个用户 -- 多个订单
     */
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Order> orders = new ArrayList<Order>();
}
