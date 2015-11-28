package fr.univnantes.vroom.core

import org.scalatest.{FunSpec, Matchers}

/**
  * Cas de tests pour la classe Demandeur
  */
class BatimentSpec extends FunSpec with Matchers {

   describe("A batiment") {

     val adresse = new Adresse("18A", "Avenue des champs de Mars", "22500", "Paris")
     val batiment = new Batiment(10, "Salle des sports", adresse)

     val adresse2 = new Adresse("18A", "Avenue des champs de Mars", "22500", "Paris")
     val batiment2 = new Batiment(10, "Salle des sports", adresse)

     it("toString should be better..."){
       batiment.toString should be (batiment2.toString)
     }

     it("should have his getters working") {
       batiment.no_bat should be (10)
       batiment.nom should be ("Salle des sports")
       batiment.adresse should be theSameInstanceAs adresse
     }

     it("should have his setters working") {
       batiment.no_bat = 11
       batiment.no_bat should be (11)

       batiment.nom = "Salle des fêtes"
       batiment.nom should be ("Salle des fêtes")

       val other_adresse = new Adresse("185B", "Rue des petits canards", "22750", "Issy-Les-Moulineaux")
       batiment.adresse = other_adresse
       batiment.adresse should be theSameInstanceAs other_adresse
     }

   }
 }
