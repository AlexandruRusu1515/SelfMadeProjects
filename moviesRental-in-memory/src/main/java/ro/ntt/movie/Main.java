package ro.ntt.movie;
import ro.ntt.movie.model.Client;
import ro.ntt.movie.model.Movie;
import ro.ntt.movie.repository.*;
import ro.ntt.movie.service.ClientService;
import ro.ntt.movie.service.MovieService;
import ro.ntt.movie.ui.Console;

public class Main {
    public static void main(String[] args) {

        RepositoryInterface <Client, Long> clientRepository = new ClientRepositoryDB();
        ClientService clientService = new ClientService(clientRepository);

        RepositoryInterface <Movie, Long> movieRepository = new MovieRepositoryDB();
        MovieService movieService = new MovieService(movieRepository);

        Console console = new Console(movieService, clientService);
        console.runMenu();

        System.out.println("Bye!");

    }

}