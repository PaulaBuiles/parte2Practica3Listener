package cue.clothingjakarta.clothingjakarta.repository;

import cue.clothingjakarta.clothingjakarta.model.Client;

import java.sql.SQLException;
import java.util.List;

public interface Repository<T> {
    List<Client> list() throws SQLException, ClassNotFoundException;
     void loadList() throws SQLException, ClassNotFoundException;
    List<Client> getProductoList();
    Client byId(int id) throws SQLException;
     void guardar(Client client) throws SQLException, ClassNotFoundException;

    void eliminar(int id) throws SQLException, ClassNotFoundException;

}
