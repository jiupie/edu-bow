package com.wl.common.base;

import com.wl.common.enums.ResultCode;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
@Data
public class ResponseDTO<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 1:成功
     * 1002：服务器内容错误
     */
    private Integer state;
    private String message;
    private T content;

    public ResponseDTO(){

    }

    public ResponseDTO(int state, String message, T content) {
        this.state = state;
        this.message = message;
        this.content = content;
    }

    public static <T> ResponseDTO<T> response(int state,String message){
        return response(state,message,null);
    }

    public static <T> ResponseDTO<T> response(int state,String message,T content){
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setState(state);
        responseDTO.setContent(content);
        responseDTO.setMessage(message);
        return responseDTO;
    }

    public static <T> ResponseDTO<T> response(ResultCode resultCode, T content){
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setState(resultCode.getCode());
        responseDTO.setContent(content);
        responseDTO.setMessage(resultCode.getMessage());
        return responseDTO;
    }

    public static <T> ResponseDTO<T> response(ResultCode resultCode,String message, T content){
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setState(resultCode.getCode());
        responseDTO.setContent(content);
        responseDTO.setMessage(message);
        return responseDTO;
    }


    public static <T> ResponseDTO<T> success(){
        return ResponseDTO.response(ResultCode.SUCCESS,null);
    }

    public static <T> ResponseDTO<T> success(T content){
        return ResponseDTO.response(ResultCode.SUCCESS,content);
    }

    public static <T> ResponseDTO<T> ofError(int state,String message,T content){
        return ResponseDTO.response(state,message,content);
    }

    public static <T> ResponseDTO<T> ofError(int state,String message){
        return ResponseDTO.response(state,message,null);
    }

    public static <T> ResponseDTO<T> ofError(String message){
        return ResponseDTO.response(ResultCode.ERROR,message,null);
    }
}