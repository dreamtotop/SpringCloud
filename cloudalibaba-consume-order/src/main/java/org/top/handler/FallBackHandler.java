package org.top.handler;

import org.springframework.web.bind.annotation.PathVariable;

/**
 * 处理业务异常
 */
public class FallBackHandler {

    /**
     *  fallback服务降级方法生效的条件，返回值类型、参数个数和类型必须与原生方法一致（泛型，注解修饰的不影响），方法修饰符为public
     *  对于额外的异常参数，要么不添加，要么固定写死 Throwable e
     * @param id
     * @param e
     * @return
     */
    public static String handlerFallbackException(@PathVariable("id") Long id, Throwable e){
        return id + "兜底异常业务异常handlerFallbackException" + e.getMessage();
    }
}
