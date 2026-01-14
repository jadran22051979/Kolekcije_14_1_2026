import java.util.ArrayList;
import java.util.Scanner;

public class EvidencijaPolaznika {

    public static void main(String[] args) {
        ArrayList<Polaznik> polaznici = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int izborKorisnika;

        do {
            //Izbornik
            System.out.print("Odaberite opciju za unos u Evidenciju polaznika: \n");
            System.out.println("0. Izlaz");
            System.out.println("1. Unos novog polaznika");
            System.out.println("2. Ispis svih polaznika");
            System.out.println("3. Pretraživanje po e-mailu");
            //Spremanje korisnikova izbora
            izborKorisnika = scanner.nextInt();
            scanner.nextLine();

            switch (izborKorisnika) {
                case 1:
                    System.out.print("Unesite ime novog polaznika: ");
                    String ime = scanner.nextLine();

                    System.out.print("Unesite prezime novog polaznika: ");
                    String prezime = scanner.nextLine();

                    System.out.print("Unesite e-mail novog polaznika: ");
                    String unesenEmail = scanner.nextLine();
                    //Dodatna provjera da li korisnik postoji preko emaila
                    boolean postoji = false;
                    for (Polaznik p : polaznici) {
                        if (p.getEmail().equalsIgnoreCase(unesenEmail)) {
                            postoji = true;
                            break;
                        }
                    }

                    if (postoji) {
                        System.out.println("Polaznik s tim e-mailom već postoji!");
                    } else {
                        polaznici.add(new Polaznik(ime, prezime, unesenEmail));
                        System.out.println("Polaznik je uspješno dodan.");
                    }

                    break;

                case 2:
                    System.out.println("\nPopis polaznika:");
                    if (polaznici.isEmpty()) {
                        System.out.println("Nema unesenih polaznika.");
                    } else {
                        for (Polaznik p : polaznici) {
                            System.out.println(p);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Unesite e-mail za pretraživanje: ");
                    String trazeniEmail = scanner.nextLine();
                    boolean pronaden = false;

                    for (Polaznik p : polaznici) {
                        if (p.getEmail().equalsIgnoreCase(trazeniEmail)) {
                            System.out.println("Pronađen polaznik: " + p);
                            pronaden = true;
                            break;
                        }
                    }

                    if (!pronaden) {
                        System.out.println("Polaznik s navedenim e-mailom ne postoji.");
                    }
                    break;

                case 0:
                    System.out.println("Izlaz iz programa.");
                    break;

                default:
                    System.out.println("Neispravan odabir.");
            }

        } while (izborKorisnika != 0);

        scanner.close();
    }
}
