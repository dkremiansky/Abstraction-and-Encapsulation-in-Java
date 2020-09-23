package part2;

import java.util.Random;
/**
 * MarkovZero
 * runs the MarkovZero algorithms
 */
public class MarkovZero  extends AbstractMarkovModel {

	/**
	 * constructor
	 * implement the constructor of the abstract class with the specific markov number
	 */
	public MarkovZero()
	{
		super(0);
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