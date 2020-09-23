package part2;
import part1.MarkovRunner;
import util.SEFileUtil;


/**
 * The class is use to generate random text
 */
public class MarkovRunnerWithInterface {


	/**
	 * run the algorithm on the current markov object
	 * @param markov -the current markov object
	 * @param text - the original text on which it runs the algorithm
	 * @param size - the size of the text that it grills from the original text
	 * @param seed - the number of the random object
	 */
    public void runModel(IMarkovModel markov, String text, int size, int seed) {
        markov.setTraining(text);
		markov.setSeed(seed);
        System.out.println("running with " + markov);
        for(int k=0; k < 3; k++){
			String st= markov.getRandomText(size);
			printOut(st);
		}
    }


	/**
	 * creates and runs all the markov classes
	 * @param trainingFilePath - the path to the file with the original text
	 * @param seed - the number of the random object
	 */
    public void runMarkov(String trainingFilePath, int seed) {
		SEFileUtil seFileUtil = new SEFileUtil(trainingFilePath);
		String st = seFileUtil.asString();
		st = st.replace('\n', ' ');
		int size = 200;
		
        MarkovZero mz = new MarkovZero();
        runModel(mz, st, size,seed);
        mz.toString();
    
        MarkovOne mOne = new MarkovOne();
        runModel(mOne, st, size,seed);
		mOne.toString();
        
        MarkovModel mThree = new MarkovModel(3);
        runModel(mThree, st, size,seed);
		mThree.toString();

        
        MarkovFour mFour = new MarkovFour();
        runModel(mFour, st, size,seed);
        mFour.toString();

    }


	/**
	 * print a current text according to the requirements of homework
	 * @param s - the text for printing
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
	 * receives path of the text file and the seed number
	 * checks the arguments and returns error message if there is an error
	 * or runs the program
	 * @param args - get arguments from the user
	 */
	public static void main(String[] args) {
		if (args.length!=2)
		{
			System.out.println("Please pass two arguments: 1.input_file 2.seed");
			System.exit(1);
		}
    	try {
			MarkovRunnerWithInterface markovRunner = new MarkovRunnerWithInterface();
			int seed = Integer.parseInt(args[1]);
			markovRunner.runMarkov(args[0], seed);
		}
		catch (NumberFormatException e) {
			System.out.println("The second argument must be an integer");
			System.exit(1);
		}
	}
}
