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
    * @param id L'identifiant unique de l'objet
    * @param objet L'objet à transformer
    * @return La représentation DTO de l'objet
    */
  def objectToDTO(id : Int, objet : Persistable) : DataTransfertObject = {
    if( !(_dtos contains id)) {
      _dtos += (id -> objet)
    }
    _dtos(id).toDTO()
  }

  /**
    * Méthode transformant une représentation DTO vers l'objet original
    * @param id L'identifiant unique de l'objet
    * @return L'objet représenté par le DTO
    */
  def dtoToObject(id : Int) : Persistable = _dtos(id)

}
