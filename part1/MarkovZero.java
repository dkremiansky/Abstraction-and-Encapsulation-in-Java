package part1;

import java.util.Random;
/**
 * MarkovZero
 * runs the MarkovZero algorithms
 */
public class MarkovZero {
    private String myText;
	private Random myRandom;

	/**
	 * constructor
	 * declare random object
	 */
	public MarkovZero() {
		myRandom = new Random();
	}

	/**
	 * initialize the random object with a seed number
	 * @param seed - the number of the current random object
	 */
	public void setSeed(int seed){
		myRandom = new Random(seed);
	}

	/**
	 * initialize the inner variable myText with some string
	 * @param s - the text that we recieve
	 */
	public void setTraining(String s){
		myText = s.trim();
	}

	/**
	 * recives the number of chars that we want to grill out of myText
	 * and creates new text
	 * @param numChars - the number of chars we want to grill
	 * @return the new text that we grill from myText
	 */
	public String getRandomText(int numChars){
		if (myText == null){
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for(int k=0; k < numChars; k++){
			int index = myRandom.nextInt(myText.length());
			sb.append(myText.charAt(index));
		}
		
		return sb.toString();
	}
}