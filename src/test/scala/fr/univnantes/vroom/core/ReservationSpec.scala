package fr.univnantes.vroom.core

import fr.univnantes.vroom.tarifs.{TarifDuree, TarifManifestation, TarifOrigine, TarifTitre}
import org.scalatest.{Matchers, FunSpec}

/**
  * Created by folkvir on 28/11/15.
  */
class ReservationSpec extends FunSpec with Matchers {
  describe("A Demandeur") {

    val adresse = new Adresse("5B", "Rue du port", "44000", "Nantes")
    val titre = new TarifTitre(5, "Tarif pour le titre A", 40.0)
    val origine = new TarifOrigine(6, "Tarif pour l'origine X", 35.0)
    val demandeur = new Demandeur(10, "Philippe", adresse, origine, titre)
    val batiment = new Batiment(10, "Salle des sports", adresse)
    val salle = new Salle(1,32,10,50,batiment)
    val manifestation = new TarifManifestation(12,"Fiesta de fou",54.65)
    val duree = new TarifDuree(13,"Toute la nuit",100000)
    val reservation = new Reservation(123456,null,345678.65,salle,demandeur,manifestation,duree)

    val adresse2 = new Adresse("5B", "Rue du port", "44000", "Nantes")
    val titre2 = new TarifTitre(5, "Tarif pour le titre A", 40.0)
    val origine2 = new TarifOrigine(6, "Tarif pour l'origine X", 35.0)
    val demandeur2 = new Demandeur(10, "Philippe", adresse2, origine2, titre2)
    val batiment2 = new Batiment(10, "Salle des sports", adresse2)
    val salle2 = new Salle(1,32,10,50,batiment2)
    val manifestation2 = new TarifManifestation(12,"Fiesta de fou",54.65)
    val duree2 = new TarifDuree(13,"Toute la nuit",100000)
    val reservation2 = new Reservation(123456,null,345678.65,salle2,demandeur2,manifestation2,duree2)

    it("toString should be better programmed"){
      reservation.toString should be (reservation2.toString)
    }
  }
}