package fr.univnantes.vroom.core

import fr.univnantes.vroom.control.dto.SalleDTO
import fr.univnantes.vroom.core.tarifs.{Tarif, TarifSalle}
import fr.univnantes.vroom.datacontroller.Mediator

/**
 * Classe représentant l'environnement d'exécution du logiciel
 */
class Systeme() {

  private var _salles : Set[Persistable] = Set()

  private var _reservations : Set[Persistable] = Set()

  private var _batiments : Set[Persistable] = Set()

  private var _demandeurs : Set[Persistable] = Set()

  private var _typesDeTarif : Set[Persistable] = Set()

  /**
   * Ajoute une nouvelle salle
   * @param salle La salle à ajouter
   */
  def addSalle(salle: SalleDTO): Unit = _salles += DTOManager.dtoToAny(salle.no_salle)

  /**
   * Supprime une salle
   * @param salle La salle à supprimer
   */
  def popSalle(salle: Salle) : Unit = _salles -= salle

  /**
   * Ajoute une nouvelle réservation
   * @param reservation La réservation à ajouter
   */
  def addReservation(reservation : Reservation): Unit = _reservations += reservation

  /**
   * Supprime une réservation
   * @param reservation La réservation à supprimer
   */
  def popReservation(reservation : Reservation) : Unit = _reservations -= reservation

  /**
    * Affiche les informations relative aux réservations
    * @return
    */
  def viewReservation() : Unit = println(this._reservations)

  /**
   * Ajoute un nouveau batiment
   * @param batiment Le batiment à ajouter
   */
  def addBatiment(batiment: Batiment): Unit = _batiments += batiment

  /**
   * Supprime un batiment
   * @param batiment Le batiment à supprimer
   */
  def popBatiment(batiment: Batiment) : Unit = _batiments -= batiment

  /**
   * Ajoute un nouveau demandeur
   * @param demandeur La réservation à ajouter
   */
  def addDemandeur(demandeur: Demandeur): Unit = _demandeurs += demandeur

  /**
   * Supprime un demandeur
   * @param demandeur Le demandeur à supprimer
   */
  def popDemandeur(demandeur: Demandeur) : Unit = _demandeurs -= demandeur


  /**
    * Ajoute une nouvelle salle
    * @param tarif La salle à ajouter
    */
  def addTarif(tarif: Tarif): Unit = _typesDeTarif += tarif

  /**
    * Supprime une salle
    * @param tarif La salle à supprimer
    */
  def popTarif(tarif: Tarif) : Unit = _typesDeTarif -= tarif

  /**
   * Recherche une Reservation suivant un predicat
   * @param predicat Predicat de recherche d'une reservation, renvoi un booleen
   * @return
   */
  def searchReservation( predicat : (Reservation) => Boolean) : Set[Reservation] = _reservations.filter(predicat)

  /**
   * Recherche une Salle suivant un predicat
   * @param predicat Predicat de recherche d'une salle, renvoi un booleen
   * @return
   */
  def searchSalle( predicat : (Salle) => Boolean) : Set[Salle] = _salles.filter(predicat)

  /**
   * Recherche un Batiment suivant un predicat
   * @param predicat Predicat de recherche d'un batiment, renvoi un booleen
   * @return
   */
  def searchBatiment( predicat : (Batiment) => Boolean) : Set[Batiment] = _batiments.filter(predicat)

  /**
   * Recherche un Demandeur suivant un predicat
   * @param predicat Predicat de recherche d'un Demandeur, renvoi un booleen
   * @return
   */
  def searchDemandeur( predicat : (Demandeur) => Boolean) : Set[Demandeur] = _demandeurs.filter(predicat)

  /**
    * Recherche une Tarif suivant un predicat
    * @param predicat Predicat de recherche d'un tarif, renvoi un booleen
    * @return
    */
  def searchTarif( predicat : (Tarif) => Boolean) : Set[Tarif] = _typesDeTarif.filter(predicat)


}
