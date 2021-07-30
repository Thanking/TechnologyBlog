package com.example.emnu;

/**
 * @author : manster
 * @version : 1.0
 * @ClassName : Message
 * @Description : TODO
 * @date : 2021/7/23 19:46
 * 枚举类
 * 返回操作结果
 **/
public enum  Message {
    SUCCESS_ADD("新增成功"),
    FAILED_ADD ("新增失败"),
    SUCCESS_EDIT ("修改成功"),
    FAILED_EDIT ("修改失败"),
    SUCCESS_DEL("删除成功"),
    FAILED_DEL("删除失败");

    private final String msg;

    private Message(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return msg ;
    }
}
