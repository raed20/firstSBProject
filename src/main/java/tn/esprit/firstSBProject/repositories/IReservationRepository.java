package tn.esprit.firstSBProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.firstSBProject.entities.Reservation;
@Repository
public interface IReservationRepository  extends JpaRepository<Reservation, Long> {
}
