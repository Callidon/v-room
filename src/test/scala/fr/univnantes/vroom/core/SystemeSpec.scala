package fr.univnantes.vroom.core

import fr.univnantes.vroom.TestsConstants
import fr.univnantes.vroom.core.tarifs.Tarif
import org.scalatest.{FunSpec, Matchers}

/**
  * Cas de tests pour la classe Systeme
  */
class SystemeSpec extends FunSpec with Matchers {

  describe("Systeme") {

    // création d'un système et ajout de quelques éléments
    val systeme = new Systeme()

    val salle = TestsConstants.salle.copy()
    val reservation = TestsConstants.reservation.copy()
    val batiment = TestsConstants.batiment.copy()
    val demandeur = TestsConstants.demandeur.copy()
    val tarif = TestsConstants.tarif_salle

    systeme.addSalle(salle)
    systeme.addReservation(reservation)
    systeme.addBatiment(batiment)
    systeme.addDemandeur(demandeur)
    systeme.addTarif(tarif)

    describe("#searchReservation") {

      it("can perform a search with success") {
        val predicat = (reserv : Reservation) => {
          reserv.montant >= 14.0
        }

        systeme.searchReservation(predicat) should contain (reservation)
      }
    }

    describe("#searchSalle") {

      it("can perform a search with success") {
        val predicat = (salle : Salle) => {
          salle.superficie == 60
        }

        systeme.searchSalle(predicat) should contain (salle)
      }
    }

    describe("#searchBatiment") {

      it("can perform a search with success") {
        val predicat = (batiment: Batiment) => {
          batiment.nom.equals("Salle des sports")
        }

        systeme.searchBatiment(predicat) should contain (batiment)
      }
    }

    describe("#searchDemandeur") {

      it("can perform a search with success") {
        val predicat = (demandeur: Demandeur) => {
          demandeur.no_dem == 10
        }

        systeme.searchDemandeur(predicat) should contain (demandeur)
      }
    }

    describe("#searchTarif") {

      it("can perform a search with success") {
        val predicat = (tarif: Tarif) => {
          tarif.tarif >= 130.0
        }

        systeme.searchTarif(predicat) should contain (tarif)
      }
    }


  }

}


