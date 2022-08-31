import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Stack;

public class task1 {
    public static boolean isOperand(String str) {
        try {
            Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        try {
            List<String> Lines = Files.readAllLines(Paths.get("Calc1.stk"));
            Stack<Float> RPNStacker = new Stack<>();
            for (int i = 0; i < Lines.size(); i++) {
                String elem = Lines.get(i);
                if (isOperand(elem)) {
                    RPNStacker.add(Float.parseFloat(elem));
                }
                else {
		            Float a = RPNStacker.pop();
                    Float b = RPNStacker.pop();

                    if (elem.equals("+")) {
                        RPNStacker.add(b + a);
                    }
                    else if (elem.equals("-")) {
                        RPNStacker.add(b - a);
                    }
                    else if (elem.equals("/")) {
                        RPNStacker.add(b / a);
                    }
                    else if (elem.equals("*")) {
                        RPNStacker.add(b * a);
                    }
                }
                    
            }

            System.out.println("Dado:" + "'" + String.join(" ", Lines) + "' o resultado: " + RPNStacker.pop());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}