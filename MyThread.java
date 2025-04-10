package threadexample;

import java.util.Scanner;

public class MyThread {
    static String name;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter name: ");
        name = scan.nextLine();
        MyRunnable numberPrinter = new MyRunnable();
        Thread thread1 = new Thread(numberPrinter, "NumberPrinter");
        thread1.setPriority(Thread.MIN_PRIORITY);

        ThreadClassPro nameReverser = new ThreadClassPro(name);
        nameReverser.setPriority(Thread.MAX_PRIORITY);  // highest priority (10)

        thread1.start();
        nameReverser.start();
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Printing numbers from 1 to 10:");
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Number printer interrupted");
            }
        }
    }
}

class ThreadClassPro extends Thread {
    String name;
    ThreadClassPro(String name){
        this.name = name;
    }
    @Override
    public void run() {

        System.out.println("Entered name is: " + name);
        System.out.print("Reverse of " + name + " is: ");
        for (int i = name.length() - 1; i >= 0; i--) {
            System.out.print(name.charAt(i));

        }
        System.out.println();
    }
}