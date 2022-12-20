import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class souji {
    public static void main(String[] args) {

        List<String> schedule = readFile("src/jikanwari.csv");
        ArrayList<int[]> scheduleTable = new ArrayList<>();

        for (int i = 0; i < schedule.size(); i++) {
            scheduleTable.add(new int[]{
                    Integer.parseInt(schedule.get(i).split(",")[0].split("-")[0]),
                    Integer.parseInt(schedule.get(i).split(",")[0].split("-")[1]),
                    Integer.parseInt(schedule.get(i).split(",")[1].split("-")[0]),
                    Integer.parseInt(schedule.get(i).split(",")[1].split("-")[1])});
        }

        int solution = 0;

        for (int i = 0; i < scheduleTable.size(); i++) {
            if(((scheduleTable.get(i)[0] >= scheduleTable.get(i)[2]) && scheduleTable.get(i)[1]<=scheduleTable.get(i)[3]) ||
                    ((scheduleTable.get(i)[0] <= scheduleTable.get(i)[2]) && scheduleTable.get(i)[1]>=scheduleTable.get(i)[3])){
                solution+=1;
            }

        }
        System.out.println(solution);

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
