import java.util.ArrayList;
import java.util.List;

public class Valves {

    List<Valves> connectedValves;
    String identifier;
    int value;
    String connected;
    boolean opened;

    public Valves(String identifier, int value, String connected) {
        connectedValves = new ArrayList<>();
        this.value = value;
        this.identifier = identifier;
        this.connected = connected; // helper string to add connected valves
        opened = false;
    }

    public void fillConnected(List<Valves> allValves) {
        for (int i = 0; i < allValves.size(); i++) {
            if(this.connected.contains(allValves.get(i).identifier)){
                this.connectedValves.add(allValves.get(i));
            }
        }
    }

    @Override
    public String toString() {
        return "Valve " + identifier + " has a flow rate = " + value +"; tunnels lead to valve(s): " + connected;
    }

}
