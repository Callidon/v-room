package fr.univnantes.vroom.core

import fr.univnantes.vroom.TestsConstants
import fr.univnantes.vroom.core.{Batiment, Adresse}
import org.scalatest.{BeforeAndAfter, Matchers, FunSpec}

class SystemeSpec extends FunSpec with Matchers with BeforeAndAfter {

  describe("Systeme") {

    // création d'un système et ajout de quelques éléments
    val systeme = new Systeme()

    systeme.addSalle(TestsConstants.salle.copy())
    systeme.addReservation(TestsConstants.reservation.copy())
    systeme.addBatiment(TestsConstants.batiment.copy())
    systeme.addDemandeur(TestsConstants.demandeur.copy())
    systeme.addTarif(TestsConstants.tarif_salle)

    describe("#searchRservation") {

    }


  }

}


