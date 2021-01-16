import java.util.List;

/**
 * Created by unieuro on 1/16/2021.
 */
public class BestNeighborJudge {

    public State getBestNeighbor(State[][] states, List<State> neighborsStates, List<State> tabuStates){

        neighborsStates.removeAll(tabuStates);

        if (neighborsStates.size()==0) return states[100][100];

        State bestNeighborState  = neighborsStates.get(0);

        for (int i = 1; i < neighborsStates.size(); i++) {

            if (neighborsStates.get(i).getFunctionResult() < bestNeighborState.getFunctionResult()){
                bestNeighborState = neighborsStates.get(i);
            }
        }

        System.out.println("Best Solution: " + bestNeighborState);

        return bestNeighborState;
    }
}
