package fr.univnantes.vroom.control.dto

/**
 * Created by E122371M on 07/12/15.
 */
case class TarifDTO(val code: Int,
                    val libelle: String,
                    val tarif: Double) extends DataTransfertObject("Tarif") {

}
