import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float a,b,c;
        Print("Quadratic function equation: f(x) = ax^2+bx+c\n");
        Print("Enter 'a' of quadratic function (a)x^2: ");
        a = sc.nextFloat();
        Print("Enter 'b' of quadratic function (b)x: ");
        b = sc.nextFloat();
        Print("Enter 'c' of quadratic function: ");
        c = sc.nextFloat();

       if (a == 0) {
            if(c != 0) {
                System.out.printf("It's not quadratic function, but has one root equals: %f", (-c / b));

                return;
            }

            Print("It's not quadratic function so can't find roots! ");
            return;
       }

       float delta = CountDelta(a,b,c);

       if(delta < 0) {
           Print("Delta is negative! There is no root of quadratic function");
           return;
       }

        CountRoots(delta,a,b);
    }

    public static void Print(String args) {
        System.out.print(args);
    }


    public static float CountDelta(float a, float b, float c) {
        return b*b - 4*a*c;
    }

    public static void CountRoots(float delta, float a, float b) {
        double x1,x2;

        if(delta == 0) {
            x1 = -b/2*a;
            System.out.printf("Quadratic function has one root equal to %f", x1);

            return;
        }

        double sqrtOfDelta =  Math.sqrt(delta);

        x1 = (-b - sqrtOfDelta) / (2 * a);
        x2 = (-b + sqrtOfDelta) / (2 * a);

        System.out.printf("Quadratic function has two roots equal x1: %f and x2: %f", x1, x2);
    }
}
