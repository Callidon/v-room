package fr.univnantes.vroom.core.dto

/**
 * Created by E122371M on 07/12/15.
 */
case class DemandeurDTO(val no_dem: Int,
                        val nom: String,
                        val adresse: DataTransfertObject,
                        val origine: DataTransfertObject,
                        val titre: DataTransfertObject) extends DataTransfertObject("Demandeur") {

}
