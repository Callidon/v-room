package fr.univnantes.vroom.core

import fr.univnantes.vroom.control.dto.DataTransfertObject

/**
 * Created by E122371M on 07/12/15.
 */
trait Persistable {

  def toDTO() : DataTransfertObject

}
