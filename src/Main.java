import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String[] massiv = readFromFile("text.txt");
        String mostFrequent = findMostFrequent(massiv);
        System.out.println("самое частое слово "+mostFrequent);
    }

    private static String findMostFrequent(String[] words) {
        Map<String, Integer> howManyTimes = new HashMap<>();
        for (String word: words ) {
            if(!howManyTimes.containsKey(word))
                howManyTimes.put(word, 1);
            else{
                int x = howManyTimes.get(word);
                howManyTimes.put(word, 1+x);
            }
        }
        //System.out.println(howManyTimes);
        int maxVal=0;
        String wordWithMaxVal="";
        for (Map.Entry<String, Integer> pair: howManyTimes.entrySet()) {
            if (pair.getValue() > maxVal)
            {
                maxVal = pair.getValue();
                wordWithMaxVal = pair.getKey();
            }
        }

        return wordWithMaxVal;
    }

    private static String[] readFromFile(String file) {
        return "Мама мыла раму Мила мыла Антона Ева раму ела раму".split(" ");
    }
}