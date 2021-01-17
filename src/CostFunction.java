import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * Created by Aldo Manco on 1/16/2021.
 */
public class CostFunction {

    public static double f(double x, double y) {

        /*ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        String foo = "Math.exp(-" + x + " * " + x + " - " + y + " * " + y + ")";

        try {
            System.out.println(engine.eval(foo));
        } catch (Exception ignored) {
        }*/

        return Math.exp(-x * x - y * y) * Math.sin(x);
    }
}
