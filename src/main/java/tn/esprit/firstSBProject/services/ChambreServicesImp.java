package tn.esprit.firstSBProject.services;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.firstSBProject.entities.Bloc;
import tn.esprit.firstSBProject.entities.Chambre;
import tn.esprit.firstSBProject.repositories.IBlocRepository;
import tn.esprit.firstSBProject.repositories.IChambreRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ChambreServicesImp implements IChambreServices {

    IChambreRepository chambreRepository;
    private IBlocRepository blocRepository;

    @Override
    public List<Chambre> retrieveAllChambres() {
        return (List<Chambre>) chambreRepository.findAll();
    }

    @Override
    public Chambre addChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public Chambre updateChambre(Chambre c) {
        if (chambreRepository.existsById(c.getIdChambre())) {
            return chambreRepository.save(c);
        }
        return null;
    }

    @Override
    public Chambre retrieveChambre(long idChambre) {
        return chambreRepository.findById(idChambre).orElse(null);
    }
    public Bloc affecterChambresABloc(List<Long> numChambres, long idBloc) {
        Optional<Bloc> blocOpt = blocRepository.findById(idBloc);
        if (!blocOpt.isPresent()) {
            throw new RuntimeException("Bloc introuvable !");
        }

        Bloc bloc = blocOpt.get();
        List<Chambre> chambres = (List<Chambre>) chambreRepository.findAllById(numChambres);

        for (Chambre chambre : chambres) {
            chambre.setBloc(bloc);
            chambreRepository.save(chambre);
        }
        return bloc;
    }
}
