package fr.univnantes.vroom.core

import java.util.Date

import fr.univnantes.vroom.materiel.{MaterielMobile, Materiel}
import fr.univnantes.vroom.tarifs.{TarifDuree, TarifManifestation}

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
                  var date_resa: Date,
                  var montant: Double,
                  var salle: Salle,
                  var demandeur: Demandeur,
                  var manifestation: TarifManifestation,
                  var duree: TarifDuree ) {

  // Ensemble des matériels mobiles liées à la réservation
  private var _materiels_mobile : Set[Materiel] = Set()

  /**
   * Ajoute un nouveau matériel mobile
   * @param materiel Le matériel mobile à ajouter
   */
  def addMateriel(materiel: MaterielMobile): Unit = {
    _materiels_mobile += materiel
  }

  /**
   * Supprime un matériel mobile
   * @param materiel Le matériel mobile à supprimer
   */
  def popMateriel(materiel: MaterielMobile) : Unit = {
    _materiels_mobile -= materiel
  }

  def calculTarif(): Integer = {
    return 1
  }
}
