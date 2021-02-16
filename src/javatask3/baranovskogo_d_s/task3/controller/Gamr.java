package javatask3.baranovskogo_d_s.task3.controller;
import java.util.Arrays;
import javatask3.baranovskogo_d_s.task3.logic.Game;
import javatask3.baranovskogo_d_s.task3.view.Input;
import javatask3.baranovskogo_d_s.task3.view.Printer;

public class Gamr {

    public static void main(String[] args) {
        
        if ((args.length < 3)|| (args.length % 2 == 0) || (Arrays.stream(args).distinct().toArray(String[]::new).length != args.length) ){
            Printer.println("Incorrect input, you should write unique,odd number of moves, more then 1");
            Printer.println("Example: rock paper scissors");
            return;
        }
        
        String key = Game.generateKey();
        int computerMove = Game.generateComuterMove(args);
        String hmac = Game.getHMAC(key, args[computerMove]);
        Printer.println("HMAC:\n" + hmac.toUpperCase());
        
        int playerMove = -1;
        while (playerMove != 0){
            Printer.println("Available moves:");
            for (int i = 0; i < args.length; i++) {
                Printer.println((i + 1) + " - " + args[i]);
            }
            Printer.println("0 - exit");
            Printer.print("Enter your move: ");
            
            if(Input.hasNextInt() != true){
                continue;
            }          
            playerMove = Input.inputInt();
            
            if (playerMove == 0){
                break;
            }
            else if (playerMove <= args.length){
                playerMove--;
                Printer.print("Your move: " + args[playerMove] + "\n");    
                Printer.print("Computer move: " + args[computerMove] + "\n");

                int result = Game.getWinner(computerMove, args, playerMove);
                switch (result) {
                    case 1:
                        Printer.println("You win!");
                        break;
                    case 2:
                        Printer.println("Draw!");
                        break;
                    case 0:
                        Printer.println("You lose!");
                        break;
                }

                Printer.println("HMAC key: " + key);
                break;
            }
        }        
    }
}
