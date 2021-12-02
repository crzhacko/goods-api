package com.alice.goods.api.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
//@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class TestDto {
    private Integer Uid;
    private String Name;
    private String NickName;
    private String Phone;
    private String Sex;

    public TestDto(Integer uid, String name, String nickName, String phone, String sex) {
        Uid = uid;
        Name = name;
        NickName = nickName;
        Phone = phone;
        Sex = sex;
    }
}
