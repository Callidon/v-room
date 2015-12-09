package fr.univnantes.vroom.datacontroller

import fr.univnantes.vroom.TestsConstants
import fr.univnantes.vroom.core.dto.tarifs.TarifDureeDTO
import fr.univnantes.vroom.database.DataSource
import org.scalamock.scalatest.MockFactory
import org.scalatest.{FunSpec, Matchers}

/**
  * Cas de tests pour la classe Mediator
  */
class MediatorSpec extends FunSpec with Matchers with MockFactory {

  describe("Mediator") {

    // création des mocks des DataManager
    val dummySource = mock[DataSource]

    abstract class mockedManager extends DataManager(dummySource)

    val adresseManager = mock[mockedManager]
    val batimentManager = mock[mockedManager]

    // on crée le mediator
    val mediator = new Mediator()
    mediator.registerManager("Adresse", adresseManager)
    mediator.registerManager("Batiment", batimentManager)

    describe("#get") {

      it("should call the correct manager") {
        // paramétrage des mocks pour la méthode insert
        (adresseManager.get _).expects(*)
        (batimentManager.get _).expects(*)

        // appel des méthodes
        mediator.get(10, "Adresse")
        mediator.get(10, "Batiment")
      }

      it("should reject an object of an unsupported type") {
        an [NoSuchElementException] should be thrownBy mediator.get(10, "Tarif")
      }
    }

    describe("#getAll") {

      it("should call the correct manager") {
        // paramétrage des mocks pour la méthode insert
        (adresseManager.getAll _).expects()
        (batimentManager.getAll _).expects()

        // appel des méthodes
        mediator.getAll("Adresse")
        mediator.getAll("Batiment")
      }

      it("should reject an object of an unsupported type") {
        an [NoSuchElementException] should be thrownBy mediator.getAll("Date")
      }
    }

    describe("#insert") {

      it("should call the correct manager") {
        // paramétrage des mocks pour la méthode insert
        (adresseManager.insert _).expects(*).returning()
        (batimentManager.insert _).expects(*).returning()

        // appel des méthodes
        mediator.insert(TestsConstants.adresseDTO)
        mediator.insert(TestsConstants.batimentDTO)
      }

      it("should reject an object of an unsupported type") {
        val unsupported = new TarifDureeDTO(1, "Tarif non supporté", 15.0)

        an [NoSuchElementException] should be thrownBy mediator.insert(unsupported)
      }
    }

    describe("#update") {

      it("should call the correct manager with the update operation") {
        // paramétrage des mocks pour la méthode update
        (adresseManager.update _).expects(*).returning()
        (batimentManager.update _).expects(*).returning()

        // appel des méthodes
        mediator.update(TestsConstants.adresseDTO)
        mediator.update(TestsConstants.batimentDTO)
      }

      it("should reject an object of an unsupported type") {
        val unsupported = new TarifDureeDTO(1, "Tarif non supporté", 15.0)

        an [NoSuchElementException] should be thrownBy mediator.update(unsupported)
      }
    }

    describe("#delete") {

      it("should call the correct manager with the delete operation") {
        // paramétrage des mocks pour la méthode delete
        (adresseManager.delete _).expects(*).returning()
        (batimentManager.delete _).expects(*).returning()

        //appel des méthodes
        mediator.delete(TestsConstants.adresseDTO)
        mediator.delete(TestsConstants.batimentDTO)
      }

      it("should reject an object of an unsupported type") {
        val unsupported = new TarifDureeDTO(1, "Tarif non supporté", 15.0)

        an [NoSuchElementException] should be thrownBy mediator.delete(unsupported)
      }
    }
  }
}

