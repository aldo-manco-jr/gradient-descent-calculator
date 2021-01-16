import org.apache.commons.collections4.IteratorUtils;
import org.apache.commons.collections4.queue.CircularFifoQueue;

import java.util.List;
import java.util.Queue;

/**
 * Created by Aldo Manco on 1/16/2021.
 */
public class TabuList {

    private Queue<State> tabuList;

    public TabuList() {
        this.tabuList = new CircularFifoQueue<>(Constants.TABU_TENURE);
    }

    public void add(State justVisitedState) {
        this.tabuList.add(justVisitedState);
    }

    public boolean contains(State state) {
        return this.tabuList.contains(state);
    }

    public List<State> getTabuItems() {
        return IteratorUtils.toList(this.tabuList.iterator());
    }
}
