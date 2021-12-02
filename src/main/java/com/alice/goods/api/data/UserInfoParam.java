package com.alice.goods.api.data;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class UserInfoParam {

    private String Name;
    private String NickName;
    private String PassWord;
    private String Phone;
    private String Email;
    private String Sex;

}
