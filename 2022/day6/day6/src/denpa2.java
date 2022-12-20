import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class denpa2 {
    public static void main(String[] args) {
        List<String> noise = readFile("src/denpa.csv");
        String signalText = noise.get(0);
        getInt(signalText);
    }



    public static boolean repeatChar2(String text){
        ArrayList<String> textElements = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            textElements.add(text.substring(i,i+1));
        }

        boolean result = true;

        for (int i = 0; i < textElements.size(); i++) {
            for (int j = 0; j< textElements.size(); j++){
                //System.out.println("i: " + i + " j: " + j +" result: " +result);
                if(textElements.get(i).equals(textElements.get(j)) && i!= j){
                    return true;
                }
                else result = false;
            }
        }
        return result;
    }

    public static int getInt(String text){
        int solution = 0;
        for (int i = 0; i < text.length()-14; i++) {
            if(repeatChar2(text.substring(i,i+14))==false) {
                solution = i + 14;
                break;
            }
        }
        System.out.println(solution);
        return solution;
    }
    
    public static List<String> readFile(String file){
        Path filePath = Paths.get(file);
        try{
            List<String> fileLines = Files.readAllLines(filePath);
            return fileLines;
        }
        catch (IOException e){
            System.err.println("beep beep error");
            return new ArrayList<>();
        }
    }
}