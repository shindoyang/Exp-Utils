package shindo.Java.generic.demo4;

//首先泛型
public class Info<T> {
    private T var;// 定义泛型变量

    public void setVar(T var) {
        this.var = var;
    }

    public T getVar() {
        return this.var;
    }

    @Override
    public String toString() { // 直接打印
        return this.var.toString();
    }
}
