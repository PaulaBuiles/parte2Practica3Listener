package cue.clothingjakarta.clothingjakarta.repository.impl;

import cue.clothingjakarta.clothingjakarta.conexionBD.ConexionBaseDatos;
import cue.clothingjakarta.clothingjakarta.exception.ServiceJdbcException;
import cue.clothingjakarta.clothingjakarta.model.Client;
import cue.clothingjakarta.clothingjakarta.model.Clothing;
import cue.clothingjakarta.clothingjakarta.repository.Repository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.sql.Types.NULL;

public class ClientRepositoryImpl implements Repository<Clothing> {

    List<Client> productoList = new ArrayList<>();

    public ClientRepositoryImpl() throws SQLException, ClassNotFoundException {
    }

    public List<Client> getProductoList() {
        return productoList;
    }

    public void loadList() throws SQLException, ClassNotFoundException {
        this.productoList= list();
    }
    Connection conn = ConexionBaseDatos.getConnection();
    @Override
    public List<Client> list() throws SQLException, ClassNotFoundException {

        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * from usuarios")) {
            while (resultSet.next()){
                System.out.println(resultSet.getString("Name"));
                productoList.add(new Client(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("confirm_password"),
                        resultSet.getString("email"),
                        resultSet.getString("address")));
            }

        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
        return productoList;
    }
    @Override
    public Client byId(int id) {
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM usuarios")) {
            Client client = null;
            while (rs.next()) {
                if (id == rs.getInt("id")){
                    client = new Client(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("username"),
                            rs.getString("password"),
                            rs.getString("confirm_password"),
                            rs.getString("email"),
                            rs.getString("address"));
                }
            }
            return client;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void guardar(Client client) throws SQLException, ClassNotFoundException {
        try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO usuarios VALUES (?,?,?,?,?,?,?)");) {
            stmt.setInt(1, NULL);
            stmt.setString(2, client.getName());
            stmt.setString(3, client.getUsername());
            stmt.setString(4, client.getPassword());
            stmt.setString(5, client.getConfirm_password());
            stmt.setString(6, client.getEmail());
            stmt.setString(7, client.getAddress());
            stmt.executeUpdate();
            System.out.println("Guardado con exito");
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void eliminar(int id) throws SQLException, ClassNotFoundException {
        try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM usuarios WHERE id ="+ id);) {
            stmt.executeUpdate();
            System.out.println("Eliminado con exito");
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
