package com.tran.increase.basics.authority.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author luxiangqian
 * 2022/2/20
 */
@Data
@TableName(value = "tran_basics_authority")
public class TranBasicsAuthority {

    /**
     * id
     */
    @TableId("authority_id")
    private String authorityId;

    /**
     * id
     */
    @TableField("user_id")
    private String userId;

    /**
     * 名称
     */
    @TableField("authority_name")
    private String authorityName;

    /**
     * 操作权限
     */
    @TableField("operate")
    private String operate;

    /**
     * id
     */
    @TableField("view")
    private String view;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private String createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private String updateTime;

}
