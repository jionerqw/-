public class Result {
    private String msg;
    private int code;

    public Result(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }

    public Result() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
