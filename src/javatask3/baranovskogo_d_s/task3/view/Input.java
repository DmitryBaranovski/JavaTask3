package javatask3.baranovskogo_d_s.task3.view;

import java.util.Scanner;

public class Input {
    
    private static Scanner scanner = new Scanner(System.in);

    public static int inputInt() {
        return scanner.nextInt();
    }
    
    public static boolean hasNextInt() {
        return scanner.hasNextInt();
    }
}


