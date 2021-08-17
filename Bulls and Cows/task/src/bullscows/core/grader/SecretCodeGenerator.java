package bullscows.core.grader;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class SecretCodeGenerator {
    private final List<Character> fullList = new ArrayList<>(List.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a',
            'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't','u','v','w','x','y','z'));
    private  Random random = new Random();
    private List<Character> secretCodeG;

    public SecretCodeGenerator() {

        this.secretCodeG = new ArrayList<>();
    }


    private String  create(int secretCodeLength,int secretCodeRange){
        StringBuilder sb = new StringBuilder();
        while(secretCodeG.size() != secretCodeLength){
            int randomNumber = random.nextInt(secretCodeRange);
            if (!secretCodeG.contains(fullList.get(randomNumber))){
                secretCodeG.add(fullList.get(randomNumber));

                sb.append(fullList.get(randomNumber));
                }

        }
        return sb.toString();

    }
    public String getSecretCode(int secretCodeLength,int secretCodeRange){
       return create(secretCodeLength,secretCodeRange);

    }

    public Character getLastRangeCharacter(int range){
        return fullList.get(range);
    }

}
