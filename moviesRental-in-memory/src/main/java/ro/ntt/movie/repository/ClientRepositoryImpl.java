package ro.ntt.movie.repository;

import java.util.ArrayList;
import java.util.List;
import ro.ntt.movie.model.Client;

public class ClientRepositoryImpl implements RepositoryInterface <Client, Long> {


    private final List<Client> clientList = new ArrayList<>();
    @Override
    public void save(Client client) {
        clientList.add(client);
    }

    @Override
    public Client findById(Long id) {
         return clientList.stream()
                 .filter(client -> client.getId().equals(id))
                 .findFirst()
                 .orElse(null);
    }


    @Override
    public List<Client> findAll() {
        return new ArrayList<>(clientList);
    }

    @Override
    public Client delete(Long id) {
        Client client = findById(id);
        clientList.remove(client);
        return client;
    }
}
