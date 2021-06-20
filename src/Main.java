import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        //task 1
        String regex1 = "\\^[A-Z]+\\^\\*\\^[A-Z]+\\^";
        String file1 = "src/task1.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(file1))) {
            String line;
            String mathches = "matches";
            String doesntMatch = "doesn`t match";
            Pattern pattern = Pattern.compile(regex1);
            System.out.println("Task 1");
            while ((line = reader.readLine()) != null) {
                String result;
                Matcher matcher = pattern.matcher(line);
                result = doesntMatch;
                if (matcher.matches()) {
                    result = mathches;
                }
                System.out.println(line + " - " + result);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        //task 2
        FSMT1 FSMT1 = new FSMT1();
        String file2 = "src/task2.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(file2))) {
            String line;
            String mathches = "matches";
            String doesntMatch = "doesn`t match";
            System.out.println("Task 2");

            while ((line = reader.readLine()) != null) {
                FSMT1.init();
                String result;
                result = doesntMatch;
                if (FSMT1.exec(line)) {
                    result = mathches;
                }
                System.out.println(line + " - " + result);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        //task 3
        FSMT2 FSMT2 = new FSMT2();
        String file3 = "src/task3.txt";
        String lineResult = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(file3))) {
            System.out.println("Task 3");
            String line;
            while ((line = reader.readLine()) != null) {
                lineResult += line;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        String [] needles = lineResult.split("[{}!]");
        for (String needle:
             needles) {
            FSMT2.init();
            String result;
            String mathches = "matches";
            String doesntMatch = "doesn`t match";
            result = doesntMatch;
            if (FSMT2.exec(needle)) {
                result = mathches;
            }
            System.out.println(needle + " - " + result);

        }
    }
}
