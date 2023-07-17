package RateLimiter.SlidingWindow;

import static java.lang.Math.pow;

public class Square implements ArthmeticFunction{

    public Double getNum() {
        return num;
    }
    public void setNum(Double num) {
        this.num = num;
    }
    private Double num;
    public Square(double num) {
        this.num = num;
    }

    @Override
    public Double call(){
        Double value=pow(this.num,2);
        return value;
    }
}
