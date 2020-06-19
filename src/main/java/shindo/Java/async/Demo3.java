package shindo.Java.async;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * 异步转同步方案：试用线程的future特性
 */
public class Demo3 {
    private AsyncCall asyncCall = new AsyncCall();

    public Future<Long> call(){
        Future<Long> future = asyncCall.futureCall();
        asyncCall.shutdown();
        return future;
    }

    public static void main(String[] args) {
        Demo3 demo3 = new Demo3();
        System.out.println("发起调用");
        Future<Long> future = demo3.call();
        System.out.println("调用结果");

        while (!future.isDone() && !future.isCancelled());

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("主线程内容");


    }
}
