package com.alice.goods.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GoodsDto {

    private Long goodsNo;           // 상품번호
    @NotNull(message = "goodsNm은 필수 입력입니다.")
    private String goodsNm;         // 상품명
    private String goodsCont;       // 상품설명
    @NotNull(message = "price 필수 입력입니다.")
    private Integer price;          // 가격정보
    @NotNull(message = "goodsImg 필수 입력입니다.")
    private String goodsImg;        // 이미지경로
    private String comId;           // 업체 아이디
    private LocalDateTime regDm;    // 상품정보 최초등록일시
    private LocalDateTime updDm;    // 상품정보 수정일시
    private Integer reviewCnt;      // 리뷰갯수
    private Integer reviewAvg;      // 리뷰별점평균

}
