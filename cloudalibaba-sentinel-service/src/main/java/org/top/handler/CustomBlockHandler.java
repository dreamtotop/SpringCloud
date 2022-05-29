package org.top.handler;

import org.top.model.Payment;
import org.top.response.CommonResult;

public class CustomBlockHandler {

    public static CommonResult handlerGlobalException(){
        return new CommonResult(444, "自定义全局异常处理", new Payment(1000L, "1000L"));
    }

    public static CommonResult handlerException(){
        return new CommonResult(444, "自定义异常处理", new Payment(1001L, "1001L"));
    }

}
