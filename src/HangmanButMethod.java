import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.util.Locale;
import java.util.Random;

public class HangmanButMethod {
    public static void main(String[] args) {
        menu();
    }

















    static void menu(){
        String choi = JOptionPane.showInputDialog(null, "What do you want to do?\n 1: Choose a word and play hangman. \n2: Choose a random word and play hangman. \n3: quit the game. \n Please enter 1-3 depending on what you want to do");
        int chois = Integer.parseInt(choi);
        if(chois == 1){
            String RW = Cord("");
            String CW = hidden(RW);
            System.out.println(CW);
            JOptionPane.showMessageDialog(null, play(RW,CW));
            playg();
        }
        else if(chois == 2){
            String RW = ordList("");
            String CW = hidden(RW);
            System.out.println(CW);
            System.out.println(play(RW,CW));
            playg();
        }
        else{
            System.exit(0);
        }
    }
    static String ordList(String x){
        String[] word = {"Hej", "På", "Dig", "Varför", "Gör", "Jag", "Detta"};
        Random rand = new Random();
        return word[rand.nextInt((6) + 1)];

    }
    static void run() {

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
            hidden += '-';
        }
        return hidden;
    }
    static String play(String x, String y){
        int win = 0;
        String PG = "";
        int correct = 0;

        for(int i = 0; i < 10; i++){
            System.out.println("You have guessed: " + PG);
            String L = Guess(y, PG, i);
            PG = PG + " " + L;
            for (int c = 0; c < x.length(); c++) {
                if (x.toUpperCase(Locale.ROOT).charAt(c) == L.toUpperCase(Locale.ROOT).charAt(0)) {
                    y = y.substring(0, c) + L + y.substring(c + 1);
                    correct++;
                }

                if (y.toUpperCase(Locale.ROOT).equals(x.toUpperCase(Locale.ROOT))) {
                    i += 10000;

                    return "Win";

                }
            }


            if(correct != 0){
                correct = 0;
                i--;

            }



        }
        return "Death";

    }
    static String Guess( String x, String pg, int pgg){
        int Aog = 10-pgg;
        String Guess = JOptionPane.showInputDialog(null, "Your guess only one letter\n" + x + "\n You have already guessed: " + pg + " \n You have " + Aog + " guesses left");
        return Guess;
    }
    static void playg(){
        String yes = JOptionPane.showInputDialog(null, "Do you want to play again Y/N?");
        if(yes.toUpperCase(Locale.ROOT).equals("Y")){
            menu();
        }
        else if(yes.toUpperCase(Locale.ROOT).equals("N")){
            System.exit(0);
        }

    }
}
