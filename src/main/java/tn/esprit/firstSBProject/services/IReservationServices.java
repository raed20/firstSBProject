package tn.esprit.firstSBProject.services;

import tn.esprit.firstSBProject.entities.Reservation;

import java.util.List;

public interface IReservationServices {
    List<Reservation> retrieveAllReservation();
    Reservation updateReservation (Reservation res);
    Reservation retrieveReservation (Long idReservation);
}
