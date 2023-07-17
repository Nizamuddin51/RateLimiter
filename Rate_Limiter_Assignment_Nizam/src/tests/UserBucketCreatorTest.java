package tests;

import java.util.HashMap;
import java.util.Map;

import RateLimiter.SlidingWindow.SlidingWindow;
import RateLimiter.SlidingWindow.UserBucketCreator;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

public class UserBucketCreatorTest {
    @Test
    public void testAssert() {

        UserBucketCreator userBucketCreatorTest = new UserBucketCreator(1, 10, 2);
        assertNotNull(userBucketCreatorTest);

    }
    public String check(int bucketCapacity){
        if (bucketCapacity!=0)
            return "able to access the application";
        else
            return "Too many requests, Please try after some time";
    }
    @Test
    public void accessApplicationTest(){
        int id =1;
        Map<Integer, SlidingWindow> bucket = new HashMap<>();
        assertSame("able to access the application",check(1));
        assertSame("Too many requests, Please try after some time",check(0));
        }
    }











