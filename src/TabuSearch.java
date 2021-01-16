import java.util.List;

/**
 * Created by unieuro on 1/16/2021.
 */
public class TabuSearch {

    private State[][] states;
    private TabuList tabuList;
    private BestNeighborJudge bestNeighborJudge;

    public TabuSearch(State[][] states) {
        this.states = states;
        this.tabuList = new TabuList();
        this.bestNeighborJudge = new BestNeighborJudge();
    }

    public State solve(State startingState){

        State bestState = startingState;
        State currentState = startingState;

        int iterationCounter = 0;

        while (iterationCounter<Constants.NUMBER_ITERATIONS){

            List<State> neighborsStates = currentState.getNeighbors();
            List<State> tabuStates = tabuList.getTabuItems();

            State bestValidNeighborFound = bestNeighborJudge.getBestNeighbor(states, neighborsStates, tabuStates);

            if (bestValidNeighborFound.getFunctionResult()<bestState.getFunctionResult()){
                bestState = bestValidNeighborFound;
            }

            tabuList.add(currentState);

            currentState = bestValidNeighborFound;

            iterationCounter++;
        }

        return bestState;
    }
}
