package refrigerators.controller.to;


public class FrontPostTo<T> {
    boolean success;
    T data;

    public FrontPostTo() {
    }

    public FrontPostTo(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "FrontPostTo{" +
                "success=" + success +
                ", data=" + data +
                '}';
    }
}
