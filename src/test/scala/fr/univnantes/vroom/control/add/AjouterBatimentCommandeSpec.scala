package fr.univnantes.vroom.control.add

import fr.univnantes.vroom.TestsConstants
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.persistable.Batiment
import fr.univnantes.vroom.datacontroller.{DataManager, DataSource, Mediator}
import org.scalamock.scalatest.MockFactory
import org.scalatest.{FunSpec, Matchers}

/**
  * Cas de tests pour la classe AjouterBatimentCommande
  */
class AjouterBatimentCommandeSpec extends FunSpec with Matchers with MockFactory {

  describe("AjouterBatimentCommande") {

    // création des mocks des DataManager
    val dummySource = mock[DataSource]

    abstract class mockedManager extends DataManager(dummySource)
    val batimentManager = mock[mockedManager]

    // on crée le mediator
    val systeme = new Systeme()
    val mediator = new Mediator()
    mediator.registerManager("Batiment", batimentManager)

    describe("#execute") {

      it("should add a building with success") {
        val new_batiment = TestsConstants.batiment.copy()
        val commande = new AjouterBatimentCommande(systeme, mediator, new_batiment)
        // paramatérage du mock
        (batimentManager.insert _).expects(*).returning()

        commande.execute()

        // récupération du batiment nouvellement inséré
        val predicat = (bat : Batiment) => {
          bat.no_bat == 10
        }

        systeme.searchBatiment(predicat) should contain (new_batiment)
      }

      it("should ignore the insertion of a building already in the system") {
        val new_batiment = TestsConstants.batiment.copy()
        val commande = new AjouterBatimentCommande(systeme, mediator, new_batiment)
        // paramatérage du mock
        (batimentManager.insert _).expects(*).returning().anyNumberOfTimes()

        commande.execute()
        commande.execute()

        // récupération du batiment nouvellement inséré
        val predicat = (bat : Batiment) => {
          bat.no_bat == 10
        }

        systeme.searchBatiment(predicat).size should be (1)
      }
    }
  }
}

