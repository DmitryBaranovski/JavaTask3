package javatask3.baranovskogo_d_s.task3.logic;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Arrays;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;

public class Game {
    
    private static SecureRandom random = new SecureRandom();
            
    public static String generateKey() {       
        byte[] bytes = new byte[16];  
        random.nextBytes(bytes);
        return String.format("%032X", new BigInteger(1, bytes));
    }
    
    public static String getHMAC(String key, String message) {       
        HmacUtils hm256 = new HmacUtils(HmacAlgorithms.HMAC_SHA_256, key);
        return hm256.hmacHex(message);
    }
    
    public static int generateComuterMove(String args[]) {       
        return (int)(Math.random()*args.length); 
    }
    
    public static int getWinner(int computerMove, String args[], int playerMove) {   
        int result = 0;
        String[] winners = new String[args.length/2];     
        int win = computerMove + 1;
        for (int i = 0; i < args.length/2; i++) {
            if (win == args.length){
                win = 0;
            };
        winners[i] = args[win];
        win++; 
        }
        if (Arrays.asList(winners).contains(args[playerMove])){
            return 1;
            } else if (computerMove == playerMove){
                return 2;
        } else {return 0;}  
    }
}
