package com.tran.increase.basics.authority.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author luxiangqian
 * 2022/2/20
 */
@TableName(value = "tran_basics_user")
@Data
public class TranBasicsUser {

    /**
     *用户ID
     */
    @TableId("user_id")
    private String userId;

    /**
     *用户名称
     */
    @TableField("name")
    private String name;

    /**
     *头像文件ID
     */
    @TableField("name")
    private String portrait_info;

    /**
     *用户密码
     */
    @TableField("name")
    private String password;

    /**
     *创建时间
     */
    @TableField("create_date")
    private String nickname;

    /**
     *创建时间
     */
    @TableField("create_date")
    private String createDate;

    /**
     *更新时间
     */
    @TableField("name")
    private String update_data;

    /**
     *用户状态
     */
    @TableField("stateus")
    private String stateus;

    /**
     *用户名称
     */
    @TableField("token")
    private String token;

    /**
     *用户名称
     */
    @TableField("phone")
    private String phone;

    /**
     *email
     */
    @TableField("email")
    private String email;
}
