package cn.boommanpro.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author <a href="mailto:boommanpro@gmail.com">BoomManPro</a>
 * @data 2019/6/8 17:51
 * @since 1.0.0
 */
@Data
public class CallResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private String code;

    private String message;

    private T result;

    private final static String SUCCESS_CODE="SUCCESS";

    private final static String ERROR_CODE="ERROR";


    public CallResult(String code, String message, T result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }


    public static<T> CallResult<T> success(T result){
        return new CallResult<>(SUCCESS_CODE, null, result);
    }

    public static<T> CallResult<T> success(){
        return new CallResult<>(SUCCESS_CODE, null, null);
    }


    public static CallResult error(String message){
        return new CallResult<>(ERROR_CODE, message,null);
    }

}
