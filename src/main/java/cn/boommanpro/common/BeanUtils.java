package cn.boommanpro.common;

/**
 * @author <a href="mailto:boommanpro@gmail.com">BoomManPro</a>
 * @data 2019/6/8 17:51
 * @since 1.0.0
 */
public class BeanUtils {

    public static void copyProperties(Object source, Object target){
        org.springframework.beans.BeanUtils.copyProperties(source,target);
    }
}
