package fr.univnantes.vroom.materiel

import fr.univnantes.vroom.tarifs.TarifMateriel
import org.scalatest.{BeforeAndAfter, FunSpec, Matchers}

/**
  * Cas de tests pour la classe Materiel
  */
class MaterielSpec extends FunSpec with Matchers {

   describe("A concrete Materiel") {

     class TestMateriel(code: Int, libelle: String, tarif: TarifMateriel) extends Materiel(code, libelle, tarif)

     val tarif = new TarifMateriel(10, "Tarif pour les meubles", 50.0)
     val materiel = new TestMateriel(10, "Meuble", tarif)

   }
 }
