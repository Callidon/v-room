package fr.univnantes.vroom.core

import fr.univnantes.vroom.datacontroller.Mediator

/**
 * Classe représentant l'environnement d'exécution du logiciel
 */
class Systeme(val mediator : Mediator) {

  private var _salles : Set[Salle] = Set()

  private var _reservations : Set[Reservation] = Set()

  private var _batiments : Set[Batiment] = Set()

  private var _demandeurs : Set[Demandeur] = Set()

  /**
   * Ajoute une nouvelle salle
   * @param salle La salle à ajouter
   */
  def addSalle(salle: Salle): Unit = _salles += salle

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
   *
   * @param predicat
   * @return
   */
  def searchReservation( predicat : (Reservation) => Boolean) : Set[Reservation] = _reservations.filter(predicat)

  /**
   *
   * @param predicat
   * @return
   */
  def searchSalle( predicat : (Salle) => Boolean) : Set[Salle] = _salles.filter(predicat)

  /**
   *
   * @param predicat
   * @return
   */
  def searchBatiment( predicat : (Batiment) => Boolean) : Set[Batiment] = _batiments.filter(predicat)

  /**
   *
   * @param predicat
   * @return
   */
  def searchDemandeur( predicat : (Demandeur) => Boolean) : Set[Demandeur] = _demandeurs.filter(predicat)

}
