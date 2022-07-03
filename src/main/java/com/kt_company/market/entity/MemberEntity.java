package com.kt_company.market.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Table(name = "member")
@Entity
public class MemberEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mem_seq")
    private Long memSeq;

    @Column(name = "id")
    private String id;

    @Column(name = "password")
    private String password;

    @Column(name = "type")
    private String type;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @Builder
    public MemberEntity(String id, String password, String type, String phoneNumber) {
        this.id = id;
        this.password = password;
        this.type = type;
        this.phoneNumber = phoneNumber;
        this.createDate = LocalDateTime.now();
    }

}
