package org.example.modle;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
@Getter
@Setter
@ToString
public class User {
    private Integer id;
    private String username;
    private String password;
    private String nickname;//昵称
    private Boolean sex;
    private Date birthday;
    private String head;//头像
}
