/*15.1.	Дан одномерный массив Xn. Найти количество элементов массива, больших, чем заданная величина Q.
15.2.Даны два одномерных массива Xn и Yn. Сформировать новый массив Zm, состоящий из положительных элементов с четными номерами массива Xn и отрицательных элементов с нечетными номерами массива Yn.*/


import java.util.Arrays;
import java.util.Scanner;

public class Lab1 {
    private static int n;
    private static double[] X;
    private static int m = 0;
    private static double[] Z = new double[m];
    private static int counter;
    private static final Scanner scan = new Scanner(System.in);
    private static boolean flag1;
    private static boolean flag2;

    public static void main(String[] args) {
        System.out.println("Количество элементов, больших Q - " + part1());
        for (int i = 0; i < m; i++) {
            System.out.println("Z[" + i + "] = " + part2());
        }
    }

    private static int part1(){
        System.out.print("n = ");
        n = scan.nextInt();
        System.out.print("Q = ");
        double q = scan.nextDouble();
        X = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.print("X[" + i + "]= ");
            X[i] = scan.nextDouble();
            if(X[i] > q) {
                counter++;
                flag1 = true;
            }
        }
        if(flag1) {
            return counter;
        } else {
            return 0;
        }
    }

    private static Object part2(){
        double[] y = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Y[" + i + "]= ");
            y[i] = scan.nextDouble();
            if((i % 2 == 0) && (X[i] > 0) && (X[i] != 0)){
                m++;
                Z = Arrays.copyOf(Z, m+1);
                Z[m] = X[i];
                flag2 = true;
            }
            if ((i % 2 == 1) && (y[i] < 0) && (y[i]) != 0) {
                m++;
                Z = Arrays.copyOf(Z, m+1);
                Z[m] = y[i];
                flag2 = true;
            }
        }
        if(flag2){
            System.out.println("Итоговый массив Z[m]:");
            for (int i = 0; i < m; i++) {
                return Z[i];
            }
        } else {
            return "Массив Z[m] остался пустым";
        }
        return null;
    }
}