package com.stylefeng.guns.rest.persistence.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 地域信息表
 * </p>
 *
 * @author Gavin
 * @since 2019-04-23
 */
@TableName("mtime_hall_dict_t")
public class MtimeHallDictT extends Model<MtimeHallDictT> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
    @TableId(value = "UUID", type = IdType.AUTO)
    private Integer uuid;
    /**
     * 显示名称
     */
    @TableField("show_name")
    private String showName;
    /**
     * 座位文件存放地址
     */
    @TableField("seat_address")
    private String seatAddress;


    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getSeatAddress() {
        return seatAddress;
    }

    public void setSeatAddress(String seatAddress) {
        this.seatAddress = seatAddress;
    }

    @Override
    protected Serializable pkVal() {
        return this.uuid;
    }

    @Override
    public String toString() {
        return "MtimeHallDictT{" +
        "uuid=" + uuid +
        ", showName=" + showName +
        ", seatAddress=" + seatAddress +
        "}";
    }
}
