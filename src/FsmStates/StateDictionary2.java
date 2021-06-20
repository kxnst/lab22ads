package FsmStates;

public class StateDictionary2 extends State{

    protected Integer allowedCount = -1;

    public static String name = "SD2";

    @Override
    public boolean exec(String symbol) {
        try {
            Integer.parseInt(symbol);
            return false;
        } catch (Exception e) {}
        return !symbol.equals("A") && !symbol.equals("Z");
    }
}
