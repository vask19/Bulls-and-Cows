package bullscows.core.grader;

import java.util.*;
import java.util.stream.Collectors;

public class Grader {
    private static Scanner scanner = new Scanner(System.in);
    private List<Character> secretCodeForCheck;
    private String secretCode;
    private  List<Character> guessAnswer;
    private int cowsCount;
    private int bullsCount;
    private List<Character> bulls;
    private List<Character> cows;
    private Character lastRangeCharacter;

    public Grader(String secretCode,Character lastRangeCharacter){
        this.lastRangeCharacter = lastRangeCharacter;
        this.secretCodeForCheck = secretCode
                .chars()
                .mapToObj(c -> (char)c)
                .collect(Collectors.toList());
        this.secretCode = secretCode;
        this.bulls = new ArrayList<>();
        this.cows = new ArrayList<>();
        this.guessAnswer = new ArrayList<>();
       }

    public  Grader() {
    }


    public void setGuessAnswer(String guessAnswer) {
        this.guessAnswer = guessAnswer
                .chars()
                .mapToObj(c -> (char)c)
                .collect(Collectors.toList());
    }
    public void findBullsAndCows(){
        bullsCount = 0;
        cowsCount = 0;
        for (int i =0;i<secretCodeForCheck.size();i++){
        if (secretCodeForCheck.get(i).equals(guessAnswer.get(i))) bullsCount++;
        if (!bulls.contains(guessAnswer.get(i))) {
            if (secretCodeForCheck.contains(guessAnswer.get(i))){
                cowsCount++;
                bulls.add(guessAnswer.get(i));
            }
        }
    }
    }
    public void print(){
        if (cowsCount == 0 & bullsCount ==0) System.out.println("Grade: None. ");
        else if (bullsCount ==secretCode.length()) System.out.printf("Grade: %d bulls\n",secretCode.length());
        else if (bullsCount == 0) System.out.printf("Grade: %d cow(s).\n",cowsCount);
        else if (cowsCount == 0) System.out.printf("Grade: %d cow(s).\n",bullsCount);
        else System.out.printf("Grade: %d bull(s) and %d cow(s)\n",bullsCount,cowsCount);
    }
    public int getBullsCount(){
        return bullsCount;
    }

    public void printRange(int range){
        StringBuilder x = new StringBuilder("The secret is prepared: ");
        for (int i =0;i<secretCode.length();i++)
            x.append("*");
        if (range <=10) x.append(" (0-"+(range-1) + ").");
        else x.append(" (0-9,a-"+ (lastRangeCharacter) + ").");
        System.out.println(x);

    }

}
