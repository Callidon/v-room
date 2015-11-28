package fr.univnantes.vroom.core

import org.scalatest.{FunSpec, Matchers}

/**
  * Cas de tests pour la classe Demandeur
  */
class AdresseSpec extends FunSpec with Matchers {

   describe("An Adress") {


     val adresse = new Adresse("5B", "Rue du port", "44000", "Nantes")

     it("toString should be better..."){
       adresse.toString should be (" Adresse :  "+
         " \n  | Numero : 5B"+
         " \n  | Adresse : Rue du port"+
         " \n  | Code postal : 44000"+
         " \n  | Ville : Nantes")
     }

     it("should have his getters working") {
       adresse.numero should be ("5B")
       adresse.adresse should be ("Rue du port")
       adresse.code should be ("44000")
       adresse.ville should be ("Nantes")
     }

     it("should have his setters working") {
       adresse.numero = "58C"
       adresse.numero should be ("58C")

       adresse.adresse = "Rue de la petite belette"
       adresse.adresse should be ("Rue de la petite belette")

       adresse.code = "44200"
       adresse.code should be ("44200")

       adresse.ville = "Paris"
       adresse.ville should be ("Paris")
     }

   }
 }
