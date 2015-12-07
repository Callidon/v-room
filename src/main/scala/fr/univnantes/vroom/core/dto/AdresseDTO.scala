package fr.univnantes.vroom.core.dto

/**
 * Created by E122371M on 07/12/15.
 */
case class AdresseDTO(val numero: String,
                      val adresse: String,
                      val code: String,
                      val ville: String) extends DataTransfertObject("Adresse") {

}
