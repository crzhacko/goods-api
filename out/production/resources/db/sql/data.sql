
-- sql insert

INSERT INTO `goods` (`goods_no`, `com_id`, `goods_cont`, `goods_img`,`goods_nm`, `price`, `reg_dm`, `upd_dm`) VALUES
(1001, '커버낫', 'test', '20210916/2134813/2134813_2_125.jpg','[이도현 착용]RDS 유틸리티 다운 점퍼 블랙',15000,'2021-11-30','2021-11-30'),
(1002, '라퍼지스토어', 'test', '20210813/2064478/2064478_3_125.jpg','[이동휘 착용][3M 신슐레이트]오리지널 M-',12000,'2021-11-30','2021-11-30'),
(1003, '인사일런스', 'test', '20190812/1115974/1115974_3_125.jpg','캐시미어 더블 롱 코트 BLACK',13000,'2021-11-30','2021-11-30'),
(1004, '커버낫', 'test', '20200915/1603539/1603539_2_125.jpg','보아 코치 자켓 블랙',11000,'2021-11-30','2021-11-30'),
(1005, '아디다스', 'test', '20200603/1473136/1473136_4_125.jpg','오즈위고 - 트리플블랙',17000,'2021-11-30','2021-11-30'),
(1006, '라퍼지스토어', 'test', '20191001/1173366/1173366_6_125.jpg','[무봉제]덕다운 심리스 미니멀 푸퍼 숏패딩_Black',16000,'2021-11-30','2021-11-30'),
(1007, '디스이즈네버댓', 'test', '20210831/2099753/2099753_1_125.jpg','PERTEX® T Down Jacket Grey',18000,'2021-11-30','2021-11-30'),
(1008, '마크 곤잘레스', 'test', '20210111/1742347/1742347_2_125.jpg','엔젤 와펜 맨투맨 블랙',13000,'2021-11-30','2021-11-30'),
(1009, '내셔널지오그래픽', 'test', '20210826/2090574/2090574_1_125.jpg','N214UDW890 카이만 PRO RDS 구스 다운 점퍼 SMALL LOGO BLACK',11000,'2021-11-30','2021-11-30'),
(1010, '인사일런스', 'test', '20210826/2090574/2090574_1_125.jpg','MTR 싱글 코트 BLACK',17000,'2021-11-30','2021-11-30'),
(1011, '라퍼지스토어', 'test', '20191001/1173366/1173366_6_125.jpg','[무봉제]덕다운 심리스 미니멀 푸퍼 숏패딩_Black',16000,'2021-11-30','2021-11-30'),
(1012, '디스이즈네버댓', 'test', '20210111/1742347/1742347_2_125.jpg','엔젤 와펜 맨투맨 블랙',18000,'2021-11-30','2021-11-30'),
(1013, '커버낫', 'test', '20200915/1603539/1603539_2_125.jpg','보아 코치 자켓 블랙',11000,'2021-11-30','2021-11-30'),
(1014, '아디다스', 'test', '20200603/1473136/1473136_4_125.jpg','오즈위고 - 트리플블랙',17000,'2021-11-30','2021-11-30'),
(1015, '라퍼지스토어', 'test', '20191001/1173366/1173366_6_125.jpg','[무봉제]덕다운 심리스 미니멀 푸퍼 숏패딩_Black',16000,'2021-11-30','2021-11-30'),
(1016, '디스이즈네버댓', 'test', '20210111/1742347/1742347_2_125.jpg','엔젤 와펜 맨투맨 블랙',18000,'2021-11-30','2021-11-30');


INSERT INTO `review` (`review_no`,`goods_no`, `review_cnt`, `review_avg`) VALUES
(1, 1001, 254, 4 ),
(2, 1002, 823, 4.5 ),
(3, 1003, 22, 3 ),
(4, 1004, 323, 2 ),
(5, 1005, 120, 5 ),
(6, 1006, 1, 4.5 ),
(7, 1007, 10, 4 ),
(8, 1008, 555, 5 ),
(9, 1009, 1000, 5 ),
(10, 1010, 23, 5 );