import java.util.Scanner;

public class LatvianTaxCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Iegūstam datus no lietotāja
        System.out.println("Algu nodokļa kalkulators (Latvija)");
        System.out.print("Ievadiet savu algu: ");
        double alga = scanner.nextDouble();

        // Aprēķina nodokli
        double ienakumaNodoklis = aprekinatIenakumaNodokli(alga);
        double sociālieIeguldījumi = aprekinatSocialosIeguldījumus(alga);
        double kopējaisNodoklis = ienakumaNodoklis + sociālieIeguldījumi;

        // Izvada rezultātus
        System.out.println("\nRezultāti:");
        System.out.println("Alga: €" + alga);
        System.out.println("Ieņēmumu nodoklis: €" + ienakumaNodoklis);
        System.out.println("Sociālie ieguldījumi: €" + sociālieIeguldījumi);
        System.out.println("Kopējais nodoklis: €" + kopējaisNodoklis);
        System.out.println("Tīrā alga: €" + (alga - kopējaisNodoklis));

        scanner.close();
    }

    // Aprēķina ieņēmumu nodokli
    private static double aprekinatIenakumaNodokli(double alga) {
        // Pieņemam fiksētu ieņēmumu nodokļa likmi kā piemēru
        double nodokļaLikme = 0.21;
        double standartaIzņemums = 500.0; // Standarta izņēmumi

        // Aprēķina ieņēmumu nodokli
        double ienakumaNodoklis = (alga - standartaIzņemums) * nodokļaLikme;

        // Pārbauda uz negatīvo nodokli
        return Math.max(ienakumaNodoklis, 0);
    }

    // Aprēķina sociālos ieguldījumus
    private static double aprekinatSocialosIeguldījumus(double alga) {
        // Pieņemam fiksētu procentuālo sociālo ieguldījumu kā piemēru
        double socialoIeguldijumuLikme = 0.1;
        return alga * socialoIeguldijumuLikme;
    }
}
