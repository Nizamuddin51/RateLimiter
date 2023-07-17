package RateLimiter.SlidingWindow;

public class Constants {
//    Denotes the size of Window frame in seconds.
    static final int TIME_WINDOW_IN_SECONDS = 10;

//    Denotes the maximum number of calls allowed in the given window frame.
    static final int BUCKET_SIZE = 2;

//    Represents the number of process calls for each function.
    static final int NO_OF_THREADS = 3;

//    Introduces the time delay in between process calls.
    static final int SLEEP_TIME_IN_SECONDS= 3;
}
