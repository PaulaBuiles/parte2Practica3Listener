package cue.clothingjakarta.clothingjakarta.service.impl;

import cue.clothingjakarta.clothingjakarta.model.Client;
import cue.clothingjakarta.clothingjakarta.repository.Repository;
import cue.clothingjakarta.clothingjakarta.repository.impl.ClientRepositoryImpl;
import cue.clothingjakarta.clothingjakarta.service.ClientService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientServiceImpl implements ClientService {
    Repository clientRepository = new ClientRepositoryImpl();
    private final List<Client> clientList = new ArrayList<>();

    public ClientServiceImpl() throws SQLException, ClassNotFoundException {
    }

    public List<Client> getClientList() {return clientList;}
    private Map<String, String> errores = new HashMap<String, String>();

    public Map<String, String> getErrores() {return errores;}

    @Override
    public void addClient(Integer id, String name, String username, String password, String confirm_password, String email, String address) throws SQLException, ClassNotFoundException {
        clientList.add(new Client(id,name, username, password, confirm_password, email, address));

        clientRepository.list().add(new Client(id,name,username, password, confirm_password, email, address));
    }


    public void messageRegister(String name, String username, String password, String confirm_password, String email, String address) throws SQLException, ClassNotFoundException {
        errores.clear();
        if (name == null || name.isBlank()) {
            errores.put("name", "Es requirido poner el nombre");
        }
        if (username == null || username.isBlank()) {
            errores.put("username", "Es requirido poner un username");
        }
        if (email == null || !email.contains("@")) {
            errores.put("email", "Es requerido poner un email valido");
        }
        if (address == null || address.isBlank()) {
            errores.put("address", "Es requirido poner una direccion para la entrega");
        }
        if (password == null || password.isBlank()) {
            errores.put("password", "El password es requerido");
        }
        if (confirm_password == null || confirm_password.isBlank()) {
            errores.put("confirm_password", "Necesitas volver a confirmar tu contraseña");
        }/*if (confirm_password!=password){
        errores.put("confirm_password","No concuerda con la contraseña ");
    }*/
        if (errores.size() == 0) {
            addClient(null,name, username, password, confirm_password, email, address);
        }
    }
}
