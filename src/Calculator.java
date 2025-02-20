import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float a = sc.nextFloat();

        System.out.println(a);
        List<String> trigonometryOperators = Arrays.asList("sin", "cos", "tan", "ctg");
        List<String> mathOperators = Arrays.asList("+", "-", "/", "*", "^");

        String operator = sc.next();

        if (trigonometryOperators.contains(operator)) {
            CountTrigonometryValues(a, operator);
            return;
        }

        if (operator.equals("root")) {
            double result = Sqrt(a);
            System.out.printf("Root of %f is equal: %f", a, result);

            return;
        }

        if (!mathOperators.contains(operator)) {
            System.out.printf("Invalid operator. Use one of the following operators: %s or %s", Arrays.toString(trigonometryOperators.toArray()), Arrays.toString(mathOperators.toArray()));
            return;
        }

        float b = sc.nextFloat();

        if (mathOperators.contains(operator)) {
            HandleMathOperation(a, b, operator);
        }
    }

    public static void HandleMathOperation(float a, float b, String operator) {
        float result;

        switch (operator) {
            case "+":
                result = Sum(a, b);
                break;
            case "-":
                result = Subtract(a, b);
                break;
            case "*":
                result = Multiply(a, b);
                break;
            case "/":
                if (b == 0) return;
                result = Divide(a, b);
                break;
            case "^":
                result = (float) Power(a, b);
                break;
            default:
                System.out.print("Invalid operator");
                return;
        }

        System.out.printf("Result of %f %s %f is equal: ", a, operator, b);
        System.out.print(result);
    }

    public static void CountTrigonometryValues(float val, String operator) {
        float result;

        switch (operator) {
            case "sin":
                result = (float) Math.sin(val);

                break;
            case "cos":
                result = (float) Math.cos(val);

                break;
            case "tan":
                result = (float) Math.tan(val);
                break;
            case "ctg":
                result = 1 / (float) Math.tan(val);
                break;
            default:
                System.out.print("Invalid operator");
                break;
        }

        System.out.printf("%s(%f) is equal %f", operator.toUpperCase(), val, result);
    }

    static double Power(float a, float b) {
        return Math.pow(a, b);
    }

    static double Sqrt(double a) {
        return Math.sqrt(a);
    }

    static float Sum(float a, float b) {
        return a + b;
    }

    static float Multiply(float a, float b) {
        return a * b;
    }

    static float Divide(float a, float b) {
        return a / b;
    }

    static float Subtract(float a, float b) {
        return a - b;
    }
}
