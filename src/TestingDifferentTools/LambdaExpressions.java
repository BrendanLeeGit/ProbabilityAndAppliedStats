package TestingDifferentTools;

public class LambdaExpressions {
    public static void main(String[] args){
        Car c = (String x) -> System.out.println(x + x);
        c.driveCar("Hello");
    }
}
