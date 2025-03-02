package tn.esprit.firstSBProject.services;

import tn.esprit.firstSBProject.entities.Chambre;

import java.util.List;

public interface IChambreServices {
    List<Chambre> retrieveAllChambres();
    Chambre addChambre(Chambre c);
    Chambre updateChambre (Chambre c);
    Chambre retrieveChambre (long idChambre);

}
