import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class denpa {
    public static void main(String[] args) {
        List<String> schedule = readFile("src/denpa.csv");
        String signalText = schedule.get(0);
        System.out.println(signalText);


        getInt("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg");
        getInt(signalText);


    }

    public static boolean repeatChar(String text){
        if (text.substring(0,1).equals(text.substring(1,2)) || text.substring(0,1).equals(text.substring(2,3)) || text.substring(0,1).equals(text.substring(3,4))
                || text.substring(1,2).equals(text.substring(2,3)) || text.substring(1,2).equals(text.substring(3,4))
                || text.substring(2,3).equals(text.substring(3,4)))
            return true;
        else return false;
    }

    public static int getInt(String text){
        int solution = 0;
        for (int i = 0; i < text.length()-4; i++) {
            if(repeatChar(text.substring(i,i+4))==false) {
                solution = i + 4;
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
