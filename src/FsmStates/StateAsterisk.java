package FsmStates;

public class StateAsterisk extends State{
    public static String name = "SA";

    protected Integer allowedCount = 1;

    @Override
    public boolean exec(String symbol) {
        return symbol.equals("*");
    }
}
