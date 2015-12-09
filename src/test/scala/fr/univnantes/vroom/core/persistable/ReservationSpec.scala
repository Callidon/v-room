package fr.univnantes.vroom.core.persistable

import fr.univnantes.vroom.TestsConstants
import fr.univnantes.vroom.core.persistable.materiel.{MaterielFixe, MaterielMobile}
import org.scalatest.{FunSpec, Matchers}

/**
  * Cas de tests pour la classe Reservation
  */
class ReservationSpec extends FunSpec with Matchers {
  describe("Reservation") {

    val reservation = TestsConstants.reservation.copy()

    describe("#calculerTarif") {

      it("should calculate the correct amount without any mobile furniture") {
        val amount = reservation.salle.calculerTarif() + reservation.demandeur.calculerTarif() + 15.0 + 60.0 + 15.0
        reservation.calculTarif() should be (amount)
      }

      it("should calculate the correct amount with some mobile furnitures") {
        val amount = reservation.salle.calculerTarif() + reservation.demandeur.calculerTarif() + 15.0 + 60.0 + 15.0
        val some_mobile = new MaterielMobile(15, "Meuble mobile", TestsConstants.tarif_materiel)
        val other_mobile = new MaterielMobile(16, "Autre meuble mobile", TestsConstants.tarif_materiel)

        reservation.addMateriel(some_mobile)
        reservation.calculTarif() should be (amount + 20.0)

        reservation.addMateriel(other_mobile)
        reservation.calculTarif() should be (amount + 40.0)
      }

      it("should calculate the correct amount with some rooms & some furnitures") {
        val amount = reservation.salle.calculerTarif() + reservation.demandeur.calculerTarif() + 15.0 + 60.0 + 15.0 + 40.0
        val first_materiel = new MaterielFixe(2, "Meuble standard", TestsConstants.tarif_materiel)
        val second_materiel = new MaterielFixe(3, "Autre meuble standard", TestsConstants.tarif_materiel)

        reservation.salle.addMateriel(first_materiel)
        reservation.calculTarif() should be (amount + 20.0)

        reservation.salle.addMateriel(second_materiel)
        reservation.calculTarif() should be (amount + 40.0)
      }
    }
  }
}
