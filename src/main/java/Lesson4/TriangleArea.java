package Lesson4;


public class TriangleArea {

    public static Double areaBySides(double a, double b, double c) {
        if ((a + b) <= c ||
                (a + c) <= b ||
                (b + c) <= a) {
            System.out.println("Такого треугольника не существует");
            return null;
        }
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p-a) * (p-b) * (p-c));
    }
}
