/**
 * Created by Aldo Manco on 1/16/2021.
 */
public class Main {

    public static void main(String[] args) {

        State[][] states = new State[Constants.NUMBER_VALUES][Constants.NUMBER_VALUES];

        int currentRow = 0;
        int currentColumn = 0;

        for (double x = Constants.MINIMUM_X; x < (Constants.MAXIMUM_X - Constants.QUANTUM_SIZE); x += Constants.QUANTUM_SIZE) {
            for (double y = Constants.MINIMUM_Y; y < (Constants.MAXIMUM_Y - Constants.QUANTUM_SIZE); y += Constants.QUANTUM_SIZE) {
                states[currentRow][currentColumn] = new State(x, y, CostFunction.f(x, y));
                currentColumn++;
            }
            currentColumn = 0;
            currentRow++;
        }

        for (int i = 0; i < Constants.NUMBER_VALUES; i++) {
            states[i][0].addNeighbor(states[i][1]);
        }

        for (int i = 0; i < Constants.NUMBER_VALUES; i++) {
            states[i][Constants.NUMBER_VALUES - 1].addNeighbor(states[i][Constants.NUMBER_VALUES - 2]);
        }

        for (int i = 0; i < Constants.NUMBER_VALUES; i++) {
            states[0][i].addNeighbor(states[1][i]);
        }

        for (int i = 0; i < Constants.NUMBER_VALUES; i++) {
            states[Constants.NUMBER_VALUES - 1][i].addNeighbor(states[Constants.NUMBER_VALUES - 2][i]);
        }

        for (int i = 1; i < Constants.NUMBER_VALUES - 1; i++) {
            for (int j = 1; j < Constants.NUMBER_VALUES - 1; j++) {
                states[i][j].addNeighbor(states[i - 1][j]);
                states[i][j].addNeighbor(states[i + 1][j]);
                states[i][j].addNeighbor(states[i][j - 1]);
                states[i][j].addNeighbor(states[i][j + 1]);
            }
        }

        TabuSearch gradientDescentCalculator = new TabuSearch(states);

        State startingState = states[Constants.NUMBER_VALUES / 2][Constants.NUMBER_VALUES / 2];

        State minimumState = gradientDescentCalculator.solve(true, startingState);
        State maximumState = gradientDescentCalculator.solve(false, startingState);

        System.out.println("-------------------------------");

        System.out.println("\nGradient Descent of f(x, y)");
        System.out.println("X: " + minimumState.getX() +
                "\nY: " + minimumState.getY() +
                "\nGlobal Minima: " + minimumState.getFunctionResult());

        System.out.println("\nGradient Ascent of f(x, y)");
        System.out.println("X: " + maximumState.getX() +
                "\nY: " + maximumState.getY() +
                "\nGlobal Maxima: " + maximumState.getFunctionResult());
    }
}
