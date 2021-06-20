import FsmStates.State;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class StateGraph {
    private ArrayDeque<StateGraph> next;
    private State container;

    public StateGraph getNext() {
        return next.pop();
    }
    public StateGraph peekNext() {
        return next.peek();
    }

    public State getContainer() {
        return container;
    }
    public StateGraph setNext(StateGraph graph){
        next.add(graph);
        return this;
    }
    public StateGraph(State state){
        next = new ArrayDeque<>();
        container = state;
    }
}

