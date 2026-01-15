import java.util.ArrayList;
import java.util.Scanner;

public class EvidencijaPolaznika {

    public static void main(String[] args) {
        ArrayList<Polaznik> polaznici = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int izborKorisnika;

        do {
            ispisiIzbornik();
            izborKorisnika = ucitajIzbor(scanner);

            switch (izborKorisnika) {
                case 1:
                    unosNovogPolaznika(polaznici, scanner);
                    break;
                case 2:
                    ispisiSvePolaznike(polaznici);
                    break;
                case 3:
                    pretraziPoEmailu(polaznici, scanner);
                    break;
                case 0:
                    izlazIzPrograma();
                    break;
                default:
                    ispisiGresku();
            }

        } while (izborKorisnika != 0);

        scanner.close();
    }

    //Za svaku radnju je dodana metoda

    private static void ispisiIzbornik() {
        System.out.println("\nOdaberite opciju:");
        System.out.println("0. Izlaz");
        System.out.println("1. Unos novog polaznika");
        System.out.println("2. Ispis svih polaznika");
        System.out.println("3. Pretraživanje po e-mailu");
    }

    private static int ucitajIzbor(Scanner scanner) {
        System.out.print("Vaš izbor iz izbornika je: ");
        int izbor = scanner.nextInt();
        scanner.nextLine();
        return izbor;
    }

    private static void unosNovogPolaznika(ArrayList<Polaznik> polaznici, Scanner scanner) {
        System.out.print("Unesite ime Polaznika: ");
        String ime = scanner.nextLine();

        System.out.print("Unesite Prezime Polaznika : ");
        String prezime = scanner.nextLine();

        System.out.print("Unesite e-mail Polaznika: ");
        String email = scanner.nextLine();

        if (emailPostoji(polaznici, email)) {
            System.out.println("Polaznik s tim e-mailom već postoji!");
        } else {
            polaznici.add(new Polaznik(ime, prezime, email));
            System.out.println("Polaznik je uspješno dodan.");
        }
    }

    private static boolean emailPostoji(ArrayList<Polaznik> polaznici, String email) {
        for (Polaznik p : polaznici) {
            if (p.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }

    private static void ispisiSvePolaznike(ArrayList<Polaznik> polaznici) {
        System.out.println("\nPopis polaznika:");
        if (polaznici.isEmpty()) {
            System.out.println("Nema unesenih polaznika.");
            return;
        }

        for (Polaznik p : polaznici) {
            System.out.println(p);
        }
    }

    private static void pretraziPoEmailu(ArrayList<Polaznik> polaznici, Scanner scanner) {
        if (polaznici.isEmpty()) {
            System.out.println("Nema unesenih polaznika.");
            return;
        }

        System.out.print("Unesite e-mail za pretraživanje: ");
        String trazeniEmail = scanner.nextLine();

        Polaznik pronadeni = pronadiPoEmailu(polaznici, trazeniEmail);

        if (pronadeni != null) {
            System.out.println("Pronađen polaznik: " + pronadeni);
        } else {
            System.out.println("Polaznik s navedenim e-mailom ne postoji.");
        }
    }

    private static Polaznik pronadiPoEmailu(ArrayList<Polaznik> polaznici, String email) {
        for (Polaznik p : polaznici) {
            if (p.getEmail().equalsIgnoreCase(email)) {
                return p;
            }
        }
        return null;
    }

    private static void izlazIzPrograma() {
        System.out.println("Izlaz iz programa.");
    }

    private static void ispisiGresku() {
        System.out.println("Neispravan odabir.");
    }
}
