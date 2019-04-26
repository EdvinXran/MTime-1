package com.stylefeng.guns.rest.modular.order;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.rest.modular.auth.util.JwtTokenUtil;
import com.stylefeng.guns.rest.modular.order.alipay.PayUtil;
import com.stylefeng.guns.rest.persistence.model.*;
import com.stylefeng.guns.rest.service.OrderServiceAPI;
import com.stylefeng.guns.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;


@RestController
@RequestMapping("order")
public class OrderController {
    @Reference
    OrderServiceAPI orderServiceAPI;
    @Reference
    UserService userService;
    @Autowired
    JwtTokenUtil jwtTokenUtil;
    public  int getUserIdByToken(String token) throws Exception {
        String username = jwtTokenUtil.getUsernameFromToken(token);
        UserInfoVo userInfoVo = userService.selectByUserName(username);
        Integer userId = userInfoVo.getUuid();
        return userId;
    }
    @RequestMapping("buyTickets")
    public OrderResponseVO buyTickets(BuyTicketsRequestVO buyTicketsRequestVO,String token) throws Exception {
        int userId = getUserIdByToken(token);
        OrderResponseVO orderResponseVO = new OrderResponseVO();
        boolean trueSeats = orderServiceAPI.isTrueSeats(buyTicketsRequestVO.getFieldId()+"", buyTicketsRequestVO.getSeatsName());
        if(trueSeats){
            boolean notSoldSeats = orderServiceAPI.isNotSoldSeats(buyTicketsRequestVO.getFieldId()+"", buyTicketsRequestVO.getSoldSeats());
            if(notSoldSeats){
                //userId怎么拿？
                OrderVO orderVO = orderServiceAPI.saveOrderInfo(buyTicketsRequestVO.getFieldId(), buyTicketsRequestVO.getSeatsName(), buyTicketsRequestVO.getSeatsName(), userId);
                if(orderVO!=null) {
                    orderResponseVO.setStatus(0);
                    orderResponseVO.setMsg("");
                    HashMap<String, Object> data = new HashMap<>();
                    data.put("orderId", orderVO.getOrderId());
                    data.put("filmName", orderVO.getFilmName());
                    data.put("fieldTime", orderVO.getFieldTime());
                    data.put("cinemaName", orderVO.getCinemaName());
                    data.put("seatsName", orderVO.getSeatsName());
                    data.put("orderPrice", orderVO.getOrderPrice());
                    data.put("orderTimestamp", orderVO.getOrderTimestamp());
                    orderResponseVO.setData(data);
                }else {
                    orderResponseVO.setStatus(1);
                    orderResponseVO.setMsg("该订单不存在");
                }
                return orderResponseVO;
            }
        }
        orderResponseVO.setStatus(1);
        orderResponseVO.setMsg("该订单不存在");
        return orderResponseVO;
    }
    @RequestMapping("getOrderInfo")
    public OrderResponseVO getOrderInfo(int nowPage,int pageSize,String token) throws Exception {
        int userId = getUserIdByToken(token);
        //数据校验
        if(nowPage==0){
            nowPage=1;
        }
        if(pageSize==0){
            pageSize=5;
        }
        Page<OrderVO> page = new Page<>();
        page.setCurrent(nowPage);
        page.setSize(pageSize);
        OrderResponseVO orderResponseVO = new OrderResponseVO();
        try {
            HashMap<String, Object> data = new HashMap<>();
            Page<OrderVO> orderByUserId = orderServiceAPI.getOrderByUserId(userId, page);
            if(orderByUserId.getRecords().size()>=0) {
                data.put("data", orderByUserId.getRecords());
                orderResponseVO.setStatus(0);
                orderResponseVO.setMsg("");
                orderResponseVO.setData(data);
            }else {
                orderResponseVO.setStatus(1);
                orderResponseVO.setMsg("订单列表为空哦~");
            }
            return orderResponseVO;
        } catch (Exception e) {
            e.printStackTrace();
            orderResponseVO.setStatus(999);
            orderResponseVO.setMsg("系统出现异常");
            return orderResponseVO;
        }
    }

    @RequestMapping(value = "getPayInfo" ,method = RequestMethod.POST)
   public PayInfoResponseVO getPayInfo(int orderId){
        PayInfoResponseVO payInfoResponseVO = new PayInfoResponseVO();
        try {
            OrderVO orderVO = orderServiceAPI.getOrderInfoById(orderId + "");
            String seatsName = orderVO.getSeatsName();
            String cinemaName = orderVO.getCinemaName();
            String orderPrice = orderVO.getOrderPrice();
            String payQR = PayUtil.getPayQR(orderPrice, cinemaName, seatsName);
            if(payQR!=null){
                payInfoResponseVO.setStatus(0);
                payInfoResponseVO.setImgPre("");
                HashMap<String, Object> map = new HashMap<>();
                map.put("orderId",orderId);
                map.put("QRCodeAddress","QRCodes/"+payQR);
                payInfoResponseVO.setData(map);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return payInfoResponseVO;
    }

    @RequestMapping(value = "getPayResult",method = RequestMethod.POST)
    public PayResultResponseVO getPayResult(int orderId,int tryNums){
        boolean b = PayUtil.testPay(orderId + "");
        PayResultResponseVO payResultResponseVO = new PayResultResponseVO();
        if(b){
            orderServiceAPI.paySuccess(orderId);
            payResultResponseVO.setStatus(0);
            HashMap<String, Object> map = new HashMap<>();
            map.put("orderId",orderId);
            map.put("orderStatus",1);
            map.put("orderMsg","支付成功");
            payResultResponseVO.setData(map);
        }
        return payResultResponseVO;
    }
}
