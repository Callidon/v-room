package fr.univnantes.vroom

import java.util.Date

import fr.univnantes.vroom.core._
import fr.univnantes.vroom.tarifs._

/**
 * Ensemble de constantes pour les tests unitaires
 */
object TestsConstants {

  val adresse = new Adresse("5B", "Rue du port", "44000", "Nantes")

  val batiment = new Batiment(10, "Salle des sports", adresse)

  val date = new Date()

  val duree = new TarifDuree(3, "Tarif en fonction de la durée", 60.0)

  val manifestation = new TarifManifestation(4, "Tarif de la manifestation", 15.0)

  val titre = new TarifTitre(5, "Tarif pour le titre A", 40.0)

  val origine = new TarifOrigine(6, "Tarif pour l'origine X", 35.0)

  val tarif_salle = new TarifSalle(7, "Tarif pour la salle", 135.0)

  val tarif_materiel = new TarifMateriel(8, "Tarif pour un matériel", 20.0)

  val demandeur = new Demandeur(10, "Philippe", adresse, origine, titre)

  val salle = new Salle(1, 10, 15, 60, batiment, tarif_salle)

  val reservation = new Reservation(2, date, 15.0, salle, demandeur, manifestation, duree)

}
