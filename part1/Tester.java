package part1;

import java.util.ArrayList;

/**
 * Tester
 * a class for testing markovOne
 */
public class Tester {

    /**
     * runs the MarkovOne algorithm and prints the results
     */
    public void testGetFollows()
    {
        String testText = "this is a test yes this is a test.";
        MarkovOne markov = new MarkovOne();
        markov.setTraining(testText);
        String key = ".";
        ArrayList<String> test = markov.getFollows(key);
        System.out.println(test);

    }

    /**
     * recives path of the text file and runs the class
     * @param  args - recives arguments of the class
     */
    public static void main(String[] args) {
        Tester tester = new Tester();
        tester.testGetFollows();

    }

}
