/*
package com.stylefeng.guns.rest.modular.order;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.modular.order.vo.BuyTicketsRequestVO;
import com.stylefeng.guns.rest.service.OrderServiceAPI;
import com.stylefeng.guns.rest.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

*/
/**
 * Created by Gavin
 * on 2019/4/25 16:43
 *//*

@RestController
@RequestMapping("order")
public class OrderController {
    @Reference
    OrderServiceAPI orderServiceAPI;
    @Reference
    UserService userService;
    @RequestMapping("buyTickets")
    public String buyTickets(BuyTicketsRequestVO buyTicketsRequestVO){
        boolean trueSeats = orderServiceAPI.isTrueSeats(buyTicketsRequestVO.getFieldId()+"", buyTicketsRequestVO.getSeatsName());
        if(trueSeats){
            boolean notSoldSeats = orderServiceAPI.isNotSoldSeats(buyTicketsRequestVO.getFieldId()+"", buyTicketsRequestVO.getSoldSeats());
            if(notSoldSeats){
                orderServiceAPI.saveOrderInfo(buyTicketsRequestVO.getFieldId(),buyTicketsRequestVO.getSeatsName(),buyTicketsRequestVO.getSeatsName())
            }
        }
    }
}
*/
