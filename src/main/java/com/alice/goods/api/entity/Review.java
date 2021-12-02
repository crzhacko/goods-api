package com.alice.goods.api.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique =true , nullable = false)
    private Long reviewNo; //리뷰번호
    @Column(length = 11, nullable = false, name = "goods_no")
    private Long goodsNo; //상품번호
    @Column(length = 4 , nullable = false)
    private Integer reviewCnt; //리뷰갯수
    @Column(length = 4 , nullable = false)
    private Integer reviewAvg; //리뷰별점평균

    @OneToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "goods_no", nullable = false, insertable=false, updatable=false)
    private Goods goods;

}
