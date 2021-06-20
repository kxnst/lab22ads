import FsmStates.*;

import java.util.Objects;

public class FSMT2 extends FSM{

    public FSMT2(){
        init();
    }
    @Override
    public void init(){
        State stateC = new StateCaret();
        State stateD1 = new StateDictionary1();
        State stateA = new StateAsterisk();
        State stateD2 = new StateDictionary2();
        StateGraph stateD1G = new StateGraph(stateD1);
        StateGraph stateD2G = new StateGraph(stateD2);
        StateGraph stateCG = new StateGraph(stateC);
        StateGraph stateAG = new StateGraph(stateA);
        stateCG.setNext(stateD1G).setNext(stateAG).setNext(stateD2G);
        stateD1G.setNext(stateCG);
        stateAG.setNext(stateCG);
        stateD2G.setNext(stateCG);
        root = stateCG;
    }
    public boolean exec(String str){
        StateGraph stateGraph = root;
        State state = stateGraph.getContainer();
        for(int i = 0; i < str.length(); i++){
            String symbol = Character.toString(str.charAt(i));
            if(!state.canExec()) {
                if(Objects.equals(stateGraph.peekNext(), null)) {
                    return false;
                } else {
                    stateGraph = stateGraph.getNext();
                    state = stateGraph.getContainer();
                }
            }
            boolean result = state.exec(symbol);
            state.executed();
            if (!result) {
                if (!checkFlag) {
                    return false;
                } else {
                    if( (i == str.length()-1) && !(Objects.equals(stateGraph.getNext(), null))) {
                        return true;
                    } else if(Objects.equals(stateGraph.peekNext(), null)){
                        return false;
                    } else {
                        checkFlag = false;
                        i--;
                        stateGraph = stateGraph.getNext();
                        state = stateGraph.getContainer();
                    }
                }
            } else {
                checkFlag = true;
            }
        }
        return true;
    }
}
