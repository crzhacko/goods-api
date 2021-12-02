package com.alice.goods.api.repository;

import com.alice.goods.api.dto.TestDto;


public interface TestRepository {
    TestDto selectGetUserInfo(Integer uid);

}
