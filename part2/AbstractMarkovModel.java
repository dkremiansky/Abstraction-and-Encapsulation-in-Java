package part2;

import java.util.*;

/**
 * AbstractMarkovModel
 * abstract class for all markov classes that implements the IMarkovModel
 */
public abstract class AbstractMarkovModel implements IMarkovModel {
    protected String myText;
    protected Random myRandom;
    protected int myNum;

    /**
     * constructor
     * declare random object and set myNum
     */
    public AbstractMarkovModel(int myNum) {
        this.myRandom = new Random();
        this.myNum = myNum;
    }

    /**
     * initialize the random object with a seed number
     * @param seed - the number of the current random object
     */
    public void setSeed(int seed) {
        this.myRandom = new Random(seed);
    }

    /**
     * initialize the inner variable myText with some string
     * @param s - the text that we receive
     */
    public void setTraining(String s) {
        this.myText = s.trim();
    }

    /**
     * declare an abstract method that the extended classes have to implement
     * @param numChars - the number of chars we want to grill
     */
    abstract public String getRandomText(int numChars);

    /**
     * creates a definition of the current markov model with its number
     * @return a string of the current markov model with its number
     */
    public String toString()
    {
        return "MarkovModel of order " + myNum;
    }

    /**
     * recives key and creates an array list of all the chars that follow
     * the key string in myText
     * @param key - string parameter
     * @return letters  -  array list of all the chars that follow
     * the key string in myText
     */
    public ArrayList<String> getFollows(String key)
    {
        int keyLength = key.length();
        ArrayList<String> letters = new ArrayList<String>();
        for (int i = 0; i < myText.length() - keyLength; i++) {
            //instead of substring method that takes too much time
            String ourString = myText.substring(i,i+keyLength);
            if (ourString.equals(key)) {
                letters.add(String.valueOf(myText.charAt(i + keyLength)));
            }
        }
        return letters;
    }

}
