import javax.swing.*;
import java.util.Locale;

public class Hangman {
    public static void main(String[] args) {
        String Kord = JOptionPane.showInputDialog(null, "Enter THE word");
        String hidden = "";
        int death = 0;
        int x = 0;
        String Guessed = "";
        String Guess = "";
        int correct = 0;
        int win = 0;
        for(int i = 0; i < Kord.length(); i++){
            hidden += '-';
        }
        System.out.println(hidden);
        while(x == 0){
            death++;
            if(death == 7){
                System.out.println("DEATH");
                x++;
                System.out.println(Kord);
            }
            else if(win == Kord.length()){
                System.out.println("you win poggers");
                x++;
            }
            else {
                Guess = JOptionPane.showInputDialog(null, "Your guess only one letter");
                for (int i = 0; i < Kord.length(); i++) {
                    if (Kord.toUpperCase(Locale.ROOT).charAt(i) == Guess.toUpperCase(Locale.ROOT).charAt(0)) {
                        hidden = hidden.substring(0, i) + Guess + hidden.substring(i + 1);
                        win++;
                        correct++;
                    }
                }
                if(correct > 0){
                    death -= 1;
                    correct = 0;
                }
            }
            Guessed = Guessed + " " + Guess;
            System.out.println("You have guessed: " + Guessed );
            System.out.println(hidden.toUpperCase());
        }
    }
}
