import java.util.ArrayList;

public class Patron {
    private boolean[][] estructura;

    public Patron(boolean[][] estructura) {
        this.estructura = estructura;
    }

    public boolean verificarPatron(int[][] carta, ArrayList<Integer> numerosExtraidos) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (estructura[i][j] && !numerosExtraidos.contains(carta[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean[][] getEstructura() {
        return estructura;
    }

    // Líneas Horizontales (5 posibles) 1-5
    public static boolean[][] lineaHorizontal(int fila) {
        boolean[][] patron = new boolean[5][5];
        for (int j = 0; j < 5; j++) {
            patron[fila][j] = true;
        }
        return patron;
    }

    // Líneas Verticales (5 posibles) 6 - 10
    public static boolean[][] lineaVertical(int columna) {
        boolean[][] patron = new boolean[5][5];
        for (int i = 0; i < 5; i++) {
            patron[i][columna] = true;
        }
        return patron;
    }

    // Diagonales (2 posibles) 11,12
    public static boolean[][] diagonalPrincipal() {
        boolean[][] patron = new boolean[5][5];
        for (int i = 0; i < 5; i++) {
            patron[i][i] = true;
        }
        return patron;
    }

    public static boolean[][] diagonalSecundaria() {
        boolean[][] patron = new boolean[5][5];
        for (int i = 0; i < 5; i++) {
            patron[i][4 - i] = true;
        }
        return patron;
    }

    // 6-Pack (8 posibles) 13 - 36
    public static boolean[][] seisPack13() {
        boolean[][] patron = new boolean[5][5];
        patron[0][0] = true; patron[0][1] = true;
        patron[0][2] = true; patron[1][0] = true;
        patron[1][1] = true; patron[1][2] = true;
        return patron;
    }

    public static boolean[][] seisPack14() {
        boolean[][] patron = new boolean[5][5];
        patron[0][1] = true; patron[1][1] = true;
        patron[0][2] = true; patron[1][2] = true;
        patron[0][3] = true; patron[1][3] = true;
        return patron;
    }

    public static boolean[][] seisPack15() {
        boolean[][] patron = new boolean[5][5];
        patron[0][2] = true; patron[1][2] = true;
        patron[0][3] = true; patron[1][3] = true;
        patron[0][4] = true; patron[1][4] = true;
        return patron;
    }

    public static boolean[][] seisPack16() {
        boolean[][] patron = new boolean[5][5];
        patron[1][0] = true; patron[2][0] = true;
        patron[1][1] = true; patron[2][1] = true;
        patron[1][2] = true; patron[2][2] = true;
        return patron;
    }

    public static boolean[][] seisPack17() {
        boolean[][] patron = new boolean[5][5];
        patron[1][1] = true; patron[2][1] = true;
        patron[1][2] = true; patron[2][2] = true;
        patron[1][3] = true; patron[2][3] = true;
        return patron;
    }

    public static boolean[][] seisPack18() {
        boolean[][] patron = new boolean[5][5];
        patron[1][2] = true; patron[2][2] = true;
        patron[1][3] = true; patron[2][3] = true;
        patron[1][4] = true; patron[2][4] = true;
        return patron;
    }

    public static boolean[][] seisPack19() {
        boolean[][] patron = new boolean[5][5];
        patron[2][0] = true; patron[3][0] = true;
        patron[2][1] = true; patron[3][1] = true;
        patron[2][2] = true; patron[3][2] = true;
        return patron;
    }

    public static boolean[][] seisPack20() {
        boolean[][] patron = new boolean[5][5];
        patron[2][1] = true; patron[3][1] = true;
        patron[2][2] = true; patron[3][2] = true;
        patron[2][3] = true; patron[3][3] = true;
        return patron;
    }

    public static boolean[][] seisPack21() {
        boolean[][] patron = new boolean[5][5];
        patron[2][2] = true; patron[3][2] = true;
        patron[2][3] = true; patron[3][3] = true;
        patron[2][4] = true; patron[3][4] = true;
        return patron;
    }

    public static boolean[][] seisPack22() {
        boolean[][] patron = new boolean[5][5];
        patron[3][0] = true; patron[4][0] = true;
        patron[3][1] = true; patron[4][1] = true;
        patron[3][2] = true; patron[4][2] = true;
        return patron;
    }

    public static boolean[][] seisPack23() {
        boolean[][] patron = new boolean[5][5];
        patron[3][1] = true; patron[4][1] = true;
        patron[3][2] = true; patron[4][2] = true;
        patron[3][3] = true; patron[4][3] = true;
        return patron;
    }

    public static boolean[][] seisPack24() {
        boolean[][] patron = new boolean[5][5];
        patron[3][2] = true; patron[4][2] = true;
        patron[3][3] = true; patron[4][3] = true;
        patron[3][4] = true; patron[4][4] = true;
        return patron;
    }

    public static boolean[][] seisPack25() {
        boolean[][] patron = new boolean[5][5];
        patron[0][0] = true; patron[0][1] = true;
        patron[1][0] = true; patron[1][1] = true;
        patron[2][0] = true; patron[2][1] = true;
        return patron;
    }

    public static boolean[][] seisPack26() {
        boolean[][] patron = new boolean[5][5];
        patron[1][0] = true; patron[1][1] = true;
        patron[2][0] = true; patron[2][1] = true;
        patron[3][0] = true; patron[3][1] = true;
        return patron;
    }

    public static boolean[][] seisPack27() {
        boolean[][] patron = new boolean[5][5];
        patron[2][0] = true; patron[2][1] = true;
        patron[3][0] = true; patron[3][1] = true;
        patron[4][0] = true; patron[4][1] = true;
        return patron;
    }

    public static boolean[][] seisPack28() {
        boolean[][] patron = new boolean[5][5];
        patron[0][1] = true; patron[0][2] = true;
        patron[1][1] = true; patron[1][2] = true;
        patron[2][1] = true; patron[2][2] = true;
        return patron;
    }

    public static boolean[][] seisPack29() {
        boolean[][] patron = new boolean[5][5];
        patron[1][1] = true; patron[1][2] = true;
        patron[2][1] = true; patron[2][2] = true;
        patron[3][1] = true; patron[3][2] = true;
        return patron;
    }

    public static boolean[][] seisPack30() {
        boolean[][] patron = new boolean[5][5];
        patron[2][1] = true; patron[2][2] = true;
        patron[3][1] = true; patron[3][2] = true;
        patron[4][1] = true; patron[4][2] = true;
        return patron;
    }

    public static boolean[][] seisPack31() {
        boolean[][] patron = new boolean[5][5];
        patron[0][2] = true; patron[0][3] = true;
        patron[1][2] = true; patron[1][3] = true;
        patron[2][2] = true; patron[2][3] = true;
        return patron;
    }

    public static boolean[][] seisPack32() {
        boolean[][] patron = new boolean[5][5];
        patron[1][2] = true; patron[1][3] = true;
        patron[2][2] = true; patron[2][3] = true;
        patron[3][2] = true; patron[3][3] = true;
        return patron;
    }

    public static boolean[][] seisPack33() {
        boolean[][] patron = new boolean[5][5];
        patron[2][2] = true; patron[2][3] = true;
        patron[3][2] = true; patron[3][3] = true;
        patron[4][2] = true; patron[4][3] = true;
        return patron;
    }

    public static boolean[][] seisPack34() {
        boolean[][] patron = new boolean[5][5];
        patron[0][3] = true; patron[0][4] = true;
        patron[1][3] = true; patron[1][4] = true;
        patron[2][3] = true; patron[2][4] = true;
        return patron;
    }

    public static boolean[][] seisPack35() {
        boolean[][] patron = new boolean[5][5];
        patron[1][3] = true; patron[1][4] = true;
        patron[2][3] = true; patron[2][4] = true;
        patron[3][3] = true; patron[3][4] = true;
        return patron;
    }

    public static boolean[][] seisPack36() {
        boolean[][] patron = new boolean[5][5];
        patron[2][3] = true; patron[2][4] = true;
        patron[3][3] = true; patron[3][4] = true;
        patron[4][3] = true; patron[4][4] = true;
        return patron;
    }

    // Caja Pequeña (1 posible)
    public static boolean[][] cajaPequena() {
        boolean[][] patron = new boolean[5][5];
        patron[1][1] = true; patron[1][2] = true; patron[1][3] = true;
        patron[2][1] = true; patron[2][3] = true;
        patron[3][1] = true; patron[3][2] = true; patron[3][3] = true;
        return patron;
    }

    // Diamante (1 posible)
    public static boolean[][] diamante() {
        boolean[][] patron = new boolean[5][5];
        patron[0][2] = true;
        patron[1][1] = true; patron[1][3] = true;
        patron[2][0] = true; patron[2][4] = true;
        patron[3][1] = true; patron[3][3] = true;
        patron[4][2] = true;
        return patron;
    }

    // Método para generar patrones por número
    public static boolean[][] patronPorNumero(int numero) {
        switch(numero) {
            // Líneas Horizontales
            case 1: return lineaHorizontal(0);
            case 2: return lineaHorizontal(1);
            case 3: return lineaHorizontal(2);
            case 4: return lineaHorizontal(3);
            case 5: return lineaHorizontal(4);

            // Líneas Verticales
            case 6: return lineaVertical(0);
            case 7: return lineaVertical(1);
            case 8: return lineaVertical(2);
            case 9: return lineaVertical(3);
            case 10: return lineaVertical(4);

            // Diagonales
            case 11: return diagonalPrincipal();
            case 12: return diagonalSecundaria();

            // 6-Pack
            case 13: return seisPack13();
            case 14: return seisPack14();
            case 15: return seisPack15();
            case 16: return seisPack16();
            case 17: return seisPack17();
            case 18: return seisPack18();
            case 19: return seisPack19();
            case 20: return seisPack20();
            case 21: return seisPack21();
            case 22: return seisPack22();
            case 23: return seisPack23();
            case 24: return seisPack24();
            case 25: return seisPack25();
            case 26: return seisPack26();
            case 27: return seisPack27();
            case 28: return seisPack28();
            case 29: return seisPack29();
            case 30: return seisPack30();
            case 31: return seisPack31();
            case 32: return seisPack32();
            case 33: return seisPack33();
            case 34: return seisPack34();
            case 35: return seisPack35();
            case 36: return seisPack36();

            // Caja Pequeña
            case 37: return cajaPequena();

            // Diamante
            case 38: return diamante();
            default: throw new IllegalArgumentException("Patrón no válido");
        }
    }
}