package tn.esprit.firstSBProject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.firstSBProject.entities.Etudiant;
import tn.esprit.firstSBProject.repositories.IEtudiantRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class EtudiantServicesImp implements  IEtudiantServices {
    IEtudiantRepository iEtudiantRepository;


    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return iEtudiantRepository.findAll();
    }

    @Override
    public List<Etudiant> addEtudiants(List<Etudiant> etudiants) {
        return iEtudiantRepository.saveAll(etudiants);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        if (iEtudiantRepository.existsById(e.getIdEtudiant())) {
            return iEtudiantRepository.save(e);
        }
        return null;
    }

    @Override
    public Etudiant retrieveEtudiant(long idEtudiant) {
        return iEtudiantRepository.findById(idEtudiant).orElse(null);
    }

    @Override
    public void removeEtudiant(long idEtudiant) {
        iEtudiantRepository.deleteById(idEtudiant);

    }
}
