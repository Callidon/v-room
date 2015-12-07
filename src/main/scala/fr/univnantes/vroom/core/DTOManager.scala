package fr.univnantes.vroom.core

import fr.univnantes.vroom.core.dto.DataTransfertObject
import fr.univnantes.vroom.core.persistable.Persistable

/**
 * Created by E122371M on 07/12/15.
 */
object DTOManager {

  private var _dtos : Map[Int, Persistable] = Map[Int, Persistable]()

  def objectToDTO(id : Int, objet : Persistable) : DataTransfertObject = {
    if( !(_dtos contains id)) {
      _dtos += (id -> objet)
    }
    _dtos(id).toDTO()
  }

  def dtoToObject(id : Int) : Persistable = _dtos(id)

}
