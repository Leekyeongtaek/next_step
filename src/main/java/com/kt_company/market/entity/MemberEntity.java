package com.kt_company.market.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "member")
@Entity
public class MemberEntity {

    @Id @GeneratedValue
    @Column(name = "mem_seq")
    private Long memSeq;

    @Column(name = "id")
    private String id;

    @Column(name = "password")
    private String password;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

}
