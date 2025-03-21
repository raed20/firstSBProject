package tn.esprit.firstSBProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.firstSBProject.entities.Reservation;
import tn.esprit.firstSBProject.entities.Universite;

import java.util.List;


@Repository
public interface IUniversiteRepository extends JpaRepository<Universite, Long> {
    @Query("SELECT u FROM Universite u WHERE u.nomUniversite = :nomUniversite")
    Universite findByNomUniversite(@Param("nomUniversite") String nomUniversite);


    @Query("UPDATE Universite u SET u.foyer = NULL WHERE u.idUniversite = :idUniversite")
    void desaffecterFoyer(@Param("idUniversite") long idUniversite);

    @Query("SELECT r FROM Reservation r " +
            "WHERE FUNCTION('YEAR', r.anneeUniversitaire) = :anneeUniversitaire " +
            "AND r.chambre.bloc.foyer.universite.nomUniversite = :nomUniversite")
    List<Reservation> findReservationsByAnneeAndUniversite(
            @Param("anneeUniversitaire") int anneeUniversitaire,
            @Param("nomUniversite") String nomUniversite);
}
