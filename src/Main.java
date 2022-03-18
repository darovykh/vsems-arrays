import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Main {

    public static String [] cleanFromPunctuationSigns(String content) {
        String regex = "(-[^a-z])|([^a-z]-)|(^-)|(-$)|(^-$)|([0-9[\\W&&[^\\u0020]&&[^`]&&[^-]]])";
        content = content.toLowerCase().replaceAll(regex, "");
        return content.split(" ");
    }

    public static String [] sortDistinctWordsByAlphabet(String [] words) {
        String uniqueAsString = "";
        for(int i = 0; i < words.length; i++){
            if(!uniqueAsString.contains(words[i])) {
                uniqueAsString += words[i] + " ";
            }
        }

        String [] uniqueAsArray = uniqueAsString.split(" ");
        Arrays.sort(uniqueAsArray);
        return uniqueAsArray;
    }

    public static void main(String [] args) throws IOException {
        String [] words = cleanFromPunctuationSigns(new String(Files.readAllBytes(Paths.get("harry.txt"))));
        String [] sortedDistincts = sortDistinctWordsByAlphabet(words);
        for(String i: sortedDistincts) {
            System.out.println(i);
        }
    }

}
