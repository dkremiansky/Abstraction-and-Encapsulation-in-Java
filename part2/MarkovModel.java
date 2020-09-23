package part2;

import java.util.ArrayList;
import java.util.Random;

/**
 * MarkovModel
 * runs the MarkovModel algorithms
 */
public class MarkovModel  extends AbstractMarkovModel {

    /**
     * constructor
     * implement the constructor of the abstract class with the specific markov number
     */
    public MarkovModel(int n) {
        super(n);
    }

    /**
     * recives the number of chars that we want to grill out of myText
     * and creates new text
     * @param numChars - the number of chars we want to grill
     * @return the new text that we grill from myText
     */
    public String getRandomText(int numChars)
    {
        if (myText == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int randomIndex = myRandom.nextInt(myText.length() - myNum);
        String randomLetter = myText.substring(randomIndex, randomIndex + myNum);
        sb.append(randomLetter);
        for (int k = 0; k < numChars - myNum; k++) {
            ArrayList<String> letters = getFollows(randomLetter);
            if (letters.size() == 0)
                break;
            randomIndex = myRandom.nextInt(letters.size());
            String ourTab = letters.get(randomIndex);
            sb.append(ourTab);
            //updated the random letter by adding a new letter to it
            String nextLetter = letters.get(randomIndex);
            randomLetter = randomLetter.substring(1,myNum) + nextLetter;
        }
        return sb.toString();
    }
}
