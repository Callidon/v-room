package fr.univnantes.vroom.core.dto

/**
 * Created by E122371M on 07/12/15.
 */
case class SalleDTO(val no_etage: Int,
                    val no_salle: Int,
                    val no_bat: Int,
                    val superficie: Int,
                    val batiment: DataTransfertObject,
                    val tarif : DataTransfertObject) extends DataTransfertObject("Salle") {

}
