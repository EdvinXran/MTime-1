package com.stylefeng.guns.rest.persistence.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * ??????Ϣ?
 * </p>
 *
 * @author stylefeng
 * @since 2019-04-25
 */
@TableName("mtime_order_t")
public class MtimeOrderT extends Model<MtimeOrderT> {

    private static final long serialVersionUID = 1L;

    /**
     * ???????
     */
    @TableField("UUID")
    private String uuid;
    /**
     * ӰԺ???
     */
    @TableField("cinema_id")
    private Integer cinemaId;
    /**
     * ??ӳ???α??
     */
    @TableField("field_id")
    private Integer fieldId;
    /**
     * ??Ӱ???
     */
    @TableField("film_id")
    private Integer filmId;
    /**
     * ??????λ???
     */
    @TableField("seats_ids")
    private String seatsIds;
    /**
     * ??????λ?
     */
    @TableField("seats_name")
    private String seatsName;
    /**
     * ӰƬ?ۼ
     */
    @TableField("film_price")
    private Double filmPrice;
    /**
     * ?????ܽ
     */
    @TableField("order_price")
    private Double orderPrice;
    /**
     * ?µ?ʱ?
     */
    @TableField("order_time")
    private Date orderTime;
    /**
     * ?µ??
     */
    @TableField("order_user")
    private Integer orderUser;
    /**
     * 0-??֧??,1-??֧??,2-?ѹر
     */
    @TableField("order_status")
    private Integer orderStatus;


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Integer cinemaId) {
        this.cinemaId = cinemaId;
    }

    public Integer getFieldId() {
        return fieldId;
    }

    public void setFieldId(Integer fieldId) {
        this.fieldId = fieldId;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public String getSeatsIds() {
        return seatsIds;
    }

    public void setSeatsIds(String seatsIds) {
        this.seatsIds = seatsIds;
    }

    public String getSeatsName() {
        return seatsName;
    }

    public void setSeatsName(String seatsName) {
        this.seatsName = seatsName;
    }

    public Double getFilmPrice() {
        return filmPrice;
    }

    public void setFilmPrice(Double filmPrice) {
        this.filmPrice = filmPrice;
    }

    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Integer getOrderUser() {
        return orderUser;
    }

    public void setOrderUser(Integer orderUser) {
        this.orderUser = orderUser;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "MtimeOrderT{" +
        "uuid=" + uuid +
        ", cinemaId=" + cinemaId +
        ", fieldId=" + fieldId +
        ", filmId=" + filmId +
        ", seatsIds=" + seatsIds +
        ", seatsName=" + seatsName +
        ", filmPrice=" + filmPrice +
        ", orderPrice=" + orderPrice +
        ", orderTime=" + orderTime +
        ", orderUser=" + orderUser +
        ", orderStatus=" + orderStatus +
        "}";
    }
}
