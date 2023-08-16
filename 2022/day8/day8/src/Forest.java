import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Forest {

    static int length = 99; // length and width of the forestLinesFromFile is the same.

    public static void main(String[] args) {
        List<String> forestLinesFromFile = readFile("src/mori.txt");
        System.out.println(forestLinesFromFile.get(0));
        int[][] trees = new int[length][length];
        ArrayList<ATree> forest = new ArrayList<>();

        // Adding forestLinesFromFile map to a List and an Array.
        for (int i = 0; i < length; i++) {
            for(int j = 0; j < length; j++){
                trees[i][j] = Integer.parseInt(forestLinesFromFile.get(i).substring(j,j+1));
                forest.add(new ATree(j,i,Integer.parseInt(forestLinesFromFile.get(i).substring(j,j+1))));
            }
        }

        int tempNumber = 0;
        for (int i = 0; i < length; i++) {
            for(int j = 0; j < length; j++){

                //visible from west
                tempNumber = 0;
                for(int a = j; a > 0; a--){
                    if(trees[i][j] > trees[i][j-a]){
                        tempNumber++;
                    }
                }
                if (tempNumber == j) {
                    forest.get(converter(i,j)).visible = true;
                }

                //visible from east
                tempNumber = 0;
                for (int a = length-j-1; a > 0; a --){
                    if((trees[i][j]) > (trees[i][j+a])){
                        tempNumber++;
                    }
                }
                if (tempNumber == length-1-j){
                    forest.get(converter(i,j)).visible = true;
                }

                //visible from north
                tempNumber = 0;
                for(int a = i; a > 0; a--){
                    if(trees[i][j] > trees[i-a][j]){
                        tempNumber++;
                    }
                }
                if (tempNumber == i) {
                    forest.get(converter(i,j)).visible = true;
                }


                //visible from south
                tempNumber = 0;
                for (int a = length-i-1; a > 0; a --){
                    //System.out.println("i: " + i + " j: " + j + " a: " + a + " tree height: " + trees[i][j] + " " + trees[i][j+a] + " counter: " + tempNumber);
                    if((trees[i][j]) > (trees[i+a][j])){
                        tempNumber++;
                    }
                }
                if (tempNumber == length-1-i){
                    forest.get(converter(i,j)).visible = true;
                }
            }
        }

        int visibleTreeCounter = 0;
        for (int i = 0; i < forest.size(); i++) {
            if(forest.get(i).visible == true){
                visibleTreeCounter++;
                //System.out.println("x: " + forest.get(i).x + " y: " + forest.get(i).y + " height: " + forest.get(i).height);
            }
        }
        System.out.println(visibleTreeCounter);
    }

    public static List<String> readFile(String file) {
        Path filePath = Paths.get(file);
        try {
            List<String> fileLines = Files.readAllLines(filePath);
            return fileLines;
        } catch (IOException e) {
            System.err.println("beep beep - big error");
            return new ArrayList<>();
        }
    }

    public static int converter(int i, int j){
        return length * i + j;
    }
}
