package oxes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Main {
    public static void main(String[] args) {
        Path filePath = Path.of("src/oxes/deercalories.csv");
        ArrayList <ArrayList<String>> listOut2 = initilaize();
        //operationCrateMover9001(2,1,8,listOut2);

        try {
            List<String> fileLines = Files.readAllLines(filePath);
            for (int i = 0; i < fileLines.size(); i++) {
                String[] splitData = fileLines.get(i).split(" ");
                int howMany = Integer.parseInt(splitData[1]);
                int columFrom = Integer.parseInt(splitData[3]);
                int columTo = Integer.parseInt(splitData[5]);
                operationCrateMover9001(howMany, columFrom, columTo, listOut2);
                System.out.println(fileLines.get(i));
                System.out.println();
            }
        } catch (IOException exception){
            System.out.println("No file exist");
        }
        //List<String> instructions = readFile("src/oxes/deercalories.csv");

    }

    public static ArrayList <ArrayList<String>> initilaize(){
        ArrayList <ArrayList<String>> listOut= new ArrayList<>();

        ArrayList<String> listIn1 = new ArrayList<>(List.of("D","H","N","Q","T","W","V","B"));
        ArrayList<String> listIn2 = new ArrayList<>(List.of("D","W","B"));
        ArrayList<String> listIn3 = new ArrayList<>(List.of("T","S","Q","W","J","C"));
        ArrayList<String> listIn4 = new ArrayList<>(List.of("F","J","R","N","Z","T","P"));
        ArrayList<String> listIn5 = new ArrayList<>(List.of("G","P","V","J","M","S","T"));
        ArrayList<String> listIn6 = new ArrayList<>(List.of("B","W","F","T","N"));
        ArrayList<String> listIn7 = new ArrayList<>(List.of("B","L","D","Q","F","H","V","N"));
        ArrayList<String> listIn8 = new ArrayList<>(List.of("H","P","F","R"));
        ArrayList<String> listIn9 = new ArrayList<>(List.of("Z","S","M","B","L","N","P","H"));
        listOut.add(listIn1);
        listOut.add(listIn2);
        listOut.add(listIn3);
        listOut.add(listIn4);
        listOut.add(listIn5);
        listOut.add(listIn6);
        listOut.add(listIn7);
        listOut.add(listIn8);
        listOut.add(listIn9);
        return listOut;
    }


    public static ArrayList <ArrayList<String>> operationCrateMover9001(int howMany,int columFrom, int columTo,ArrayList <ArrayList<String>> listOut1){
        //ArrayList <ArrayList<String>> listOut1 = initilaize();

        System.out.println(listOut1);

        for(int i = howMany;i > 0;i --) {
            listOut1.get(columTo - 1).add(listOut1.get(columFrom - 1).get(listOut1.get(columFrom - 1).size()-i));
            listOut1.get(columFrom - 1).remove(listOut1.get(columFrom - 1).size() - i);
        }
        System.out.println(listOut1);
        return listOut1;
    }

    public static ArrayList <ArrayList<String>> operationCrateMover9000(int howMany,int columFrom, int columTo,ArrayList <ArrayList<String>> listOut1){

        for(int i = 0;i<howMany;i++) {

            listOut1.get(columTo - 1).add(listOut1.get(columFrom - 1).get(listOut1.get(columFrom - 1).size() - 1));
            listOut1.get(columFrom - 1).remove(listOut1.get(columFrom - 1).size() - 1);
            //System.out.println(listOut1);
        }

        return listOut1;
    }

    public static List<String> readFile(String file){
        Path filePath = Paths.get(file);
        try{
            List<String> fileLines = Files.readAllLines(filePath, UTF_8);
            //fileLines.remove(0);
            return fileLines;
        }catch (IOException e){
            System.err.println("beep beep unable to read");
            return new ArrayList<>(); //return empty list
        }
    }
}