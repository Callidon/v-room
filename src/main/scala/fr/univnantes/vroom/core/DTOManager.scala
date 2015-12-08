package fr.univnantes.vroom.core

import fr.univnantes.vroom.core.dto.DataTransfertObject
import fr.univnantes.vroom.core.persistable.Persistable

/**
 * Classe représentant un gestionnaire de représentations selon le pattern data Transfer Object
 */
object DTOManager {

  private var _dtos : Map[Int, Persistable] = Map[Int, Persistable]()

  /**
    * Méthode transformant un objet vers son équivalent DTO
    * @param objet L'objet à transformer
    * @return La représentation DTO de l'objet
    */
  def objectToDTO(objet : Persistable) : DataTransfertObject = objet.toDTO()

  /**
    * Méthode transformant une représentation DTO vers l'objet original
    * @param id L'identifiant unique de l'objet
    * @return L'objet représenté par le DTO
    */
  def dtoToObject(id : Int, dto : DataTransfertObject) : Persistable = {
    if( !(_dtos contains id)) {
      _dtos += (id -> dto.toObject())
    }
    _dtos(id)
  }


  /**
    * Méthode remplaçant un ancien Dto par un nouvel objet Persistable.
    * @param id Id de l'objet stocké
    * @param objet nouvel objet à persister
    * @return
    */
  def updateDto(id:Int, objet : Persistable) = _dtos.updated(id,objet)

  /**
    * Suppression d'un couple dans _dtos
    * @param id Id d'un objet
    */
  def deleteDto(id : Int ) = _dtos -= id
}
