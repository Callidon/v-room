package fr.univnantes.vroom.core

import org.scalatest.{FunSpec, Matchers}

/**
  * Cas de tests pour la classe Demandeur
  */
class AdresseSpec extends FunSpec with Matchers {

  describe("Adresse") {

    val adresse = new Adresse("5B", "Rue du port", "44000", "Nantes")

    describe("#toString") {
      it("should return a correct representation of the object"){
        adresse.toString should be (" Adresse :  "+
          " \n  | Numero : 5B"+
          " \n  | Adresse : Rue du port"+
          " \n  | Code postal : 44000"+
          " \n  | Ville : Nantes")
      }
    }
  }
 }
