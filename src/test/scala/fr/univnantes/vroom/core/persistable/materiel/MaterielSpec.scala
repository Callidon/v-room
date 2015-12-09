package fr.univnantes.vroom.core.persistable.materiel

import fr.univnantes.vroom.core.persistable.tarifs.TarifMateriel
import org.scalatest.{FunSpec, Matchers}

/**
  * Cas de tests pour la classe Materiel
  */
class MaterielSpec extends FunSpec with Matchers {

   describe("Materiel") {

     val tarif = new TarifMateriel(1, "Tarif pour le matériel de test", 50.0)
     val materiel = new MaterielFixe(2, "Matériel de test", tarif)

     describe("#calculerTarif") {

       it("should calculate the correct amount") {
         materiel.calculerTarif() should be (50.0)
       }
     }

   }
 }
