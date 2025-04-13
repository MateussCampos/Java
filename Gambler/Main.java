package Gambler;

public class Main {

    protected static double lancarDados() {
        double d1 = (int) (Math.random() * 6) + 1;
        double d2 = (int) (Math.random() * 6) + 1;

        System.out.printf("\nVoce tirou %.0f e %.0f logo a soma será: %.0f", d1, d2, d1 + d2);
        System.out.println("\n=======================================================");
        return d1 + d2;
    }

    public static void main(String[] args) {

        double r = 0;
        double score;
        boolean back = true;

        System.out.println("===============GAMBLER=====================================");

        r = lancarDados();

        if (r == 7 || r == 11) {
            System.out.println("\nU Won!");
        }
        if (r == 2 || r == 3 || r == 12) {
            System.out.println("\nFU Loose!!!");

        }
        if (r == 4 || r == 5 || r == 6 || r == 8 || r == 9 || r == 10) {
            score = r;

            do {
                r = lancarDados();

                if (r == score) {
                    System.out.println("\n  U Won!");
                    back = false;
                }
                if (r != score && r != 7) {
                    System.out.println("\n  Você ainda não tirou seu score nos dados,\n logo terá de jogar novamente");
                }

                if (r == 7) {
                    System.out.println("\n  U Loose!!!");
                    back = false;

                }
            } while (back == true);
        }
    }
}
