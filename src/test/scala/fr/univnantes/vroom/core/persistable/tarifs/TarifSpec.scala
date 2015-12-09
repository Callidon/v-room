package fr.univnantes.vroom.core.persistable.tarifs

import org.scalatest.{FunSpec, Matchers}

/**
 * Cas de tests pour la classe Tarif
 */
class TarifSpec extends FunSpec with Matchers {

  describe("A concrete Tarif") {

    val tarif = new TarifSalle(10, "Tarif de test", 50.0)

  }
}
