package cue.clothingjakarta.clothingjakarta.service.impl;

import cue.clothingjakarta.clothingjakarta.repository.Repository;
import cue.clothingjakarta.clothingjakarta.repository.impl.ClientRepositoryImpl;
import cue.clothingjakarta.clothingjakarta.service.ClientService;
import cue.clothingjakarta.clothingjakarta.service.ClothingService;

import java.sql.SQLException;

public class SingletonServiceImpl {
    private final ClientService clientService;
    private final ClothingService clothingService;
    private final Repository repository;


    public SingletonServiceImpl() throws SQLException, ClassNotFoundException {
        this.clientService = (ClientService) new ClientServiceImpl();
        this.clothingService= (ClothingService) new ClothingServiceImpl();
        this.repository = (Repository) new ClientRepositoryImpl();
    }

    public ClientService getClientService() {return clientService;}

    public ClothingService getClothingService() {return clothingService;}
    public Repository getRepository(){return repository;}
}
