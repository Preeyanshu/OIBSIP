import java.util.*;
import javax.swing.*;

import static java.lang.System.exit;

public class NumberGuessGame {
    static Scanner sc = new Scanner(System.in);
    static JFrame frame = new JFrame();

    static int genNum;
    static int score;
    static int count = 5;

    NumberGuessGame(){
        genNum = 0;
        score = 0;
    }

    public static void main(String[] args) {
        NumberGuessGame myFrame = new NumberGuessGame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        while(true){
            JOptionPane.showMessageDialog(frame,"Welcome to the Number Guessing Game\n" +
                    "Guess a number between 1 - 50\n" +
                    "!! You have only 5 tries !!");
            randomNum();
            myGame();
        }
    }

    private static void myGame() {
        int tries = 10;
        while(tries > count){
            String num = JOptionPane.showInputDialog(frame,"Guess a Number : ");
            int myNum = Integer.parseInt(num);

            if(myNum == genNum){
                JOptionPane.showMessageDialog(frame,"Congrats!! You won..\nYour score : " + tries*10);
                break;
            } else if (myNum > genNum) {
                JOptionPane.showMessageDialog(frame,"Too High!!");
            }
            else {
                JOptionPane.showMessageDialog(frame,"Too Low!!");
            }
            tries--;
        }

        if(tries == 5){
            JOptionPane.showMessageDialog(frame,"Alas!! You Lose..");
        }

        newGame();
    }

    private static void newGame() {
        String ans = JOptionPane.showInputDialog(frame,"1. Play again\n2. Quit");
        int ifPlay = Integer.parseInt(ans);
        switch (ifPlay){
            case 1:
                randomNum();
                myGame();
                break;
            case 2:
                JOptionPane.showMessageDialog(frame,"Good Bye ^_^");
                exit(0);
        }
    }

    private static void randomNum() {
        genNum = (int)((Math.random()*50)+1);
    }
}
