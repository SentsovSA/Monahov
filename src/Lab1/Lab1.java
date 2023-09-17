package Lab1;/*15	Вычислить длину диагонали прямоугольника.
15.1.	Дан одномерный массив Xn. Найти количество элементов массива, больших, чем заданная величина Q.
15.2.Даны два одномерных массива Xn и Yn. Сформировать новый массив Zm, состоящий из положительных элементов с четными номерами массива Xn и отрицательных элементов с нечетными номерами массива Yn.*/


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lab1 {
    private static int n;
    private static int m = 0;
    private static int counter;
    private static final Scanner scan = new Scanner(System.in);
    private static boolean flag1;
    private static boolean flag2;
    private static final Random r = new Random();

    public static void main(String[] args) {
        part1();
        System.out.print("n = ");
        n = scan.nextInt();
        System.out.print("Q = ");
        double q;
        q = scan.nextDouble();
        double[] X = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.print("X[" + i + "]= ");
            X[i] = scan.nextDouble();
        }
        scan.close();
        System.out.println("Количество элементов, больших Q - " + part2(q, X));
        double[] Z = new double[m];
        Z = (Z instanceof double[]) ? (double[])part3(X, Z) : null;
        if(Z != null) {
            for (int i = 0; i < m; i++) {
                System.out.printf("Z(%d)=%1.2f\n", i, Z[i]);
            }
        } else System.out.println("Массив Z[m] остался пустым");
    }

    private static void part1(){
        int a = r.nextInt(100);
        System.out.println("a = " + a);
        int b = r.nextInt(100);
        System.out.println("b = " + b);
        System.out.println("Длина диагонали:" + Math.sqrt(Math.pow(a,2)+Math.pow(b,2)));
    }

    private static int part2(double q, double[] X) {
        for (int i = 0; i < n; i++) {
            if (X[i] > q) {
                counter++;
                flag1 = true;
            }
        }
        if (flag1) {
            return counter;
        } else {
            return 0;
        }
    }

    private static Object part3(double[] X, double[] Z) {
        double[] y = r.doubles(-100, 100).limit(n).toArray();
        for (int i = 0; i < n; i++) {
            System.out.printf("Y(%d)=%1.2f\n", i, y[i]);
            if ((i % 2 == 0) && (X[i] > 0) && (X[i] != 0)) {
                m++;
                Z = Arrays.copyOf(Z, m + 1);
                Z[m] = X[i];
                flag2 = true;
            }
            if ((i % 2 == 1) && (y[i] < 0) && (y[i]) != 0) {
                m++;
                Z = Arrays.copyOf(Z, m + 1);
                Z[m] = y[i];
                flag2 = true;
            }
        }
        if (flag2) {
            System.out.println("Итоговый массив Z[m]:");
            return Z;
        }
        return null;
    }
}