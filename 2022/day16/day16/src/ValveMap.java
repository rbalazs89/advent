import java.util.ArrayList;
import java.util.List;


public class ValveMap {

    List<Valves> allValves;

    public ValveMap() {
        allValves = new ArrayList<>();
    }

    public void fillConnectedValveMap() {
        for (int i = 0; i < allValves.size(); i++) {
            allValves.get(i).fillConnected(allValves);
        }
    }
}
