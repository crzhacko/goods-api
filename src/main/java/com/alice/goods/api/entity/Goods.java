package com.alice.goods.api.entity;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name = "goods")
public class Goods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique =true , nullable = false)
    private Long goodsNo; //상품번호
    @Column(length = 100 , nullable = false)
    private String goodsNm; //상품명
    @Column(length = 300)
    private String goodsCont; //상품설명
    @Column(length = 20)
    private String comId; //업체아이디
    @Column(length = 20)
    private LocalDateTime regDm; //상품정보 최초등록일시
    @Column(length = 100)
    private LocalDateTime updDm; //상품정보 수정일시
    @Column(length = 100, nullable = false)
    private String goodsImg; //이미지경로
    @Column(length = 11, nullable = false)
    private Integer price; //가격정보

   /* @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goods_no")*/
   // @MapsId("goods_no")
    @OneToOne(mappedBy = "goods", fetch = FetchType.EAGER)
    private Review review;

//    public int getReviewCnt() {
//        if (reviews == null) {
//            return 0;
//        }
//        return reviews.size();
//    }
//
//    public int getReviewAvg() {
//        if (reviews == null) {
//            return 0;
//        }
//        reviews
//                .stream()
//                .collect(
//                        Collectors.groupingBy(
//                                Product::getCurrency,
//                                Collectors.averagingInt(Product::getQuantity)));
//
//
//    }
}
