import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Kaban2 {
    public static void main(String[] args) {
        HashMap<String,Integer> priorities = initialize();
        List<String> sackContent = readFile("src/kaban.csv");


        int solutionNumber = 0;
        for (int i = 0; i < sackContent.size(); i+=3) {
            solutionNumber+= priorities.get(detectDuplicate(sackContent.get(i),sackContent.get(i+1),sackContent.get(i+2)));
        }
        System.out.println(solutionNumber);

    }

    public static String detectDuplicate(String sack1, String sack2, String sack3){
        ArrayList<String> sackElements1 = new ArrayList<>();
        ArrayList<String> sackElements2 = new ArrayList<>();
        ArrayList<String> sackElements3 = new ArrayList<>();
        for (int i = 0; i < sack1.length(); i++) {
            sackElements1.add(sack1.substring(i,i+1));
        }
        for (int i = 0; i < sack2.length(); i++) {
            sackElements2.add(sack2.substring(i,i+1));
        }
        for (int i = 0; i < sack3.length(); i++) {
            sackElements3.add(sack3.substring(i,i+1));
        }

        String duplicateString = "";
        for(int j = 0; j < sackElements1.size(); j++) {
            for (int i = 0; i < sackElements2.size(); i++) {
                for(int k = 0; k < sackElements3.size();k++){
                    if (sackElements1.get(j).equals(sackElements2.get(i)) && sackElements2.get(i).equals(sackElements3.get(k))){
                        duplicateString = sackElements1.get(j);
                    }
                }
            }
        }

        return duplicateString;
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

    public static HashMap<String, Integer> initialize(){
        HashMap priorities = new HashMap();

        priorities.put("a",1);
        priorities.put("b",2);
        priorities.put("c",3);
        priorities.put("d",4);
        priorities.put("e",5);
        priorities.put("f",6);
        priorities.put("g",7);
        priorities.put("h",8);
        priorities.put("i",9);
        priorities.put("j",10);
        priorities.put("k",11);
        priorities.put("l",12);
        priorities.put("m",13);
        priorities.put("n",14);
        priorities.put("o",15);
        priorities.put("p",16);
        priorities.put("q",17);
        priorities.put("r",18);
        priorities.put("s",19);
        priorities.put("t",20);
        priorities.put("u",21);
        priorities.put("v",22);
        priorities.put("w",23);
        priorities.put("x",24);
        priorities.put("y",25);
        priorities.put("z",26);
        priorities.put("A",27);
        priorities.put("B",28);
        priorities.put("C",29);
        priorities.put("D",30);
        priorities.put("E",31);
        priorities.put("F",32);
        priorities.put("G",33);
        priorities.put("H",34);
        priorities.put("I",35);
        priorities.put("J",36);
        priorities.put("K",37);
        priorities.put("L",38);
        priorities.put("M",39);
        priorities.put("N",40);
        priorities.put("O",41);
        priorities.put("P",42);
        priorities.put("Q",43);
        priorities.put("R",44);
        priorities.put("S",45);
        priorities.put("T",46);
        priorities.put("U",47);
        priorities.put("V",48);
        priorities.put("W",49);
        priorities.put("X",50);
        priorities.put("Y",51);
        priorities.put("Z",52);

        return priorities;
    }
}