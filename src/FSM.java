import FsmStates.State;

import java.util.ArrayDeque;

public abstract class FSM {
    protected boolean checkFlag = false;
    protected StateGraph root;
    public abstract void init();
    public abstract boolean exec(String str);
}
