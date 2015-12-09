package fr.univnantes.vroom

import fr.univnantes.vroom.core.dto._
import fr.univnantes.vroom.core.dto.materiel._
import fr.univnantes.vroom.core.dto.tarifs._
import fr.univnantes.vroom.core.persistable._
import fr.univnantes.vroom.core.persistable.materiel.{MaterielFixe, MaterielMobile}
import fr.univnantes.vroom.core.persistable.tarifs._

/**
  * Ensemble de constantes pour les cas de tests
  */
object TestsConstants {

  // Objets classiques

  val adresse = new Adresse(1, "Rue du port", "44000", "Nantes")

  val batiment = new Batiment(2, "Salle des sports", adresse)

  val date = "2015-12-09"

  val duree = new TarifDuree(3, "Tarif en fonction de la durée", 60.0)

  val manifestation = new TarifManifestation(4, "Tarif de la manifestation", 15.0)

  val titre = new TarifTitre(5, "Tarif pour le titre A", 40.0)

  val origine = new TarifOrigine(6, "Tarif pour l'origine X", 35.0)

  val tarif_salle = new TarifSalle(7, "Tarif pour la salle", 135.0)

  val tarif_materiel = new TarifMateriel(8, "Tarif pour un matériel", 20.0)

  val demandeur = new Demandeur(9, "Philippe", adresse, origine, titre)

  val salle = new Salle(10, 10, 15, 60, batiment, tarif_salle, Set[MaterielFixe]())

  val reservation = new Reservation(11, date, 15.0, salle, demandeur, manifestation, duree, Set[MaterielMobile]())

  // Equivalents DTO des objets classiques

  val adresseDTO = new AdresseDTO(1, "Rue du port", "44000", "Nantes")

  val batimentDTO = new BatimentDTO(2, "Salle des sports", adresseDTO)

  val dureeDTO = new TarifDureeDTO(3, "Tarif en fonction de la durée", 60.0)

  val manifestationDTO = new TarifManifestationDTO(4, "Tarif de la manifestation", 15.0)

  val titreDTO = new TarifTitreDTO(5, "Tarif pour le titre A", 40.0)

  val origineDTO = new TarifOrigineDTO(6, "Tarif pour l'origine X", 35.0)

  val tarif_salleDTO = new TarifSalleDTO(7, "Tarif pour la salle", 135.0)

  val tarif_materielDTO = new TarifMaterielDTO(8, "Tarif pour un matériel", 20.0)

  val demandeurDTO = new DemandeurDTO(9, "Philippe", adresseDTO, origineDTO, titreDTO)

  val salleDTO = new SalleDTO(10, 10, 15, 60, batimentDTO, tarif_salleDTO, Set[MaterielFixeDTO]())

  val reservationDTO = new ReservationDTO(11, date, 15.0, salleDTO, demandeurDTO, manifestationDTO, dureeDTO, Set[MaterielMobileDTO]())

}
