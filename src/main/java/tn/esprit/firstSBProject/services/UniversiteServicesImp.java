package tn.esprit.firstSBProject.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.firstSBProject.entities.Foyer;
import tn.esprit.firstSBProject.entities.Universite;
import tn.esprit.firstSBProject.repositories.IFoyerRepository;
import tn.esprit.firstSBProject.repositories.IUniversiteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UniversiteServicesImp implements IUniversiteServices {

    @Autowired
    IUniversiteRepository universiteRepository;
    @Autowired
   IFoyerRepository foyerRepository;

    @Override
    public List<Universite> retrieveAllUniversities() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        if (universiteRepository.existsById(u.getIdUniversite())) {
            return universiteRepository.save(u);
        }
        return null;
    }

    @Override
    public Universite retrieveUniversite(long idUniversite) {
        return universiteRepository.findById(idUniversite).orElse(null);
    }

    @Override
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Optional<Foyer> foyer = foyerRepository.findById(idFoyer);
        if (foyer.isEmpty()) {
            throw new RuntimeException(" Foyer introuvable !");
        }
        Foyer foyerr = foyer.get();

        // Récupérer l'université par son nom
        Universite universite = universiteRepository.findByNomUniversite(nomUniversite);
        if (universite == null) {
            throw new RuntimeException("Université introuvable !");
        }

        // Affecter le foyer à l'université // universite : MASTER et foyer : slave => universite.setFoyer
        universite.setFoyer(foyerr);
        return universiteRepository.save(universite);
    }


    @Transactional
    @Override
    public Universite desaffecterFoyerAUniversite(long idUniversite) {
        universiteRepository.desaffecterFoyer(idUniversite);
        return universiteRepository.findById(idUniversite).orElse(null);
    }
}