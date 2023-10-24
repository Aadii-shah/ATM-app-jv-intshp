import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class WordCounter {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the text or provide file path");
        String userInput = scanner.next();
        String text = "";

        //checking whether the user has provided text or filepath
        if (new File(userInput).isFile()){
            text = new String(Files.readAllBytes(Paths.get(userInput)));
        } else {
            text =userInput;
        }

        String[] words = text.split("[\\s\\p{Punct}]+");
        int wordCounts = 0;
        System.out.println(words);

        String[] stopWords = {"the", "and", "of", "in", "to" };
        Map<String, Integer> wordFrequency = new HashMap<>();

        for (String word: words) {
            if (!word.isEmpty() && !Arrays.asList(stopWords).contains(word.toLowerCase())){
                wordCounts++;
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
        }
        System.out.println("Total word count: " + wordCounts);
        System.out.println("Unique word count: " + wordFrequency.size());
    }
}