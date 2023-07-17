package RateLimiter.SlidingWindow;

import static java.lang.Math.pow;

public class Cube implements ArthmeticFunction{

    private Double num;

    public Double getNum() {
        return num;
    }

    public void setNum(Double num) {
        this.num = num;
    }

    @Override
    public Double call(){
        Double value= pow(this.num,3);
        return value;
    }

    public Cube(double num) {
        this.num = num;
    }
}
