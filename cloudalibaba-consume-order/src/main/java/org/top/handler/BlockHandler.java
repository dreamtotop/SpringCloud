package org.top.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 处理sentinel配置异常
 */
public class BlockHandler {

    /**
     *  服务降级方法生效的条件，返回值类型、参数个数和类型必须与原生方法一致（泛型，注解修饰的不影响），方法修饰符为public
     *  对于额外的异常参数，要么不添加，要么固定写死 Throwable e
     * @param id
     * @param blockException
     * @return
     */
    public static String handlerBlockException(@PathVariable("id") Long id, BlockException blockException){
        return id + "兜底异常sentinel配置异常handlerBlockException" + blockException.getMessage();
    }
}
