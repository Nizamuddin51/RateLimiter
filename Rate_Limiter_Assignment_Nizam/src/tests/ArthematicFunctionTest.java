package tests;

import RateLimiter.SlidingWindow.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArthematicFunctionTest {

        @Test
        public void testAssert() {
        ArthmeticFunction arthmeticFunction1 = new Square(5);
        ArthmeticFunction arthmeticFunction2 = new Cube(4);
        Double square_value = arthmeticFunction1.call();
        Double cube_value =  arthmeticFunction2.call();
        assertEquals(square_value, new Double(25));
        assertEquals(cube_value, new Double(64));
        }
    }












