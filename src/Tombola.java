import java.util.ArrayList;
import java.util.Collections;

public class Tombola {
    private ArrayList<Integer> numeros;
    private ArrayList<Integer> historial;

    public Tombola() {
        numeros = new ArrayList<>();
        for (int i = 1; i <= 75; i++) {
            numeros.add(i);
        }
        Collections.shuffle(numeros);
        historial = new ArrayList<>();
    }

    public int sacarBola() {
        if (numeros.isEmpty()) {
            return -1; // No más bolas.
        }
        int bola = numeros.remove(0);
        historial.add(bola);
        return bola;
    }

    public ArrayList<Integer> getHistorial() {
        return historial;
    }
}
