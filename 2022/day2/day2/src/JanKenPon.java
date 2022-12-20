import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JanKenPon {
    public static void main(String[] args) {
        List<String> matchSetups = readFile("src/rockPaperScissor.csv");

        int score = 0;
        for (int i = 0; i < matchSetups.size();i++){
            if(matchSetups.get(i).equals("A X")){
                score += 3;
            }
            else if(matchSetups.get(i).equals("A Y")){
                score += 4;
            }
            else if(matchSetups.get(i).equals("A Z")){
                score += 8;
            }
            else if(matchSetups.get(i).equals("B X")){
                score += 1;
            }
            else if(matchSetups.get(i).equals("B Y")){
                score += 5;
            }
            else if(matchSetups.get(i).equals("B Z")){
                score += 9;
            }
            else if(matchSetups.get(i).equals("C X")){
                score += 2;
            }
            else if(matchSetups.get(i).equals("C Y")){
                score += 6;
            }
            else if(matchSetups.get(i).equals("C Z")){
                score += 7;
            }
        }
        System.out.println(score);

        /*int score = 0;
        for (int i = 0; i < matchSetups.size();i++){
            if(matchSetups.get(i).equals("A X")){
                score += 4;
            }
            else if(matchSetups.get(i).equals("A Y")){
                score += 8;
            }
            else if(matchSetups.get(i).equals("A Z")){
                score += 3;
            }
            else if(matchSetups.get(i).equals("B X")){
                score += 1;
            }
            else if(matchSetups.get(i).equals("B Y")){
                score += 5;
            }
            else if(matchSetups.get(i).equals("B Z")){
                score += 9;
            }
            else if(matchSetups.get(i).equals("C X")){
                score += 7;
            }
            else if(matchSetups.get(i).equals("C Y")){
                score += 2;
            }
            else if(matchSetups.get(i).equals("C Z")){
                score += 6;
            }
        }*/

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
