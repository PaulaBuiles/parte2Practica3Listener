package cue.clothingjakarta.clothingjakarta.service;

import cue.clothingjakarta.clothingjakarta.model.Clothing;

import java.util.List;

public interface ClothingService {
    void addFood(String name, Double price);
    List<Clothing> getClothingList();
   }
