package com.stylefeng.guns.rest.modular.order.alipay.model.hb;

import com.stylefeng.guns.rest.modular.order.alipay.utils.Utils ;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by liuyangkly on 15/8/27.
 */
public class ExceptionInfoAdapter implements JsonSerializer<List<ExceptionInfo>> {
    @Override
    public JsonElement serialize(List<ExceptionInfo> exceptionInfos, Type type, JsonSerializationContext jsonSerializationContext) {
        if (Utils.isListEmpty(exceptionInfos)) {
            return null;
        }

        return new JsonPrimitive(StringUtils.join(exceptionInfos, "|"));
    }
}
