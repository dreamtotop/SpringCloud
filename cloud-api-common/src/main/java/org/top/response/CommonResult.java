package org.top.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {

    private Integer code;

    private String message;

    private T data;

    public CommonResult(Integer code,String message){
        this(code,message,null);
    }

    public static CommonResult ok(){
        return new CommonResult(200,"success",null);
    }

    public static CommonResult ok(Integer code , String message){
        return new CommonResult(code,message,null);
    }

    public static CommonResult ok(Object object){
        return new CommonResult(200,"success",object);
    }

    public static CommonResult error(){
        return new CommonResult(400,"fail",null);
    }

    public static CommonResult error(Integer code , String message){
        return new CommonResult(code,message,null);
    }

}
