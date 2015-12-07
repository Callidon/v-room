package fr.univnantes.vroom.core

import fr.univnantes.vroom.core.dto._
import fr.univnantes.vroom.core.dto.tarifs._
import fr.univnantes.vroom.core.persistable._
import fr.univnantes.vroom.core.persistable.tarifs._

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
  def addSalle(salle: SalleDTO): Unit = _salles += DTOManager.dtoToObject(salle.no_salle)

  /**
   * Supprime une salle
   * @param salle La salle à supprimer
   */
  def popSalle(salle: SalleDTO) : Unit = _salles -= DTOManager.dtoToObject(salle.no_salle)

  /**
   * Ajoute une nouvelle réservation
   * @param reservation La réservation à ajouter
   */
  def addReservation(reservation : ReservationDTO): Unit = _reservations += DTOManager.dtoToObject(reservation.ref_resa)

  /**
   * Supprime une réservation
   * @param reservation La réservation à supprimer
   */
  def popReservation(reservation : ReservationDTO) : Unit = _reservations -= DTOManager.dtoToObject(reservation.ref_resa)

  /**
    * Affiche les informations relative aux réservations
    * @return
    */
  def viewReservation() : Unit = println(this._reservations)

  /**
   * Ajoute un nouveau batiment
   * @param batiment Le batiment à ajouter
   */
  def addBatiment(batiment: BatimentDTO): Unit = _batiments += DTOManager.dtoToObject(batiment.no_bat)

  /**
   * Supprime un batiment
   * @param batiment Le batiment à supprimer
   */
  def popBatiment(batiment: BatimentDTO) : Unit = _batiments -= DTOManager.dtoToObject(batiment.no_bat)

  /**
   * Ajoute un nouveau demandeur
   * @param demandeur La réservation à ajouter
   */
  def addDemandeur(demandeur: DemandeurDTO): Unit = _demandeurs += DTOManager.dtoToObject(demandeur.no_dem)

  /**
   * Supprime un demandeur
   * @param demandeur Le demandeur à supprimer
   */
  def popDemandeur(demandeur: DemandeurDTO) : Unit = _demandeurs -= DTOManager.dtoToObject(demandeur.no_dem)


  /**
    * Ajoute une nouvelle salle
    * @param tarif La salle à ajouter
    */
  def addTarif(tarif: TarifDTO): Unit = _typesDeTarif += DTOManager.dtoToObject(tarif.code)

  /**
    * Supprime une salle
    * @param tarif La salle à supprimer
    */
  def popTarif(tarif: TarifDTO) : Unit = _typesDeTarif -= DTOManager.dtoToObject(tarif.code)

  /**
   * Recherche les réservations respectant un prédicat
   * @param predicat Prédicat de recherche d'une reservation
   * @return L'ensemble des réservations au format DTO respectant le prédicat
   */
  def searchReservation( predicat : (ReservationDTO) => Boolean) : Set[ReservationDTO] = {
    val muted_set : Set[ReservationDTO] = _reservations collect {
      case reserv : Reservation => reserv.toDTO().asInstanceOf[ReservationDTO]
    }

    muted_set.filter(predicat)
  }

  /**
   * Recherche les salles respectant un prédicat
   * @param predicat Prédicat de recherche d'une salle
   * @return L'ensemble des salles au format DTO respectant le prédicat
   */
  def searchSalle( predicat : (SalleDTO) => Boolean) : Set[SalleDTO] = {
    val muted_set : Set[SalleDTO] = _salles collect {
      case salle : Salle => salle.toDTO().asInstanceOf[SalleDTO]
    }

    muted_set.filter(predicat)
  }

  /**
   * Recherche les bâtiments respectant un prédicat
   * @param predicat Prédicat de recherche d'un bâtiment
   * @return L'ensemble des bâtiments au format DTO respectant le prédicat
   */
  def searchBatiment( predicat : (BatimentDTO) => Boolean) : Set[BatimentDTO] = {
    val muted_set : Set[BatimentDTO] = _batiments collect {
      case batiment : Batiment => batiment.toDTO().asInstanceOf[BatimentDTO]
    }

    muted_set.filter(predicat)
  }

  /**
   * Recherche les demandeurs respectant un prédicat
   * @param predicat Prédicat de recherche d'un demandeur
   * @return L'ensemble des demandeurs au format DTO respectant le prédicat
   */
  def searchDemandeur( predicat : (DemandeurDTO) => Boolean) : Set[DemandeurDTO] = {
    val muted_set : Set[DemandeurDTO] = _demandeurs collect {
      case demandeur : Demandeur => demandeur.toDTO().asInstanceOf[DemandeurDTO]
    }

    muted_set.filter(predicat)
  }

  /**
    * Recherche les tarifs respectant un prédicat
    * @param predicat Prédicat de recherche d'un tarif
    * @return L'ensemble des tarifs au format DTO respectant le prédicat
    */
  def searchTarif( predicat : (TarifDTO) => Boolean) : Set[TarifDTO] = {
    val muted_set : Set[TarifDTO] = _typesDeTarif collect {
      case tarif : TarifDuree => tarif.toDTO().asInstanceOf[TarifDureeDTO]
      case tarif : TarifManifestation => tarif.toDTO().asInstanceOf[TarifManifestationDTO]
      case tarif : TarifMateriel => tarif.toDTO().asInstanceOf[TarifMaterielDTO]
      case tarif : TarifOrigine => tarif.toDTO().asInstanceOf[TarifOrigineDTO]
      case tarif : TarifSalle => tarif.toDTO().asInstanceOf[TarifSalleDTO]
      case tarif : TarifTitre => tarif.toDTO().asInstanceOf[TarifTitreDTO]
    }

    muted_set.filter(predicat)
  }


}
