package Part2_1_4;

public class Calculator {
    public int add(int x, int y) {
        return x + y;
    }

    public double add(double x, double y) {
        return x + y;
    }

    public int add(int x, int y, int z) {
        return x + y + z;
    }
}
class AdvancedCalculator extends Calculator {
    public int add(int x, int y, int z, int w) {
        return x + y + z + w;
    }

    public double add(double x, double y, double z) {
        return x + y + z;
    }
}
class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        int sum1 = calculator.add(1, 2);
        double sum2 = calculator.add(2.5, 3.5);
        int sum3 = calculator.add(1, 2, 3);

        System.out.println("Sum1: " + sum1);
        System.out.println("Sum2: " + sum2);
        System.out.println("Sum3: " + sum3);

        AdvancedCalculator advancedCalculator = new AdvancedCalculator();

        int sum4 = advancedCalculator.add(1, 2, 3, 4);
        double sum5 = advancedCalculator.add(1.5, 2.5, 3.5);

        System.out.println("Sum4: " + sum4);
        System.out.println("Sum5: " + sum5);
    }
}
