package fr.univnantes.vroom.control.add

import fr.univnantes.vroom.TestsConstants
import fr.univnantes.vroom.control.delete.AnnulerReservationCommande
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.ReservationDTO
import fr.univnantes.vroom.database.DataSource
import fr.univnantes.vroom.datacontroller.{DataManager, Mediator}
import org.scalamock.scalatest.MockFactory
import org.scalatest.{FunSpec, Matchers}

/**
  * Cas de tests pour la classe AnnulerReservationCommande
  */
class AnnulerReservationCommandeSpec extends FunSpec with Matchers with MockFactory {

  describe("AnnulerReservationCommande") {

    // création des mocks des DataManager
    val dummySource = mock[DataSource]

    abstract class mockedManager extends DataManager(dummySource)
    val reservationManager = mock[mockedManager]

    // on crée le mediator
    val systeme = new Systeme()
    val mediator = new Mediator()
    val reservation = TestsConstants.reservationDTO.copy()
    mediator.registerManager("Reservation", reservationManager)

    describe("#execute") {

      it("should suppress a reservation with success") {
        val commande = new AnnulerReservationCommande(systeme, mediator, reservation)
        // paramatérage du mock
        (reservationManager.delete _).expects(*).returning()

        // ajout d'une réservation
        systeme.addReservation(reservation)

        commande.execute()

        // récupération de la réservation nouvellement inséré
        val predicat = (reserv : ReservationDTO) => {
          reserv.ref_resa == reservation.ref_resa
        }

        systeme.searchReservation(predicat) should not contain (reservation)
      }

      it("should ignore the suppression of an inexisting reservation") {
        val commande = new AnnulerReservationCommande(systeme, mediator, reservation)
        // paramatérage du mock
        (reservationManager.delete _).expects(*).returning().anyNumberOfTimes()

        // ajout d'une réservation
        systeme.addReservation(reservation)

        commande.execute()
        commande.execute()

        // récupération de la réservation nouvellement inséré
        val predicat = (reserv : ReservationDTO) => {
          reserv.ref_resa == reservation.ref_resa
        }

        systeme.searchReservation(predicat) should not contain (reservation)
      }
    }
  }
}
