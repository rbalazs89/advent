import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> input = readFile("src/input2.txt");

        Position[][] myMap = new Position[6001][6001];
        for(int i = -3000; i < 3000; i ++ ){
            for(int j = -3000; j < 3000; j ++){
                myMap[i+3000][j+3000] = new Position(i,j);
            }
        }

        AThing head = new AThing("head",0,0);
        AThing tail = new AThing("tail",0,0);

        for (int i = 0; i < input.size(); i++) {
            int move1 = Integer.valueOf(input.get(i).substring(2));
            String move2 = input.get(i).substring(0,1);
            switch(move2) {
                case "U":
                    for (int j = 0; j < move1; j++) {
                        head.positionY++;
                        if(Math.abs(head.positionY-tail.positionY) == 2) {
                            tail.positionY = head.positionY - 1;
                            tail.positionX = head.positionX;
                        }
                        myMap[tail.positionX+3000][tail.positionY+3000].hasBeenVisited = true;
                    }
                    break;

                case "D":
                    for (int j = 0; j < move1; j++) {
                        head.positionY--;
                        if(Math.abs(head.positionY-tail.positionY) == 2) {
                            tail.positionY = head.positionY + 1;
                            tail.positionX = head.positionX;
                        }
                        myMap[tail.positionX+3000][tail.positionY+3000].hasBeenVisited = true;

                    }
                    break;

                case "L":
                    for (int j = 0; j < move1; j++) {
                        head.positionX--;
                        if(Math.abs(head.positionX-tail.positionX) == 2) {
                            tail.positionX = head.positionX + 1;
                            tail.positionY = head.positionY;
                        }
                        myMap[tail.positionX+3000][tail.positionY+3000].hasBeenVisited = true;
                    }
                    break;

                case "R":
                    for (int j = 0; j < move1; j++) {
                        head.positionX++;
                        if(Math.abs(head.positionX-tail.positionX) == 2) {
                            tail.positionX = head.positionX - 1;
                            tail.positionY = head.positionY;
                        }
                        myMap[tail.positionX+3000][tail.positionY+3000].hasBeenVisited = true;
                    }
                    break;
            }
        }

        int counter = 0;
        for(int i = 0; i < 6000; i ++ ){
            for(int j = 0; j < 6000; j ++){
                if(myMap[i][j].hasBeenVisited){
                    counter++;
                }
            }
        }
        System.out.println(counter);
    }

    public static List<String> readFile(String file) {
        Path filePath = Paths.get(file);
        try {
            return Files.readAllLines(filePath);
        } catch (IOException e) {
            System.err.println("beep beep - maxi big error");
            return new ArrayList<>();
        }
    }
}