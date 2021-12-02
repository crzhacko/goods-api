
-- DB INFO

CREATE TABLE `member` (
    `uid` int NOT NULL AUTO_INCREMENT,
    `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `nickname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `sex` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
     PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE `goods` (
    `goods_no` int(11) NOT NULL DEFAULT '0' COMMENT '상품번호',
    `goods_nm` varchar(100) DEFAULT NULL COMMENT '상품명',
    `goods_cont` text COMMENT '상품설명',
    `com_id` varchar(20) DEFAULT NULL COMMENT '업체 아이디',
    `reg_dm` datetime DEFAULT NULL COMMENT '상품정보 최초등록일시',
    `upd_dm` datetime DEFAULT NULL COMMENT '상품정보 수정일시',
    `goods_img` varchar(100) NOT NULL DEFAULT ''  datetime COMMENT '이미지경로',
    `price` int(11) NOT NULL DEFAULT '0' COMMENT '상품가격',
     PRIMARY KEY (`goods_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='상품마스터'

CREATE TABLE `review` (
     `review_no` int(11) NOT NULL DEFAULT '0' COMMENT '리뷰번호',
     `goods_no` int(11) NOT NULL DEFAULT '0' COMMENT '상품번호',
     `review_cnt` int(4) DEFAULT NULL COMMENT '리뷰갯수',
     `review_avg` text COMMENT '리뷰별점평균',
      PRIMARY KEY (`review_no`),
      FOREIGN KEY ('goods_no') REFERENCES goods('goods_no')
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='리뷰'