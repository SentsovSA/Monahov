package Lab6;

public class Test {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
            }
        });
        Thread t = new Thread(t1);
        t.start();
    }
}
