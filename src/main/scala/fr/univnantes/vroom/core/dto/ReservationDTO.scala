package fr.univnantes.vroom.core.dto

import fr.univnantes.vroom.core.DTOManager
import fr.univnantes.vroom.core.dto.materiel.MaterielMobileDTO
import fr.univnantes.vroom.core.dto.tarifs.{TarifDureeDTO, TarifManifestationDTO}
import fr.univnantes.vroom.core.persistable.tarifs.{TarifDuree, TarifManifestation}
import fr.univnantes.vroom.core.persistable.{Demandeur, Persistable, Reservation, Salle}

/**
  * * Classe représentant une Réservation dans le système
  * @param ref_resa référence de la réservation
  * @param date_resa date de la réservation
  * @param montant Montant de la réservation
  * @param salle DTO Salle de la réservation
  * @param demandeur DTO Demandeur de la réservation
  * @param manifestation DTO Tarif de la manifestation
  * @param duree DTO Durée de la réservation
  * @param materiel_mobile Set de DTO des matériel mobile
  */
case class ReservationDTO(var ref_resa: Int,
                          var date_resa: String,
                          var montant: Double,
                          var salle: SalleDTO,
                          var demandeur: DemandeurDTO,
                          var manifestation: TarifManifestationDTO,
                          var duree: TarifDureeDTO,
                          var materiel_mobile: Set[MaterielMobileDTO]) extends DataTransfertObject("Reservation") {
  /**
    * Transforme le DTO en objet concret du système
    * @return
    */
  override def toObject: Persistable = new Reservation(
    ref_resa,
    date_resa,
    montant,
    DTOManager.dtoToObject(salle.no_salle, salle).asInstanceOf[Salle],
    DTOManager.dtoToObject(demandeur.no_dem, demandeur).asInstanceOf[Demandeur],
    DTOManager.dtoToObject(manifestation.code, manifestation).asInstanceOf[TarifManifestation],
    DTOManager.dtoToObject(duree.code, duree).asInstanceOf[TarifDuree],
    materiel_mobile.collect { case x: MaterielMobileDTO => x.toObject }
  )
}
