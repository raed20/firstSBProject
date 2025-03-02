package tn.esprit.firstSBProject.services;

import tn.esprit.firstSBProject.entities.Bloc;

import java.util.List;

public interface IBlocServices {
    List<Bloc> retrieveBlocs();
    Bloc updateBloc (Bloc bloc);
    Bloc addBloc (Bloc bloc);
    Bloc retrieveBloc (long idBloc);
    void removeBloc (long idBloc);

}
