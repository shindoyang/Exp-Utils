package shindo.Java.generic.demo9;

//泛型数组
public class Test {
    public static void main(String[] args) {
        Integer i[] = fun1(1, 2, 3, 4, 5, 6);// 返回泛型数组
        fun2(i);
    }

    public static <T> T[] fun1(T... arg) {// 接收可变参数
        return arg;
    }

    public static <T> void fun2(T param[]) {// 输出
        System.out.println("接收泛型数组：");
        for (T t : param) {
            System.out.print(t + "、");
        }
    }
}
