package com.stylefeng.guns.rest.modular.order.alipay.service.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayRequest;
import com.alipay.api.AlipayResponse;
import com.alipay.api.response.MonitorHeartbeatSynResponse;
import com.stylefeng.guns.rest.modular.order.alipay.model.builder.AlipayHeartbeatSynRequestBuilder;
import com.stylefeng.guns.rest.modular.order.alipay.model.builder.AlipayTradePrecreateRequestBuilder;
import com.stylefeng.guns.rest.modular.order.alipay.model.builder.AlipayTradeRefundRequestBuilder;
import com.stylefeng.guns.rest.modular.order.alipay.model.builder.RequestBuilder;
import com.stylefeng.guns.rest.modular.order.alipay.model.result.AlipayF2FPrecreateResult;
import com.stylefeng.guns.rest.modular.order.alipay.model.result.AlipayF2FRefundResult;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by liuyangkly on 15/10/22.
 */
abstract class AbsAlipayService {
    protected Log log = LogFactory.getLog(getClass());

    // 验证bizContent对象
    protected void validateBuilder(RequestBuilder builder) {
        if (builder == null) {
            throw new NullPointerException("builder should not be NULL!");
        }

        if (!builder.validate()) {
            throw new IllegalStateException("builder validate failed! " + builder.toString());
        }
    }

    // 调用AlipayClient的execute方法，进行远程调用
    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected AlipayResponse getResponse(AlipayClient client, AlipayRequest request) {
        try {
            AlipayResponse response = client.execute(request);
            if (response != null) {
                log.info(response.getBody());
            }
            return response;

        } catch (AlipayApiException e) {
            e.printStackTrace();
            return null;
        }
    }

    public abstract AlipayF2FRefundResult tradeRefund(AlipayTradeRefundRequestBuilder builder);

    public abstract AlipayF2FPrecreateResult tradePrecreate(AlipayTradePrecreateRequestBuilder builder);

    public abstract MonitorHeartbeatSynResponse heartbeatSyn(AlipayHeartbeatSynRequestBuilder builder);
}
