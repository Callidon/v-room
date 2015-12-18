package fr.univnantes.vroom.core

import fr.univnantes.vroom.TestsConstants
import fr.univnantes.vroom.core.dto.tarifs.{TarifDTO, TarifSalleDTO}
import fr.univnantes.vroom.core.dto.{BatimentDTO, DemandeurDTO, ReservationDTO, SalleDTO}
import org.scalatest.{FunSpec, Matchers}

/**
  * Cas de tests pour la classe Systeme
  */
class SystemeSpec extends FunSpec with Matchers {

  describe("Systeme") {

    // création d'un système et ajout de quelques éléments
    val systeme = new Systeme()

    val salle = TestsConstants.salleDTO.copy()
    val reservation = TestsConstants.reservationDTO.copy()
    val batiment = TestsConstants.batimentDTO.copy()
    val demandeur = TestsConstants.demandeurDTO.copy()
    val tarif = TestsConstants.tarif_salleDTO

    systeme.addSalle(salle)
    systeme.addReservation(reservation)
    systeme.addBatiment(batiment)
    systeme.addDemandeur(demandeur)
    systeme.addTarif(tarif)

    describe("#searchReservation") {

      it("can perform a search with success") {
        val predicat = (reserv : ReservationDTO) => {
          reserv.montant >= 14.0
        }

        systeme.searchReservation(predicat) should contain (reservation)
      }
    }

    describe("#searchSalle") {

      it("can perform a search with success") {
        val predicat = (salle : SalleDTO) => {
          salle.superficie == 60
        }

        systeme.searchSalle(predicat) should contain (salle)
      }
    }

    describe("#searchBatiment") {

      it("can perform a search with success") {
        val predicat = (batiment: BatimentDTO) => {
          batiment.nom.equals("Salle des sports")
        }

        systeme.searchBatiment(predicat) should contain (batiment)
      }
    }

    describe("#searchDemandeur") {

      it("can perform a search with success") {
        val predicat = (demandeur: DemandeurDTO) => {
          demandeur.no_dem == 9
        }

        systeme.searchDemandeur(predicat) should contain (demandeur)
      }
    }

    describe("#searchTarif") {

      it("can perform a search with success") {
        val predicat = (tarif: TarifDTO) => {
          tarif.tarif >= 130.0 && tarif.isInstanceOf[TarifSalleDTO]
        }

        systeme.searchTarif(predicat) should contain (tarif)
      }
    }
  }
}


