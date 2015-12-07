package fr.univnantes.vroom.core

import fr.univnantes.vroom.control.dto.DataTransfertObject

/**
 * Created by E122371M on 07/12/15.
 */
object DTOManager {

  private var _dtos : Map[Int, Persistable] = Map[Int, Persistable]()

  def anyToDTO(id : Int, objet : Persistable) : DataTransfertObject = {
    if( !(_dtos contains id)) {
      _dtos += (id -> objet)
    }
    _dtos(id).toDTO()
  }

  def dtoToAny(id : Int) : Persistable = _dtos(id)

}
