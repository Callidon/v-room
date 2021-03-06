package fr.univnantes.vroom.core.persistable

import fr.univnantes.vroom.core.persistable.tarifs.{TarifOrigine, TarifTitre}
import org.scalatest.{FunSpec, Matchers}

/**
  * Cas de tests pour la classe Demandeur
  */
class DemandeurSpec extends FunSpec with Matchers {

   describe("Demandeur") {
      val adresse = new Adresse(5, "Rue du port", "44000", "Nantes")
      val titre = new TarifTitre(5, "Tarif pour le titre A", 40.0)
      val origine = new TarifOrigine(6, "Tarif pour l'origine X", 35.0)
      val demandeur = new Demandeur(10, "Philippe", adresse, origine, titre)

      val adresse2 = new Adresse(5, "Rue du port", "44000", "Nantes")
      val titre2 = new TarifTitre(5, "Tarif pour le titre A", 40.0)
      val origine2 = new TarifOrigine(6, "Tarif pour l'origine X", 35.0)
      val demandeur2 = new Demandeur(10, "Philippe", adresse, origine, titre)

      it("toString should be better programmed"){
        demandeur.toString should be (demandeur2.toString)
      }
    }
 }
