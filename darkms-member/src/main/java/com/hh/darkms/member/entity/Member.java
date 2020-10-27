package com.hh.darkms.member.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("member")
public class Member implements Serializable {
    @TableId
    private Long uid;
    private String name;
    private String account;
    private String password;
    private Long regTime;
    private Integer state;
}
