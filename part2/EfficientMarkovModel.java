package part2;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The class streamlines the running of markov algorithm
 */
public class EfficientMarkovModel  extends AbstractMarkovModel {
    public HashMap<String, ArrayList<String> > map;

    /**
     * constructor
     * implement the constructor of the abstract class with the specific markov number
     * and define a hashMap
     */
    public EfficientMarkovModel(int n) {
        super(n);
        map = new HashMap<String, ArrayList<String> >();
    }

    /**
     * initialize the inner variable myText with some string
     * and call to the buildMap function
     * @param s - the text that we receive
     */
    @Override
    public void setTraining(String s) {
        this.myText = s.trim();
        buildMap();
    }

    /**
     * builds a map by creating an array list of all the chars
     * that follow each key in myText
     */
    public void buildMap()
    {
        for(int letterNum=0; letterNum < myText.length()-myNum; letterNum++) {
            String key = myText.substring(letterNum,letterNum+myNum);
            String nextLetter = String.valueOf(myText.charAt(letterNum + myNum));
           if (!map.containsKey(key)) {
                ArrayList<String> lettersArray = new ArrayList<String>();
                lettersArray.add(nextLetter);
                map.put(key,lettersArray);
            }else
                {
                map.get(key).add(nextLetter);
            }
        }
    }

    /**
     * recives key and gets an array list of all the chars that follow
     * the key string in myText from the hashMap
     * @param key - string parameter
     * @return letters  -  array list of all the chars that follow
     * the key string in myText
     */
    @Override
    public ArrayList<String> getFollows(String key)
    {
        return map.get(key);
    }

    /**
     * creates a definition of the current markov model with its number
     * @return a string of the current markov model with its number
     */
    @Override
    public String toString()
    {
        return "EfficientMarkovModel of order " + myNum;
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
            randomLetter = (sb.toString()).substring((sb.toString()).length()-myNum);
        }
        return sb.toString();
    }
}
