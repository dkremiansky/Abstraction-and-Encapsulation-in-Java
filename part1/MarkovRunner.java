package part1;

import util.*;

/**
 * MarkovRunner
 * runs and print the results of four different markov algorithms
 */
public class MarkovRunner {

	/**
	 * recives training file path and runs the markov zero algorithm
	 * @param trainingFilePath - link to the text training file
	 */
    public void runMarkovZero(String trainingFilePath) {
		SEFileUtil seFileUtil = new SEFileUtil(trainingFilePath);
		String st = seFileUtil.asString();
		st = st.replace('\n', ' ');
		MarkovZero markov = new MarkovZero();
		markov.setSeed(25);
		markov.setTraining(st);
		for(int k=0; k < 3; k++){
			String text = markov.getRandomText(500);
			printOut(text);
		}
	}

	/**
	 * recives training file path and runs the markov one algorithm
	 * @param trainingFilePath - link to the text training file
	 */
	public void runMarkovOne(String trainingFilePath) {
		SEFileUtil seFileUtil = new SEFileUtil(trainingFilePath);
		String st = seFileUtil.asString();
		st = st.replace('\n', ' ');
		MarkovOne markov = new MarkovOne();
		markov.setSeed(25);
		markov.setTraining(st);
		for(int k=0; k < 3; k++){
			String text = markov.getRandomText(500);
			printOut(text);
		}
	}

	/**
	 * recives training file path and runs the markov four algorithm
	 * @param trainingFilePath - link to the text training file
	 */
	public void runMarkovFour(String trainingFilePath) {
		SEFileUtil seFileUtil = new SEFileUtil(trainingFilePath);
		String st = seFileUtil.asString();
		st = st.replace('\n', ' ');
		MarkovFour markov = new MarkovFour();
		markov.setSeed(25);
		markov.setTraining(st);
		for(int k=0; k < 3; k++){
			String text = markov.getRandomText(500);
			printOut(text);
		}

	}

	/**
	 * recives training file path and runs the markov model algorithm
	 * @param trainingFilePath - link to the text training file
	 */
	public void runMarkovModel(String trainingFilePath) {
		SEFileUtil seFileUtil = new SEFileUtil(trainingFilePath);
		String st = seFileUtil.asString();
		st = st.replace('\n', ' ');
		int numN = 6;
		MarkovModel markov = new MarkovModel(numN);
		markov.setSeed(25);
		markov.setTraining(st);
		for(int k=0; k < 3; k++){
			String text = markov.getRandomText(500);
			printOut(text);
		}
	}

	/**
	 * recives the output of a markov algorithm and prints it in lines
	 * with length of 60 chars
	 * @param s - output of a markov algorithm
	 */
	private void printOut(String s){
		String[] words = s.split("\\s+");
		int psize = 0;
		System.out.println("----------------------------------");
		for(int k=0; k < words.length; k++){
			System.out.print(words[k]+ " ");
			psize += words[k].length() + 1;
			if (psize > 60) {
				System.out.println();
				psize = 0;
			}
		}
		System.out.println("\n----------------------------------");
	}

	/**
	 * recives path of the text file and runs class
	 * @param  args - recives arguments of the class
	 */
	public static void main(String[] args) {
		MarkovRunner markovRunner = new MarkovRunner();
		markovRunner.runMarkovZero(args[0]);
		markovRunner.runMarkovOne(args[0]);
		markovRunner.runMarkovFour(args[0]);
		markovRunner.runMarkovModel(args[0]);

	}
	
}
