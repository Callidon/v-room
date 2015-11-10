package fr.univnantes.vroom.tarifs

import org.scalatest.{BeforeAndAfter, FunSpec, Matchers}

/**
 * Cas de tests pour la classe Tarif
 */
class TarifSpec extends FunSpec with Matchers {

  describe("A concrete Tarif") {

    class TestTarif(code: Int, libelle: String, tarif: Double) extends Tarif(code, libelle, tarif);

    val tarif = new TestTarif(10, "Tarif de test", 50.0);

    it("should have his getters working") {
      tarif.code should be (10)
      tarif.libelle should be ("Tarif de test")
      tarif.tarif should be (50.0)
    }

    it("should have his setters working") {
      tarif.code = 11
      tarif.code should be (11)

      tarif.libelle = "Nouveau tarif de test"
      tarif.libelle should be ("Nouveau tarif de test")

      tarif.tarif = 50.5
      tarif.tarif should be (50.5)
    }

  }
}
