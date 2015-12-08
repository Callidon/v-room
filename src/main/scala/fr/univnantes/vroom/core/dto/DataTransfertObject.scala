package fr.univnantes.vroom.core.dto

import fr.univnantes.vroom.core.persistable.Persistable

/**
 * Created by E122371M on 07/12/15.
 */
abstract class DataTransfertObject(val className : String) {

  def toObject() : Persistable

}
