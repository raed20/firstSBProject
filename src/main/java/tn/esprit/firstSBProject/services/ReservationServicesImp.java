package tn.esprit.firstSBProject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.firstSBProject.entities.Reservation;
import tn.esprit.firstSBProject.repositories.IReservationRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ReservationServicesImp implements IReservationServices{

    IReservationRepository reservationRepository;

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
}
