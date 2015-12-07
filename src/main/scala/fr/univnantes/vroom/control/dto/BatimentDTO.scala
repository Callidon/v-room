package fr.univnantes.vroom.control.dto

/**
 * Created by E122371M on 07/12/15.
 */
case class BatimentDTO( val no_bat: Int,
                        val nom: String,
                        val adresse: AdresseDTO) extends DataTransfertObject("Batiment") {

}
