import java.util.ArrayList;
import java.util.List;

/**
 * Created by unieuro on 1/16/2021.
 */
public class State {

    private double x; // x
    private double y; // y
    private double z; // f(x, y)
    private List<State> neighbors;

    public State(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.neighbors = new ArrayList<>();
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }
}
