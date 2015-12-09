package fr.univnantes.vroom.control.add

import fr.univnantes.vroom.TestsConstants
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.BatimentDTO
import fr.univnantes.vroom.database.DataSource
import fr.univnantes.vroom.datacontroller.{DataManager, Mediator}
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
    val new_batiment = TestsConstants.batimentDTO.copy()

    mediator.registerManager("Batiment", batimentManager)

    describe("#execute") {

      it("should add a building with success") {
        val commande = new AjouterBatimentCommande(systeme, mediator, new_batiment)
        // paramatérage du mock
        (batimentManager.insert _).expects(*).returning()

        commande.execute()

        // récupération du batiment nouvellement inséré
        val predicat = (bat : BatimentDTO) => {
          bat.no_bat == new_batiment.no_bat
        }

        systeme.searchBatiment(predicat) should contain (new_batiment)
      }

      it("should ignore the insertion of a building already in the system") {
        val commande = new AjouterBatimentCommande(systeme, mediator, new_batiment)
        // paramatérage du mock
        (batimentManager.insert _).expects(*).returning().anyNumberOfTimes()

        commande.execute()
        commande.execute()

        // récupération du batiment nouvellement inséré
        val predicat = (bat : BatimentDTO) => {
          bat.no_bat == new_batiment.no_bat
        }

        systeme.searchBatiment(predicat).size should be (1)
      }
    }
  }
}

