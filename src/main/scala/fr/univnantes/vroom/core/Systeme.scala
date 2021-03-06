package fr.univnantes.vroom.core

import fr.univnantes.vroom.core.dto._
import fr.univnantes.vroom.core.dto.materiel.{MaterielDTO, MaterielFixeDTO, MaterielMobileDTO}
import fr.univnantes.vroom.core.dto.tarifs._
import fr.univnantes.vroom.core.persistable._
import fr.univnantes.vroom.core.persistable.materiel.MaterielMobile
import fr.univnantes.vroom.core.persistable.tarifs._

/**
  * Classe représentant l'environnement d'exécution du logiciel
  */
class Systeme() {


  /**
    *
    */
  private var _salles: Set[Persistable] = Set()
  /**
    *
    */
  private var _reservations: Set[Persistable] = Set()
  /**
    *
    */
  private var _batiments: Set[Persistable] = Set()
  /**
    *
    */
  private var _demandeurs: Set[Persistable] = Set()
  /**
    *
    */
  private var _typesDeTarif: Set[Persistable] = Set()
  /**
    *
    */
  private var _materiel_disponibles_fixe: Set[Persistable] = Set()
  /**
    *
    */
  private var _materiel_disponibles_mobile: Set[Persistable] = Set()

  /**
    * Methode permettant l'ajout de matériel Mobile disponible
    * @param materiel Le materiel à supprimer de la liste
    * @return
    */
  def addMaterielMobileDisponible(materiel: MaterielMobileDTO) = _materiel_disponibles_mobile += DTOManager.dtoToObject(materiel.code, materiel)

  /**
    * Methode permettant la suppression de matériel Mobile disponible
    * @param materiel Le materiel à supprimer de la liste
    * @return
    */
  def popMaterielMobileDisponible(materiel: MaterielMobileDTO) = {
    _materiel_disponibles_mobile -= DTOManager.dtoToObject(materiel.code, materiel)
    DTOManager.deleteDto(materiel.code)
  }

  /**
    * Retourne l'ensemble des DTO  des materiels mobiles disponible pour une consultation des données
    * @return Retourne l'ensemble des DTO des materiels mobiles disponibles
    */
  def viewMaterielMobileDisponible(): Set[DataTransfertObject] = {
    _materiel_disponibles_mobile.collect { case x: Persistable => x.toDTO }
  }

  /**
    * Methode permettant l'ajout de matériel fixe disponible
    * @param materiel Le materiel à supprimer de la liste
    * @return
    */
  def addMaterieFixeDisponible(materiel: MaterielFixeDTO) = _materiel_disponibles_fixe += DTOManager.dtoToObject(materiel.code, materiel)

  /**
    * Methode permettant la suppression de matériel Mobile disponible
    * @param materiel Le materiel à supprimer de la liste
    * @return
    */
  def popMaterielFixeDisponible(materiel: MaterielFixeDTO) = {
    _materiel_disponibles_fixe -= DTOManager.dtoToObject(materiel.code, materiel)
    DTOManager.deleteDto(materiel.code)
  }

  /**
    * Retourne l'ensemble des DTO  des materiels fixe disponible pour une consultation des données
    * @return Retourne l'ensemble des DTO des materiels fixes disponibles
    */
  def viewMaterielFixeDisponible(): Set[DataTransfertObject] = {
    _materiel_disponibles_fixe.collect { case x: Persistable => x.toDTO }
  }

  /**
    * Ajoute une nouvelle salle
    * @param salle La salle à ajouter
    */
  def addSalle(salle: SalleDTO): Unit = _salles += DTOManager.dtoToObject(salle.no_salle, salle)

  /**
    * Supprime une salle
    * @param salle La salle à supprimer
    */
  def popSalle(salle: SalleDTO): Unit = {
    _salles -= DTOManager.dtoToObject(salle.no_salle, salle)
    DTOManager.deleteDto(salle.no_salle)
  }

  /**
    * Retourne l'ensemble des DTO Salle pour une consultation des données
    * @return Retourne l'ensemble des DTO Salle
    */
  def viewSalle(): Set[DataTransfertObject] = {
    _salles.collect { case x: Persistable => x.toDTO }
  }

  /**
    * Methode permettant d'ajouter du matériel dans une salle
    * @param salle La salle dont on doit ajouter le materiel fixe
    * @param materiel Le materiel Fixe à ajouter
    */
  def addMaterielFixe(salle: SalleDTO, materiel: MaterielFixeDTO): DataTransfertObject = {
    DTOManager.dtoToObject(salle.no_salle, salle).asInstanceOf[Salle].addMateriel(materiel.toObject)
    DTOManager.dtoToObject(salle.no_salle, salle).toDTO
  }

  /**
    * Methode permettant de supprimer du matériel dans une salle
    * @param salle La salle dont on doit ajouter le materiel fixe
    * @param materiel Le materiel Fixe à ajouter
    *
    */
  def popMaterielFixe(salle: SalleDTO, materiel: MaterielFixeDTO): DataTransfertObject = {
    DTOManager.dtoToObject(salle.no_salle, salle).asInstanceOf[Salle].popMateriel(materiel.toObject)
    DTOManager.dtoToObject(salle.no_salle, salle).toDTO
  }

  /**
    * Ajoute une nouvelle réservation
    * @param reservation La réservation à ajouter
    */
  def addReservation(reservation: ReservationDTO): Unit = _reservations += DTOManager.dtoToObject(reservation.ref_resa, reservation)

  /**
    * Supprime une réservation
    * @param reservation La réservation à supprimer
    */
  def popReservation(reservation: ReservationDTO): Unit = {
    _reservations -= DTOManager.dtoToObject(reservation.ref_resa, reservation)
    DTOManager.deleteDto(reservation.ref_resa)
  }

  /**
    * Retourne l'ensemble des DTO réservation pour une consultation des données
    * @return Retourne l'ensemble des DTO réservation
    */
  def viewReservation(): Set[DataTransfertObject] = {
    _reservations.collect { case x: Persistable => x.toDTO }
  }

  /**
    * Methode permettant l'ajout d'un materiel mobile dans une réservation
    * @param reservation Objet DTO représentant une réservation
    * @param materiel Objet DTO représentant un materiel
    * @return Retourne un DTO
    */
  def addMaterielMobile(reservation: ReservationDTO, materiel: MaterielDTO): DataTransfertObject = {
    DTOManager.dtoToObject(reservation.ref_resa, reservation).asInstanceOf[Reservation].addMateriel(materiel.toObject.asInstanceOf[MaterielMobile])
    DTOManager.dtoToObject(reservation.ref_resa, reservation).toDTO
  }

  /**
    * Methode permettant la suppresion d'un materiel mobile dans une réservation
    * @param reservation Objet DTO représentant une réservation
    * @param materiel Objet DTO représentant un materiel
    * @return Retourne un DTO
    */
  def popMaterielMobile(reservation: ReservationDTO, materiel: MaterielMobileDTO): DataTransfertObject = {

    DTOManager.dtoToObject(reservation.ref_resa, reservation).asInstanceOf[Reservation].popMateriel(materiel.toObject)
    DTOManager.dtoToObject(reservation.ref_resa, reservation).toDTO
  }

  /**
    * Ajoute un nouveau batiment
    * @param batiment Le batiment à ajouter
    */
  def addBatiment(batiment: BatimentDTO): Unit = _batiments += DTOManager.dtoToObject(batiment.no_bat, batiment)

  /**
    * Supprime un batiment
    * @param batiment Le batiment à supprimer
    */
  def popBatiment(batiment: BatimentDTO): Unit = {
    _batiments -= DTOManager.dtoToObject(batiment.no_bat, batiment)
    DTOManager.deleteDto(batiment.no_bat)
  }

  /**
    * Retourne l'ensemble des DTO Batiment pour une consultation des données
    * @return Retourne l'ensemble des DTO Batiment
    */
  def viewBatiment(): Set[DataTransfertObject] = {
    _batiments.collect { case x: Persistable => x.toDTO }
  }

  /**
    * Ajoute un nouveau demandeur
    * @param demandeur La réservation à ajouter
    */
  def addDemandeur(demandeur: DemandeurDTO): Unit = _demandeurs += DTOManager.dtoToObject(demandeur.no_dem, demandeur)

  /**
    * Supprime un demandeur
    * @param demandeur Le demandeur à supprimer
    */
  def popDemandeur(demandeur: DemandeurDTO): Unit = {
    _demandeurs -= DTOManager.dtoToObject(demandeur.no_dem, demandeur)
    DTOManager.deleteDto(demandeur.no_dem)
  }

  /**
    * Retourne l'ensemble des DTO Demandeur pour une consultation des données
    * @return Retourne l'ensemble des DTO Demandeur
    */
  def viewDemandeur(): Set[DataTransfertObject] = {
    _demandeurs.collect { case x: Persistable => x.toDTO }
  }

  /**
    * Ajoute une nouvelle salle
    * @param tarif La salle à ajouter
    */
  def addTarif(tarif: TarifDTO): Unit = _typesDeTarif += DTOManager.dtoToObject(tarif.code, tarif)

  /**
    * Supprime une salle
    * @param tarif La salle à supprimer
    */
  def popTarif(tarif: TarifDTO): Unit = {
    _typesDeTarif -= DTOManager.dtoToObject(tarif.code, tarif)
    DTOManager.deleteDto(tarif.code)
  }

  /**
    * Retourne l'ensemble des DTO Types de tarifs pour une consultation des données
    * @return Retourne l'ensemble des DTO Types de tarifs
    */
  def viewTarifs(): Set[DataTransfertObject] = {
    _typesDeTarif.collect { case x: Persistable => x.toDTO }
  }

  /**
    * Recherche les réservations respectant un prédicat
    * @param predicat Prédicat de recherche d'une reservation
    * @return L'ensemble des réservations au format DTO respectant le prédicat
    */
  def searchReservation(predicat: (ReservationDTO) => Boolean): Set[ReservationDTO] = {
    val muted_set: Set[ReservationDTO] = _reservations collect {
      case reserv: Reservation => reserv.toDTO
    }

    muted_set.filter(predicat)
  }

  /**
    * Recherche les salles respectant un prédicat
    * @param predicat Prédicat de recherche d'une salle
    * @return L'ensemble des salles au format DTO respectant le prédicat
    */
  def searchSalle(predicat: (SalleDTO) => Boolean): Set[SalleDTO] = {
    val muted_set: Set[SalleDTO] = _salles collect {
      case salle: Salle => salle.toDTO
    }

    muted_set.filter(predicat)
  }

  /**
    * Recherche les bâtiments respectant un prédicat
    * @param predicat Prédicat de recherche d'un bâtiment
    * @return L'ensemble des bâtiments au format DTO respectant le prédicat
    */
  def searchBatiment(predicat: (BatimentDTO) => Boolean): Set[BatimentDTO] = {
    val muted_set: Set[BatimentDTO] = _batiments collect {
      case batiment: Batiment => batiment.toDTO
    }

    muted_set.filter(predicat)
  }

  /**
    * Recherche les demandeurs respectant un prédicat
    * @param predicat Prédicat de recherche d'un demandeur
    * @return L'ensemble des demandeurs au format DTO respectant le prédicat
    */
  def searchDemandeur(predicat: (DemandeurDTO) => Boolean): Set[DemandeurDTO] = {
    val muted_set: Set[DemandeurDTO] = _demandeurs collect {
      case demandeur: Demandeur => demandeur.toDTO
    }

    muted_set.filter(predicat)
  }

  /**
    * Recherche les Matériels Mobile disponible
    * @param search_pred Prédicat de recherche
    * @return Retourne un Set de DTO
    */
  def searchMaterielMobileDisponible(search_pred: (MaterielMobileDTO) => Boolean): Set[MaterielMobileDTO] = {
    val muted_set = _materiel_disponibles_fixe.collect {
      case mat: MaterielMobileDTO => mat.toDTO.asInstanceOf[MaterielMobileDTO]
    }

    muted_set.filter(search_pred)
  }

  /**
    * Recherche les Matériels Fixe disponible
    * @param search_pred Prédicat de recherche
    * @return Retourne un Set de DTO
    */
  def searchMaterielFixeDisponible(search_pred: (MaterielFixeDTO) => Boolean): Set[MaterielFixeDTO] = {
    val muted_set = _materiel_disponibles_fixe.collect {
      case mat: MaterielFixeDTO => mat.toDTO.asInstanceOf[MaterielFixeDTO]
    }

    muted_set.filter(search_pred)
  }

  /**
    * Recherche les tarifs respectant un prédicat
    * @param predicat Prédicat de recherche d'un tarif
    * @return L'ensemble des tarifs au format DTO respectant le prédicat
    */
  def searchTarif(predicat: (TarifDTO) => Boolean): Set[TarifDTO] = {
    val muted_set: Set[TarifDTO] = _typesDeTarif collect {
      case tarif: TarifDuree => tarif.toDTO
      case tarif: TarifManifestation => tarif.toDTO
      case tarif: TarifMateriel => tarif.toDTO
      case tarif: TarifOrigine => tarif.toDTO
      case tarif: TarifSalle => tarif.toDTO
      case tarif: TarifTitre => tarif.toDTO
    }

    muted_set.filter(predicat)
  }


}
