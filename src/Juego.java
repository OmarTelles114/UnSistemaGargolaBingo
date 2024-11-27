import java.util.ArrayList;

public class Juego {
    private Tombola tombola;
    private Carta carta;
    private Patron patron;

    public Juego(Patron patron) {
        this.tombola = new Tombola();
        this.carta = new Carta();
        this.patron = patron;
    }

    public boolean verificarGanador() {
        return patron.verificarPatron(carta.getNumeros(), new ArrayList<>(tombola.getHistorial()));
    }

    public int sacarBola() {
        return tombola.sacarBola();
    }

    public int[][] getCarta() {
        return carta.getNumeros();
    }

    public ArrayList<Integer> getHistorial() {
        return new ArrayList<>(tombola.getHistorial());
    }
}
