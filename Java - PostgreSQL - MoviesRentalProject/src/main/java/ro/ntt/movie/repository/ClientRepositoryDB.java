package ro.ntt.movie.repository;

import ro.ntt.movie.model.Client;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientRepositoryDB implements RepositoryInterface <Client, Long> {
    @Override
    public void save(Client client) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO client (id, name, email, phone) VALUES (?,?,?,?)")) {
            preparedStatement.setLong(1, client.getId());
            preparedStatement.setString(2, client.getName());
            preparedStatement.setString(3, client.getEmail());
            preparedStatement.setString(4, client.getPhone());
            preparedStatement.executeUpdate();
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Client findById(Long id) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM client WHERE id = ?")) {
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Client(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("phone")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return null;
    }


    @Override
    public List<Client> findAll() {
        List<Client> clientList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM client")) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");

                Client client = new Client(id, name, email, phone);
                clientList.add(client);
            }
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException(e);
        }
        return clientList;
    }


    @Override
    public Client delete(Long id) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM client WHERE id = ?")) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public Client clientSearchPhone (String phone) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT FROM client WHERE phone = ?")) {
             preparedStatement.setString(1, phone);

             ResultSet resultSet = preparedStatement.executeQuery();
             if (resultSet.next()) {
                 return new Client(
                         resultSet.getLong("id"),
                         resultSet.getString("name"),
                         resultSet.getString("email"),
                         resultSet.getString("phone")
                 );
             }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
