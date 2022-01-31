import javax.swing.*;
import java.util.Locale;

public class HangmanButMethod {
    public static void main(String[] args) {
        String RW = Cord("");
        String CW = hidden(RW);
        System.out.println(CW);
        System.out.println(play(RW,CW));


    }
    static String Cord(String x){
        String Kord = JOptionPane.showInputDialog(null, "Enter THE word");
        return Kord;
    }
    static String hidden(String x){
        String hidden = "";
        for(int i = 0; i < x.length(); i++){
            hidden += '_';
        }
        return hidden;
    }
    static String play(String x, String y){
        int win = 0;
        int correct = 0;
        for(int i = 0; i < 10; i++){
            String L = Guess();
            for (int c = 0; c < x.length(); c++) {
                if (x.toUpperCase(Locale.ROOT).charAt(c) == L.toUpperCase(Locale.ROOT).charAt(0)) {
                    y = y.substring(0, c) + L + y.substring(c + 1);
                    correct++;
                }

                if (y.toUpperCase(Locale.ROOT) == x.toUpperCase(Locale.ROOT)) {
                    i += 10000;
                    System.out.println(y);
                    return "Win";

                }
            }
            if(correct == 0){
                correct = 0;
                i--;

            }
                System.out.println(y);


        }
        return "Death";

    }
    static String Guess(){
        String Guess = JOptionPane.showInputDialog(null, "Your guess only one letter");
        return Guess;
    }
}
