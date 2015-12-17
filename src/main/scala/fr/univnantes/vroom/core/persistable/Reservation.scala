package fr.univnantes.vroom.core.persistable

import fr.univnantes.vroom.core.dto.ReservationDTO
import fr.univnantes.vroom.core.persistable.materiel.MaterielMobile
import fr.univnantes.vroom.core.persistable.tarifs.{TarifDuree, TarifManifestation}

/**
  * Classe représentant une réservation
  *
  * @constructor Crée une nouvelle réservation
  * @param ref_resa Le numéro de référence unique de la réservation
  * @param date_resa La date de la réservation
  * @param montant Le montant de base à payer pour s'acquitter de la réservation
  * @param salle La salle réservée
  * @param demandeur Le demandeur qui effectue la réservation
  * @param manifestation le tarif lié à au type de la manifestation
  * @param duree Le tarif lié à la durée de la réservation
  */
case class Reservation(var ref_resa: Int,
                       var date_resa: String,
                       var montant: Double,
                       var salle: Salle,
                       var demandeur: Demandeur,
                       var manifestation: TarifManifestation,
                       var duree: TarifDuree,
                       var _materiels_mobile: Set[MaterielMobile]) extends Persistable {
  /**
    * Transforme un objet en son DTO
    * @return
    */
  override def toDTO = new ReservationDTO(
    ref_resa,
    date_resa,
    montant,
    salle.toDTO,
    demandeur.toDTO,
    manifestation.toDTO,
    duree.toDTO,
    _materiels_mobile.collect { case x: MaterielMobile => x.toDTO }
  )


  /**
    * Affiche recursivement toutes les informations de la réservation
    * @return
    */
  override def toString: String = "Référence :" + ref_resa + " \n Date :" + date_resa + " \n Montant : " + montant + "" +
    "  " + salle + " " + demandeur + " " + manifestation + " " + duree

  /**
    * Ajoute un nouveau matériel mobile
    * @param materiel Le matériel mobile à ajouter
    */
  def addMateriel(materiel: MaterielMobile): Unit = _materiels_mobile += materiel

  /**
    * Supprime un matériel mobile
    * @param materiel Le matériel mobile à supprimer
    */
  def popMateriel(materiel: MaterielMobile): Unit = _materiels_mobile -= materiel

  /**
    * Méthode qui calcule le montant à payer pour s'acquitter de la réservation
    * @return Le montant à payer pour s'acquitter de la réservation
    */
  def calculTarif(): Double = {
    val cout_tarif = salle.calculerTarif() + demandeur.calculerTarif() + manifestation.tarif + duree.tarif

    val tarif_materiels = _materiels_mobile.foldLeft(0.0) { (acc, materiel) =>
      acc + materiel.calculerTarif()
    }

    montant + cout_tarif + tarif_materiels
  }
}
