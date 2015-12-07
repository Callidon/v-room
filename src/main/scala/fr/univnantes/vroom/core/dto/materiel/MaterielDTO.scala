package fr.univnantes.vroom.core.dto.materiel

import fr.univnantes.vroom.core.dto.DataTransfertObject

/**
 * Created by E122371M on 07/12/15.
 */
abstract case class MaterielDTO(  val code: Int,
                                  val libelle: String,
                                  val tarif: DataTransfertObject) extends DataTransfertObject("Materiel") {

}
