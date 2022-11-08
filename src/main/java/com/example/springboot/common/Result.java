package com.example.springboot.common;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result {

    private Boolean success;

    private Integer code;

    private String msg;

    private Object data;

    public static Result success(){
        return new Result(true,200,"success",null);
    }

    public static Result success(Object data){
        return new Result(true,200,"success",data);
    }

    public static Result fail(Integer code,String msg){
        return new Result(false,code,msg,null);
    }
}
