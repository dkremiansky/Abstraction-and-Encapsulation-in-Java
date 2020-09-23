package part1;
import java.util.ArrayList;
import java.util.Random;

/**
 * MarkovFour
 * runs the MarkovFour algorithms
 */
public class MarkovFour {
    private String myText;
    private Random myRandom;

    /**
     * constructor
     * declare random object
     */
    public MarkovFour() {
        myRandom = new Random();
    }

    /**
     * initialize the random object with a seed number
     * @param seed - the number of the current random object
     */
    public void setSeed(int seed) {
        myRandom = new Random(seed);
    }

    /**
     * initialize the inner variable myText with some string
     * @param s - the text that we recieve
     */
    public void setTraining(String s) {
        myText = s.trim();
    }

    /**
     * recives the number of chars that we want to grill out of myText
     * and creates new text
     * @param numChars - the number of chars we want to grill
     * @return the new text that we grill from myText
     */
    public String getRandomText(int numChars) {
        if (myText == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int firstRandomIndex = myRandom.nextInt(myText.length() - 4);
        String firstRandomLetter = myText.substring(firstRandomIndex, firstRandomIndex+4);
        sb.append(firstRandomLetter);
        ArrayList<String> letters = getFollows(sb.toString());
        for (int k = 0; k < numChars - 4; k++) {
            if(letters.size() == 0)
                break;
            int index = myRandom.nextInt(letters.size());
            String ourTab = letters.get(index);
            sb.append(ourTab);
            letters = getFollows(sb.substring(sb.length()-4,sb.length()));
        }
        return sb.toString();
    }

    /**
     * recives key and creates an array list of all the chars that follow
     * the key string in myText
     * @param key - string parameter
     * @return letters  -  array list of all the chars that follow
     * the key string in myText
     */
    public ArrayList<String> getFollows(String key) {
        int keyLength = key.length();
        ArrayList<String> letters = new ArrayList<String>();
        for (int i = 0; i <= myText.length() - keyLength; i++) {
            String ourString = myText.substring(i, i + keyLength);
            if (ourString.equals(key)) {
                if (i != myText.length() - keyLength)
                    letters.add(String.valueOf(myText.charAt(i + keyLength)));
            }
        }
        return letters;
    }

}


