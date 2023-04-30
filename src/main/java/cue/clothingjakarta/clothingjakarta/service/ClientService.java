package cue.clothingjakarta.clothingjakarta.service;

import cue.clothingjakarta.clothingjakarta.model.Client;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface ClientService {
    void addClient(Integer id, String name, String username, String password, String confirm_password, String email, String address) throws SQLException, ClassNotFoundException;
    List<Client> getClientList();
    Map<String, String> getErrores();
    void messageRegister(String name, String username, String password, String confirm_password, String email, String address) throws SQLException, ClassNotFoundException;

}
