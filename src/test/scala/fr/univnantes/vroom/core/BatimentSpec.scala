package fr.univnantes.vroom.core

import org.scalatest.{FunSpec, Matchers}

/**
  * Cas de tests pour la classe Demandeur
  */
class BatimentSpec extends FunSpec with Matchers {

   describe("Batiment") {

    val adresse = new Adresse("18A", "Avenue des champs de Mars", "22500", "Paris")
    val batiment = new Batiment(10, "Salle des sports", adresse)

    val adresse2 = new Adresse("18A", "Avenue des champs de Mars", "22500", "Paris")
    val batiment2 = new Batiment(10, "Salle des sports", adresse)

    it("toString should be better..."){
      batiment.toString should be (batiment2.toString)
    }
   }
 }
