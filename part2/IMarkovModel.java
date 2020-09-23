package part2;

/**
 * IMarkovModel interface
 * interface class for all markov classes
 */
public interface IMarkovModel {
    public void setTraining(String text);
    public void setSeed(int seed);
    public String getRandomText(int numChars);
}
