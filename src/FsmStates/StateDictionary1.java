package FsmStates;

public class StateDictionary1 extends State{

    protected Integer allowedCount = -1;

    public static String name = "SD1";

    @Override
    public boolean exec(String symbol) {
        return (symbol.compareTo("A") > -1) && (symbol.compareTo("Z") < 1);
    }
}
