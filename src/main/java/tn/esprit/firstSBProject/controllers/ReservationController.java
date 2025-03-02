package tn.esprit.firstSBProject.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstSBProject.entities.Reservation;
import tn.esprit.firstSBProject.services.IReservationServices;

import java.util.List;

@RestController
@RequestMapping("/reservation")
@AllArgsConstructor
public class ReservationController {
    IReservationServices reservationService;


    @GetMapping("/getAllReservations")
    public List<Reservation> retrieveAllReservations() {
        return reservationService.retrieveAllReservation();
    }


    @GetMapping("/getById/{id}")
    public Reservation retrieveReservation(@PathVariable("id") Long idReservation) {
        return reservationService.retrieveReservation(idReservation);
    }


    @PutMapping("/updateReservation/{id}")
    public Reservation updateReservation(@PathVariable("id") Long idReservation, @RequestBody Reservation reservation) {

        return reservationService.updateReservation(reservation);
    }
}
