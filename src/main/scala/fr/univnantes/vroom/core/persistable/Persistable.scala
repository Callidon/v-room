package fr.univnantes.vroom.core.persistable

import fr.univnantes.vroom.core.dto.DataTransfertObject

/**
 * Created by E122371M on 07/12/15.
 */
trait Persistable {

  def toDTO() : DataTransfertObject

}
