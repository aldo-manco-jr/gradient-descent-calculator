/**
 * Created by unieuro on 1/16/2021.
 */
public class CostFunction {

    public static double f(double x, double y){
        return Math.exp(-x*x-y*y)*Math.sin(x);
    }
}
