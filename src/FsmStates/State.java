package FsmStates;

import java.util.ArrayList;

public abstract class State {
    public static String name;
    public abstract boolean exec(String symbol);
    protected Integer allowedCount = -1;
    protected Integer currentCount = 0;
    public boolean canExec() {
        return (allowedCount == -1)  || (allowedCount > currentCount);
    }
    public void executed(){
        currentCount++;
    }
}
