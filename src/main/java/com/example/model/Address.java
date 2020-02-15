package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Builder
public class Address extends BaseModel {
    @Column(nullable = false)
    private String location;

    @Size(max = 255)
    private String phoneNumber;

    //    @Column(name = "favorite", columnDefinition = "tinyint(1) default 0")
    private Boolean favorite;

    @Column(name = "user_id", nullable = false)
    private Long userId;
}
