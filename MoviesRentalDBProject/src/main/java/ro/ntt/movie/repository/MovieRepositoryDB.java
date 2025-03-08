package ro.ntt.movie.repository;

import ro.ntt.movie.model.Movie;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieRepositoryDB implements RepositoryInterface <Movie, Long> {
    @Override
    public void save(Movie movie) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO movie (id, name, genre, year, rating ) VALUES (?,?,?,?,?)")) {
            preparedStatement.setLong(1, movie.getId());
            preparedStatement.setString(2, movie.getName());
            preparedStatement.setString(3, movie.getGenre());
            preparedStatement.setInt(4, movie.getYear());
            preparedStatement.setInt(5, movie.getRating());
            preparedStatement.executeUpdate();
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Movie findById(Long id) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM movie WHERE id = ?")) {
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Movie(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("genre"),
                        resultSet.getInt("year"),
                        resultSet.getInt("rating")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return null;
    }

    @Override
    public List<Movie> findAll() {
        List<Movie> movieList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM movie")) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String genre = resultSet.getString("genre");
                int year = resultSet.getInt("year");
                int rating = resultSet.getInt("rating");

                Movie movie = new Movie(id, name, genre, year, rating);
                movieList.add(movie);
            }
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException(e);
        }
        return movieList;
    }

    @Override
    public Movie delete(Long id) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM movie WHERE id = ?")) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<Movie> movieSearchGenre (String genre) {
        List<Movie> movieList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM movie WHERE genre = ?")) {
            preparedStatement.setString(1, genre);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                movieList.add(new Movie(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("genre"),
                        resultSet.getInt("year"),
                        resultSet.getInt("rating")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return movieList;
    }
}

