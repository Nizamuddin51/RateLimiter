package RateLimiter.SlidingWindow;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static RateLimiter.SlidingWindow.Constants.*;


public class Application {
    public static void function1(Double answer) throws InterruptedException {
        UserBucketCreator userBucketCreator = new UserBucketCreator(1, TIME_WINDOW_IN_SECONDS, BUCKET_SIZE);
        UserBucketCreator userBucketCreator2 = new UserBucketCreator(2, TIME_WINDOW_IN_SECONDS,BUCKET_SIZE );
        ExecutorService executors = Executors.newFixedThreadPool(NO_OF_THREADS);
        ExecutorService executors2 = Executors.newFixedThreadPool(NO_OF_THREADS);

        for(int i=0;i<NO_OF_THREADS;i++){
            executors.execute(() -> userBucketCreator.accessApplication(1, answer));
            executors2.execute(() -> userBucketCreator2.accessApplication(2, answer));
            TimeUnit.SECONDS.sleep(SLEEP_TIME_IN_SECONDS);
        }
        executors.shutdown();
        executors2.shutdown();
    }
    public static void scheduler_function(Callable<Void> callable){
        try {
            callable.call();
        }
        catch (Exception e) {
            System.out.println("Logger for Exception...");
        }
    }
    public static void wrap(ArthmeticFunction arthmeticFunction) {
        scheduler_function(new Callable<Void>() {
            public Void call() throws Exception {
                Double answer = arthmeticFunction.call();
                function1(answer);
                return null;
            }
        });
    }
    public static void main(String[] args) {
        Square square = new Square(2.0);
        Cube cube = new Cube(3.0);
        System.out.println("Triggering function call wrapped around Rate Limiter to get Square of a number ");
        wrap(square);
        System.out.println("==============");
        System.out.println("Triggering function call wrapped around Rate Limiter to get Cube of a number ");
        wrap(cube);
    }
}
