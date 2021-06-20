package FsmStates;

public class StateCaret extends State{
    public static String name = "SC";

    protected Integer allowedCount = 1;

    @Override
    public boolean exec(String symbol) {
        allowedCount = 1;
        return symbol.equals("^");
    }
}
