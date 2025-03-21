package tn.esprit.firstSBProject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.firstSBProject.entities.Bloc;
import tn.esprit.firstSBProject.entities.Chambre;
import tn.esprit.firstSBProject.entities.Etudiant;
import tn.esprit.firstSBProject.entities.Reservation;
import tn.esprit.firstSBProject.repositories.IBlocRepository;
import tn.esprit.firstSBProject.repositories.IEtudiantRepository;
import tn.esprit.firstSBProject.repositories.IReservationRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReservationServicesImp implements IReservationServices{

    IReservationRepository reservationRepository;

    IBlocRepository blocRepository;
    IEtudiantRepository etudiantRepository;

    @Override
    public List<Reservation> retrieveAllReservation() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation updateReservation(Reservation res) {
        if (reservationRepository.existsById((long) res.getIdReservation())) {
            return reservationRepository.save(res);
        }
        return null;
    }

    @Override
    public Reservation retrieveReservation(Long idReservation) {
        return reservationRepository.findById(idReservation).orElse(null);
    }
    // Ajouter une réservation et l’affecter à une chambre et un étudiant
    public Reservation ajouterReservation(long idBloc, long cinEtudiant) {
        Optional<Bloc> blocOpt = blocRepository.findById(idBloc);
        Optional<Etudiant> etudiantOpt = etudiantRepository.findById(cinEtudiant);

        if (!blocOpt.isPresent()) {
            throw new RuntimeException("Bloc introuvable !");
        }
        if (!etudiantOpt.isPresent()) {
            throw new RuntimeException("Étudiant introuvable !");
        }

        Bloc bloc = blocOpt.get();
        Etudiant etudiant = etudiantOpt.get();
        Chambre chambre = bloc.getChambres().stream()
                .filter(ch -> ch.getReservations().size() < ch.getTypeChambre().getCapacite())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Aucune chambre disponible !"));

        Reservation reservation = new Reservation();
        reservation.setIdReservation(Integer.parseInt(chambre.getIdChambre() + "-" + bloc.getNomBloc() + "-" + java.time.Year.now()));
        reservation.setEstValide(true);
        reservation.setChambre(chambre);
        reservation.setEtudiant(etudiant);

        return reservationRepository.save(reservation);
    }
}
