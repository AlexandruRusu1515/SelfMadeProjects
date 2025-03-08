package ro.ntt.movie.service;

import ro.ntt.movie.model.Client;
import ro.ntt.movie.repository.RepositoryInterface;
import java.util.List;
import java.util.stream.Collectors;

public class ClientService implements ServiceInterface <Client, Long> {

    private final RepositoryInterface <Client, Long> clientRepository;

    public ClientService(RepositoryInterface<Client, Long> clientRepositoryDB) {
        this.clientRepository = clientRepositoryDB;
    }

    @Override
    public void save(Client client) {
        clientRepository.save(client);
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client delete(Long id) {
        return clientRepository.delete(id);
    }


//    public List<Client> emailFiltrer(String email) {
//        return clientRepository.findAll()
//                .stream()
//                .filter(client -> client.getEmail().contains(email))
//                .collect(Collectors.toList());
//    }
//
//    public void loadClients(){
//     clientRepository.save(new Client(1L, "Alexandru", "alexxrusu15@yahoo.com", "0763153066"));
//     clientRepository.save(new Client(2L, "Delia", "delia@gmail.com", "0731256860" ));
//     clientRepository.save(new Client(3L, "Florina", "florina@yahoo.com", "0743874591"));
//    }
}
