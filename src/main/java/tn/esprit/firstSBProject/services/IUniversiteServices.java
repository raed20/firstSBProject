package tn.esprit.firstSBProject.services;

import jakarta.transaction.Transactional;
import tn.esprit.firstSBProject.entities.Universite;

import java.util.List;

public interface IUniversiteServices {
    List<Universite> retrieveAllUniversities();
    Universite addUniversite(Universite u);
    Universite updateUniversite(Universite u);
    Universite retrieveUniversite(long idUniversite);

    Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite);

    @Transactional
    Universite desaffecterFoyerAUniversite(long idUniversite);
}
