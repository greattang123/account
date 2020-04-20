package com.example.account.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /* 顾客消费时间 */
    private String time;
    /* 单次消费金额 */
    private float expense;
    @ManyToOne
    private User user;
    @ManyToOne
    private Shop shop;
}
