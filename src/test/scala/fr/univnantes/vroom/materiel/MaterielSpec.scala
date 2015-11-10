package fr.univnantes.vroom.materiel

import fr.univnantes.vroom.tarifs.TarifMateriel
import org.scalatest.{BeforeAndAfter, FunSpec, Matchers}

/**
  * Cas de tests pour la classe Materiel
  */
class MaterielSpec extends FunSpec with Matchers {

   describe("A concrete Materiel") {

     class TestMateriel(code: Int, libelle: String, tarif: TarifMateriel) extends Materiel(code, libelle, tarif);

     val tarif = new TarifMateriel(10, "Tarif pour les meubles", 50.0);
     val materiel = new TestMateriel(10, "Meuble", tarif);

     it("should have his getters working") {
       materiel.code should be (10)
       materiel.libelle should be ("Meuble")
       materiel.tarif should be theSameInstanceAs tarif
     }

     it("should have his setters working") {
       materiel.code = 11
       materiel.code should be (11)

       materiel.libelle = "Gros meuble"
       materiel.libelle should be ("Gros meuble")

       val other_tarif = new TarifMateriel(11, "Tarif pour les gros meubles", 50.5);
       materiel.tarif = other_tarif;
       materiel.tarif should be theSameInstanceAs other_tarif;
     }

   }
 }
