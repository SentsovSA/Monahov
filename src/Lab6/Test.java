package Lab6;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> System.out.println(1));
        Thread t = new Thread(t1);
        t.start();
    }
}
