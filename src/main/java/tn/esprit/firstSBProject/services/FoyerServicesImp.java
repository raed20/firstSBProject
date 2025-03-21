package tn.esprit.firstSBProject.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.firstSBProject.entities.Bloc;
import tn.esprit.firstSBProject.entities.Universite;
import tn.esprit.firstSBProject.repositories.IBlocRepository;
import tn.esprit.firstSBProject.repositories.IUniversiteRepository;
import tn.esprit.firstSBProject.services.IFoyerServices;
import tn.esprit.firstSBProject.entities.Foyer;
import tn.esprit.firstSBProject.repositories.IChambreRepository;
import tn.esprit.firstSBProject.repositories.IFoyerRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FoyerServicesImp implements IFoyerServices {

    IFoyerRepository foyerRepository;
    IChambreRepository chambreRepository;
    IUniversiteRepository universiteRepository;
    IBlocRepository blocRepository;
    @Override
    public Foyer findById(long id) {
        return foyerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Foyer> findAll() {
        return (List<Foyer>) foyerRepository.findAll();
    }

    @Override
    public Foyer save(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public void delete(Long id) {
        foyerRepository.deleteById(id);
    }

    @Override
    public Foyer getNomCapacite(String nom, Long capacite) {
        return foyerRepository.findByNomFoyerAndCapaciteFoyer(nom, capacite);
    }

    @Override
    public List<Foyer> retrieveAllFoyers() {
        return List.of();
    }

    @Override
    public Foyer addFoyer(Foyer f)
    {
        return foyerRepository.save(f);
    }


    @Override
    public Foyer updateFoyer(Foyer f) {
        if (foyerRepository.existsById(f.getIdFoyer())) {
            return foyerRepository.save(f);
        }
        return null;
    }

    @Override
    public Foyer retrieveFoyer(long idFoyer) {
        return foyerRepository.findById(idFoyer).orElse(null);
    }

    @Override
    public void removeFoyer(long idFoyer) {

        foyerRepository.deleteById(idFoyer);
    }
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        Optional<Universite> universiteOpt = universiteRepository.findById(idUniversite);
        if (!universiteOpt.isPresent()) {
            throw new RuntimeException("Université introuvable !");
        }

        Universite universite = universiteOpt.get();
        foyer.setUniversite(universite);
        foyer = foyerRepository.save(foyer);

        for (Bloc bloc : foyer.getBlocs()) {
            bloc.setFoyer(foyer);
            blocRepository.save(bloc);
        }
        return foyer;
    }

}
