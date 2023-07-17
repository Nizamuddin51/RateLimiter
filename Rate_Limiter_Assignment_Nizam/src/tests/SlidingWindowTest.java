package tests;

import org.junit.Test;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SlidingWindowTest {
    private void checkAndUpdateQueue(Queue<Long> slidingWindow, long currentTime) {
        if(slidingWindow.isEmpty()) return;

        long calculatedTime = (currentTime - slidingWindow.peek())/1000;
        while(calculatedTime >= 10){
            slidingWindow.poll();
            if(slidingWindow.isEmpty()) break;
            calculatedTime = (currentTime - slidingWindow.peek())/1000;
        }
    }
    public boolean createQueue(Queue<Long> slidingWindow, Long currentTime) {
        checkAndUpdateQueue(slidingWindow, currentTime);
        if(slidingWindow.size() < 2){
                slidingWindow.offer(currentTime);
                return true;
            }
        return false;
    }

    @Test
    public void testHasAccess(){
        Queue<Long> slidingWindow= new ConcurrentLinkedQueue<>();
        long currentTime = System.currentTimeMillis();
        slidingWindow.offer(currentTime - 10);
        boolean access= createQueue(slidingWindow, currentTime);
        assertTrue(access);
    }

    @Test
    public void testNoAccess() {
        Queue<Long> slidingWindow = new ConcurrentLinkedQueue<>();
        long currentTime = System.currentTimeMillis();
        slidingWindow.offer(currentTime - 10);
        slidingWindow.offer(currentTime - 11);
        slidingWindow.offer(currentTime - 12);
        slidingWindow.offer(currentTime - 13);
        boolean access = createQueue(slidingWindow, 100000L);
        assertFalse(access);
    }
}