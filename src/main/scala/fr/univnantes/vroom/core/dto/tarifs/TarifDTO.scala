package fr.univnantes.vroom.core.dto.tarifs

import fr.univnantes.vroom.core.dto.DataTransfertObject

/**
 * Created by E122371M on 07/12/15.
 */
abstract case class TarifDTO( val code: Int,
                              val libelle: String,
                              val tarif: Double) extends DataTransfertObject("Tarif") {

}
