package fr.univnantes.vroom.core

import fr.univnantes.vroom.tarifs.{TarifOrigine, TarifTitre, TarifMateriel}
import org.scalatest.{BeforeAndAfter, FunSpec, Matchers}

/**
  * Cas de tests pour la classe Demandeur
  */
class DemandeurSpec extends FunSpec with Matchers {

   describe("A Demandeur") {

     val adresse = new Adresse("5B", "Rue du port", "44000", "Nantes")
     val titre = new TarifTitre(5, "Tarif pour le titre A", 40.0)
     val origine = new TarifOrigine(6, "Tarif pour l'origine X", 35.0)
     val demandeur = new Demandeur(10, "Philippe", adresse, origine, titre)

     val adresse2 = new Adresse("5B", "Rue du port", "44000", "Nantes")
     val titre2 = new TarifTitre(5, "Tarif pour le titre A", 40.0)
     val origine2 = new TarifOrigine(6, "Tarif pour l'origine X", 35.0)
     val demandeur2 = new Demandeur(10, "Philippe", adresse, origine, titre)

     it("toString should be better programmed"){
       demandeur.toString should be (demandeur2.toString)
     }

     it("should have his getters working") {
       demandeur.no_dem should be (10)
       demandeur.nom should be ("Philippe")
       demandeur.adresse should be theSameInstanceAs adresse
       demandeur.origine should be theSameInstanceAs origine
       demandeur.titre should be theSameInstanceAs titre
     }

     it("should have his setters working") {
       demandeur.no_dem = 11
       demandeur.no_dem should be (11)

       demandeur.nom = "Alice"
       demandeur.nom should be ("Alice")

       val other_adresse = new Adresse("58C", "Rue de la petite belette", "44200", "Paris")
       demandeur.adresse = other_adresse
       demandeur.adresse should be theSameInstanceAs other_adresse

       val other_origine = new TarifOrigine(7, "Tarif pour l'origine Y", 36.5)
       demandeur.origine = other_origine
       demandeur.origine should be theSameInstanceAs other_origine

       val other_titre = new TarifTitre(8, "Tarif pour le titre B", 45.8)
       demandeur.titre = other_titre
       demandeur.titre should be theSameInstanceAs other_titre
     }

   }
 }
