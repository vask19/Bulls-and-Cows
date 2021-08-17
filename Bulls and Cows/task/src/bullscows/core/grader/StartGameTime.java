package bullscows.core.grader;

import java.util.Scanner;

public class StartGameTime {
    private int  secretCodeLength;
    private int secretCodeRange;
    private static Scanner scanner = new Scanner(System.in);
    private SecretCodeGenerator secretCodeGenerator;
    private String secretCode;


    public StartGameTime() {
        this.secretCodeLength = 0;
        this.secretCodeRange = 0;

        this.secretCode = null;
        this.secretCodeGenerator = new SecretCodeGenerator();
    }

    public void start(){
        Grader grader;
        int turn = 1;
        System.out.println("Input the length of the secret code:");
        String guess = scanner.nextLine();
        if (!secretCodeLengthValidator(guess))
            return;


        System.out.println("Input the number of possible symbols in the code:");
        secretCodeRange = scanner.nextInt();
        if (!secretCodeRangeValidator(secretCodeRange))
            return;

        secretCode = secretCodeGenerator.getSecretCode(secretCodeLength,secretCodeRange);
        grader = new Grader(secretCode,secretCodeGenerator.getLastRangeCharacter(secretCodeRange-1));
        System.out.println("Okay, let's start a game!");
        grader.printRange(secretCodeRange);

        do {
            System.out.printf("Turn %d:\n",turn++);
            String x = scanner.next();
            grader.setGuessAnswer(x);
            grader.findBullsAndCows();
            grader.print();
        }while (grader.getBullsCount() < secretCodeLength);
        System.out.println("Congratulations! You guessed the secret code.");


    }
    private boolean secretCodeLengthValidator(String guess){
        if (!guess.matches("\\d*")){
            System.out.printf("Error: \"%s\" isn't a valid number.\n",guess);
            return false;
        }
        else secretCodeLength = Integer.parseInt(guess);


        if (secretCodeLength <1){
            System.out.println("Error: zero");
           return false;
        }
        return true;

    }
    private boolean secretCodeRangeValidator(int secretCodeRange){
        if (secretCodeLength > secretCodeRange){
            System.out.printf("Error: it's not possible to generate a code with a length of %d with %d unique symbols.",secretCodeLength,secretCodeRange);
            return false;
        }
        if (secretCodeRange > 36){
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            return false;
        }

        return true;


    }

}
