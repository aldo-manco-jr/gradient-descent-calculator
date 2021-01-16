import java.util.List;

/**
 * Created by Aldo Manco on 1/16/2021.
 */
public class BestNeighborJudge {

    public State getBestNeighbor(boolean getMinimum, State startingState, List<State> neighborsStates, List<State> tabuStates) {

        neighborsStates.removeAll(tabuStates);

        if (neighborsStates.size() == 0) return startingState;

        State bestNeighborState = neighborsStates.get(0);

        for (int i = 1; i < neighborsStates.size(); i++) {

            if (getMinimum) {
                if (neighborsStates.get(i).getFunctionResult() < bestNeighborState.getFunctionResult()) {
                    bestNeighborState = neighborsStates.get(i);
                }
            } else {
                if (neighborsStates.get(i).getFunctionResult() > bestNeighborState.getFunctionResult()) {
                    bestNeighborState = neighborsStates.get(i);
                }
            }
        }

        System.out.println("X: " + bestNeighborState.getX() +
                "\nY: " + bestNeighborState.getY() +
                "\nBest Solution: " + bestNeighborState.getFunctionResult() + "\n");

        return bestNeighborState;
    }
}
