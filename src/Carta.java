import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Carta {
    private int[][] numeros;

    public Carta() {
        numeros = generarCarta();
    }

    private int[][] generarCarta() {
        int[][] carta = new int[5][5];
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            int min = 1 + i * 15;
            int max = min + 14;
            List<Integer> numerosColumna = random.ints(min, max + 1)
                    .distinct()
                    .limit(5)
                    .boxed()
                    .collect(Collectors.toList());
            for (int j = 0; j < 5; j++) {
                carta[j][i] = numerosColumna.get(j);
            }
        }

        carta[2][2] = 0; // Espacio libre
        return carta;
    }

    public int[][] getNumeros() {
        return numeros;
    }
}