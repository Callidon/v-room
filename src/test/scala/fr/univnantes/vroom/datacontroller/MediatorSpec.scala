package fr.univnantes.vroom.datacontroller

import java.util.Date

import fr.univnantes.vroom.TestsConstants
import org.scalatest.{BeforeAndAfter, Matchers, FunSpec}
import org.scalamock.scalatest.MockFactory

class MediatorSpec extends FunSpec with Matchers with BeforeAndAfter with MockFactory {

  describe("Mediator") {

    // création des mocks des DataManager
    val dummySource = mock[DataSource]

    class mockedManager extends DataManager(dummySource) {

      override def get(id: Int): Any = Some

      override def update(donnee: Any): Unit = print("dummy")

      override def insert(donnee: Any): Unit = print("dummy")

      override def delete(donnee: Any): Unit = print("dummy")

      override def getAll(): Set[_] = Set(Some)
    }

    val adresseManager = mock[mockedManager]
    val batimentManager = mock[mockedManager]
    val demandeurManager = mock[mockedManager]
    val reservationManager = mock[mockedManager]
    val salleManager = mock[mockedManager]

    // on crée le mediator
    val mediator = new Mediator()
    mediator.registerManager("Adresse", adresseManager)
    mediator.registerManager("Batiment", batimentManager)
    mediator.registerManager("Demandeur", demandeurManager)
    mediator.registerManager("Reservation", reservationManager)
    mediator.registerManager("Salle", salleManager)

    describe("#get") {

      it("should call the correct manager") {
        // TODO
      }

      it("should reject an object of unsupported type") {
        // TODO
      }
    }

    describe("#getAll") {

      it("should call the correct manager") {
        // TODO
      }

      it("should reject an object of unsupported type") {
        // TODO
      }
    }

    describe("#insert") {

      it("should call the correct manager") {
        // paramétrage des mocks pour la méthode insert
        (adresseManager.insert _).expects(*).returning()
        (batimentManager.insert _).expects(*).returning()
        (demandeurManager.insert _).expects(*).returning()
        (reservationManager.insert _).expects(*).returning()
        (salleManager.insert _).expects(*).returning()

        // appel des méthodes
        mediator.insert(TestsConstants.adresse)
        mediator.insert(TestsConstants.batiment)
        mediator.insert(TestsConstants.demandeur)
        mediator.insert(TestsConstants.reservation)
        mediator.insert(TestsConstants.salle)
      }

      it("should reject an object of unsupported type") {
        val unsupported = new Date()

        an [NoSuchElementException] should be thrownBy mediator.insert(unsupported)
      }
    }

    describe("#update") {

      it("should call the correct manager with the update operation") {
        // paramétrage des mocks pour la méthode update
        (adresseManager.update _).expects(*).returning()
        (batimentManager.update _).expects(*).returning()
        (demandeurManager.update _).expects(*).returning()
        (reservationManager.update _).expects(*).returning()
        (salleManager.update _).expects(*).returning()

        // appel des méthodes
        mediator.update(TestsConstants.adresse)
        mediator.update(TestsConstants.batiment)
        mediator.update(TestsConstants.demandeur)
        mediator.update(TestsConstants.reservation)
        mediator.update(TestsConstants.salle)
      }

      it("should reject an object of unsupported type") {
        val unsupported = new Date()

        an [NoSuchElementException] should be thrownBy mediator.update(unsupported)
      }
    }

    describe("#delete") {

      it("should call the correct manager with the delete operation") {
        // paramétrage des mocks pour la méthode delete
        (adresseManager.delete _).expects(*).returning()
        (batimentManager.delete _).expects(*).returning()
        (demandeurManager.delete _).expects(*).returning()
        (reservationManager.delete _).expects(*).returning()
        (salleManager.delete _).expects(*).returning()

        //appel des méthodes
        mediator.delete(TestsConstants.adresse)
        mediator.delete(TestsConstants.batiment)
        mediator.delete(TestsConstants.demandeur)
        mediator.delete(TestsConstants.reservation)
        mediator.delete(TestsConstants.salle)
      }

      it("should reject an object of unsupported type") {
        val unsupported = new Date()

        an [NoSuchElementException] should be thrownBy mediator.delete(unsupported)
      }
    }
  }
}

