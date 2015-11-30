package fr.univnantes.vroom.materiel

import fr.univnantes.vroom.tarifs.TarifMateriel
import org.scalatest.{BeforeAndAfter, FunSpec, Matchers}

/**
  * Cas de tests pour la classe Materiel
  */
class MaterielSpec extends FunSpec with Matchers {

   describe("Materiel") {

     class TestMateriel(code: Int, libelle: String, tarif: TarifMateriel) extends Materiel(code, libelle, tarif)

     val tarif = new TarifMateriel(1, "Tarif pour le matériel de test", 50.0)
     val materiel = new TestMateriel(2, "Matériel de test", tarif)

     describe("#calculerTarif") {

       it("should calculate the correct amount") {
         materiel.calculerTarif() should be (50.0)
       }
     }

   }
 }
