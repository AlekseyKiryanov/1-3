package vsu.iryanovao.task0103;


import java.util.Scanner;

public class Main {

    public static final Line L1 = new Line(-3, 2, 0.25);
    public static final VerticalParabola VP1 = new VerticalParabola(3, 0, 0.125);
    public static final VerticalParabola VP2 = new VerticalParabola(6, 4, 0.25);
    public static final VerticalParabola VP3 = new VerticalParabola(0, 0, -0.25);
    public static final HorizontalParabola HP1 = new HorizontalParabola(2, -3, -1);

    public static SimpleColor getColor(double x, double y) {
        if (HP1.isPointRightOfParabola(x, y) && VP3.isPointUpOfParabola(x, y) && x < -5 && y < -5) {
            return SimpleColor.BLUE;
        } else if (!HP1.isPointRightOfParabola(x, y) && !VP3.isPointUpOfParabola(x, y)) {
            return SimpleColor.YELLOW;
        } else if (HP1.isPointRightOfParabola(x, y) && !VP3.isPointUpOfParabola(x, y)) {
            return SimpleColor.BLUE;
        } else if (L1.isPointUpOfLine(x, y) && !VP1.isPointUpOfParabola(x, y) && HP1.isPointRightOfParabola(x, y) && (x < 3)) {
            return SimpleColor.GREEN;
        } else if (!L1.isPointUpOfLine(x, y) && VP1.isPointUpOfParabola(x, y) && !VP2.isPointUpOfParabola(x, y)) {
            return SimpleColor.WHITE;
        } else if (L1.isPointUpOfLine(x, y) && VP2.isPointUpOfParabola(x, y)) {
            return SimpleColor.WHITE;
        } else if (L1.isPointUpOfLine(x, y) && !VP2.isPointUpOfParabola(x, y) && VP1.isPointUpOfParabola(x, y) && x > 6) {
            return SimpleColor.WHITE;
        } else if (!L1.isPointUpOfLine(x, y) && VP2.isPointUpOfParabola(x, y)) {
            return SimpleColor.YELLOW;
        } else if (L1.isPointUpOfLine(x, y) && !VP1.isPointUpOfParabola(x, y) && (x > 3)) {
            return SimpleColor.BLUE;
        } else if (L1.isPointUpOfLine(x, y) && !VP2.isPointUpOfParabola(x, y) && VP1.isPointUpOfParabola(x, y) && x < 6) {
            return SimpleColor.BLUE;
        } else if (!HP1.isPointRightOfParabola(x, y) && VP3.isPointUpOfParabola(x, y)) {
            return SimpleColor.GRAY;
        } else if (!L1.isPointUpOfLine(x, y) && VP3.isPointUpOfParabola(x, y) && !VP1.isPointUpOfParabola(x, y)) {
            return SimpleColor.GRAY;
        }


        return SimpleColor.BLACK;
    }

    public static void main(String[] args) {
        startPrint();
        while (true) {
            double x = readDoubleValueFromConsole("x");
            double y = readDoubleValueFromConsole("y");
            System.out.printf("(%+.2f; %+.2f) -> %s\n", x, y, getColor(x, y));
        }
    }

    public static void startPrint() {
        double[] x = {-6.00, +1.00, -1.00, -6.00, +4.00, +3.00, +9.00, +6.00, +9.90, -2.00, -5.00, -2.00};
        double[] y = {-6.00, -1.00, -4.00, +3.00, +2.00, +7.00, +6.00, +4.10, +5.50, +6.00, -3.00, +1.00};
        for (int i = 0; i < 12; i++) {
            System.out.printf("(%+.2f; %+.2f) -> %s\n", x[i], y[i], getColor(x[i], y[i]));
        }
    }


    public static double readDoubleValueFromConsole(String varName) {
        Scanner scanner = new Scanner(System.in);
        double a = 0;
        while (true) {
            System.out.printf("Введите действительное число %s = ", varName);
            try {
                String line = scanner.nextLine();
                if (line.equals("q") || line.equals("/q") || line.equals("exit") || line.equals("stop") || line.equals("выход") || line.equals("стоп") || line.equals("х")) {
                    System.exit(0);
                }
                a = Double.parseDouble(line);
                return a;
            } catch (Exception e) {
                System.out.println("Введено не число.");
            }
        }
    }
}
