package tn.esprit.firstSBProject.services;

import tn.esprit.firstSBProject.entities.Foyer;

import java.util.List;

public interface IFoyerServices {

    public Foyer findById(long id);
    public List<Foyer> findAll();
    public Foyer save(Foyer foyer);
    public void delete(Long id);
    public Foyer getNomCapacite(String nom, Long capacite);
    List<Foyer> retrieveAllFoyers();
    Foyer addFoyer (Foyer f);
    Foyer updateFoyer (Foyer f);
    Foyer retrieveFoyer (long idFoyer);
    void removeFoyer (long idFoyer);


}
