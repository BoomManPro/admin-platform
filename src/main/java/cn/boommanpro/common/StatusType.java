package cn.boommanpro.common;

/**
 * @author <a href="mailto:boommanpro@gmail.com">BoomManPro</a>
 * @data 2019/6/8 17:51
 * @since 1.0.0
 */
public enum StatusType {
    ENABLE(1,"启用"),DISABLE(0,"禁用");

    private int key;
    private String description;

    StatusType(int key, String description) {
        this.key = key;
        this.description = description;
    }

    public int getKey() {
        return key;
    }
}
