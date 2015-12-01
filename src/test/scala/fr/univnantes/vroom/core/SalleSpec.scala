package fr.univnantes.vroom.core

import fr.univnantes.vroom.TestsConstants
import fr.univnantes.vroom.materiel.MaterielFixe
import fr.univnantes.vroom.tarifs.TarifMateriel
import org.scalatest.{Matchers, FunSpec}

/**
 * Cas de tests pour la classe salle
 */
class SalleSpec extends FunSpec with Matchers {

  describe("Salle") {

    val salle = TestsConstants.salle.copy()

    describe("#calculerTarif") {

      it("should calculate the correct amount without any furnitures") {
        salle.calculerTarif() should be (135.0)
      }

      it("should calculate the correct amount with some furnitures") {
        val first_materiel = new MaterielFixe(2, "Meuble standard", TestsConstants.tarif_materiel)
        val second_materiel = new MaterielFixe(3, "Autre meuble standard", TestsConstants.tarif_materiel)

        salle.addMateriel(first_materiel)
        salle.calculerTarif() should be (155.0)

        salle.addMateriel(second_materiel)
        salle.calculerTarif() should be (175.0)
      }
    }

  }

}
