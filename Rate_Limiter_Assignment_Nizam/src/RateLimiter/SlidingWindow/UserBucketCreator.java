package RateLimiter.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class UserBucketCreator {
    Map<Integer, SlidingWindow> bucket;

    public UserBucketCreator(int id, int timeWindowInSeconds, int bucketCapacity) {
        bucket = new HashMap<>();
        bucket.put(id, new SlidingWindow(timeWindowInSeconds,bucketCapacity));
    }

    void accessApplication(int id, Double answer){
        if(bucket.get(id).grantAccess()){
            System.out.println(Thread.currentThread().getName() + " -> able to access the application " + "and the output is: " + answer);
        }else{
            System.out.println(Thread.currentThread().getName() + " -> Too many requests, Please try after some time");
        }
    }
}
