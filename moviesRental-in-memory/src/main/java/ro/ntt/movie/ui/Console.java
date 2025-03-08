package ro.ntt.movie.ui;

import ro.ntt.movie.model.Client;
import ro.ntt.movie.model.Movie;
import ro.ntt.movie.service.ClientService;
import ro.ntt.movie.service.MovieService;
import java.util.Scanner;

public class Console {
    private final MovieService moviesService;
    private final ClientService clientService;

    public Console(MovieService movieService, ClientService clientService) {
        this.moviesService = movieService;
        this.clientService = clientService;
    }
        public void runMenu () {
            printMenu();
//            loadData();

            Scanner scanner = new Scanner(System.in);

            while (true) {
                String option = scanner.next();
                if (option.equals("x")) {
                    System.out.println("Iesire din aplicatie");
                    break;
                }

                switch (option) {
                    case "1":
                        addMovie(scanner);
                        break;
                    case "2":
                        listMovies();
                        break;
                    case "3":
                        deleteMovie(scanner);
                        break;
                    case "4":
                        addClient(scanner);
                        break;
                    case "5":
                        listClients();
                        break;
                    case "6":
                        deleteClient(scanner);
                        break;
//                    case "7":
//                        showAllMoviesByGenre(scanner);
//                        break;
                    default:
                        System.out.println("Introduceti o optiune valida! ");
                }
                printMenu();
            }

        }


    private void addMovie(Scanner scanner) {

        System.out.println("\n====Adauga un film===");
        System.out.println("Introduceti ID-ul filmului.");
        Long id = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Introduceti numele filmului");
        String name = scanner.nextLine();
        System.out.println("Introduceti genul filmului");
        String genre = scanner.nextLine();
        System.out.println("Introduceti anul filmului");
        int year = scanner.nextInt();
        System.out.println("Introduceti rating-ul filmului");
        int rating = scanner.nextInt();


        Movie movie = new Movie(id, name, genre, year, rating);
        moviesService.save(movie);
        System.out.println("Filmult a fost adaugat cu succes!");

    }

    private void listMovies() {
        System.out.println("\n====Lista filme====");
        moviesService.findAll().forEach(System.out::println);

    }

    private void deleteMovie(Scanner scanner) {
        System.out.println("\n===Sterge in film===");
        System.out.println("Introduceti ID-ul filmului de sters: ");
        Long id = scanner.nextLong();
        Movie removed = moviesService.delete(id);
        if (removed == null) {
            System.out.println("Filmul cu id-ul: " + removed + " a fost sters cu succes!");
        } else {
            System.out.println("Filmul cu ID-ul introdus nu exista!");
        }

    }

    private void addClient(Scanner scanner) {
        System.out.println("\n===Adauga un client===");
        System.out.println("Introduceti id-ul clientului: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Introduceti numele clientului");
        String name = scanner.nextLine();
        System.out.println("Introduceti email-ul clientului");
        String email = scanner.nextLine();
        System.out.println("Introduceti tefelonul clientului");
        String phone = scanner.nextLine();

        Client client = new Client(id, name, email, phone);
        clientService.save(client);
    }

    private void listClients() {
        System.out.println("\n===Lita clienti===");
        clientService.findAll().forEach(System.out::println);
    }

    public void deleteClient(Scanner scanner) {
        System.out.println("\n===Sterge un client===");
        System.out.println("Introduceti ID-ul clientului de sters");
        Long id = scanner.nextLong();
        Client removed = clientService.delete(id);
        if (removed != null) {
            System.out.println("Clientul cu id-ul: " + removed + " a fost sters cu succes!");
        } else {
            System.out.println("Clientul cu ID-ul introdus, nu exista!");
        }
    }

//    public void showAllMoviesByGenre(Scanner scanner) {
//        System.out.println("\n===Afisare filme dupa gen===");
//        System.out.println("Introduceti gen filmului dorit: ");
//        String genre = scanner.next();
//        moviesService.findByGenre(genre).forEach(System.out::println);
//    }

    public void printMenu() {
        System.out.println("\n========Meniu principal========");
        System.out.println("1. Adauga un film");
        System.out.println("2. Afiseaza toate filmele");
        System.out.println("3. Sterge un film");
        System.out.println("4. Adauga client");
        System.out.println("5. Afiseaza toti clientii");
        System.out.println("6. Sterge un client");
        System.out.println("7. Filtrare filme dupa gen");
        System.out.println("x. Iesire");
        System.out.println("Alege optiune: ");
    }

//    private void loadData(){
//        moviesService.loadMovie();
//    }

}
