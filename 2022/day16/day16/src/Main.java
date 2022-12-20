import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> input = readFile("src/input.txt");
        ValveMap valvemap = new ValveMap();

        for (int i = 0; i < input.size(); i++) {
            String tempString = "";
            int tempValue = 0;
            String tempString2 = "";

            tempString = input.get(i).substring(6,8);

            if (input.get(i).charAt(24) == ';'){
                tempValue = Integer.parseInt(input.get(i).substring(23,24));
            }
            else {
                tempValue = Integer.parseInt(input.get(i).substring(23,25));
            }

            String helperString = input.get(i).substring(input.get(i).indexOf("to "));

            if(helperString.charAt(8) == 's') {
                tempString2 = helperString.substring(10);
            }
            else tempString2 = helperString.substring(9);

            valvemap.allValves.add(new Valves(tempString, tempValue, tempString2));
        }

        valvemap.fillConnectedValveMap();

        List<Valves> openedValves = new ArrayList<>();

        List<Integer> resultList = new ArrayList<>();

        for (int i = 0; i < 9999999; i++) {
            resultList.add(findRandomRoute(30, valvemap.allValves.get(0), 0, openedValves));
        }
        System.out.println(Collections.max(resultList));
    }

    public static int findRandomRoute(int count, Valves valve1, int value, List<Valves> openedValves){
        if (count == 0) return value;

        List <Valves> currentOpenedValves = new ArrayList<>();
        currentOpenedValves.addAll(openedValves);

        int currentValue = value;
        Valves currentValve;

        for (int i = 0; i < openedValves.size(); i++) {
            currentValue = currentValue + openedValves.get(i).value;
        }
        int rand;
        if(valve1.opened || valve1.value == 0){
            rand = (int)(Math.random()*(valve1.connectedValves.size()))+1;
        }
        else{
            rand = (int)(Math.random()*(valve1.connectedValves.size()+1));
        }

        if(rand == 0){
            currentValve = valve1;
            currentValve.opened = true;
            currentOpenedValves.add(valve1);
        } else {
            currentValve = valve1.connectedValves.get(rand-1);
        }
        return findRandomRoute(count-1, currentValve, currentValue, currentOpenedValves);
    }

    public static List<String> readFile(String file) {
        Path filePath = Paths.get(file);

        try {
            List<String> fileLines = Files.readAllLines(filePath);
            return fileLines;
        } catch (IOException var3) {
            System.err.println("beep beep - cannot find file - beep beep");
            return new ArrayList();
        }
    }
}