package entity;

/**
 * @ClassName Result
 * @Author lish
 * @Date 2019/4/11 14:46
 * @description Json返回类
 */
public class Result {

    private Integer code;  //返回状态码
    private Boolean flag;  //是否成功
    private String message;//返回信息
    private Object data;   //返回数据

    public Result() {
    }

    public Result(Integer code, Boolean flag, String message) {
        this.code = code;
        this.flag = flag;
        this.message = message;
    }

    public Result(Integer code, Boolean flag, String message, Object data) {
        this.code = code;
        this.flag = flag;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


}
