package fr.univnantes.vroom.core.tarifs

import org.scalatest.{FunSpec, Matchers}

/**
 * Cas de tests pour la classe Tarif
 */
class TarifSpec extends FunSpec with Matchers {

  describe("A concrete Tarif") {

    class TestTarif(code: Int, libelle: String, tarif: Double) extends Tarif(code, libelle, tarif)

    val tarif = new TestTarif(10, "Tarif de test", 50.0)

  }
}
