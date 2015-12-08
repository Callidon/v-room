package fr.univnantes.vroom.core.dto

import fr.univnantes.vroom.core.persistable.{Adresse, Persistable}

/**
 * Created by E122371M on 07/12/15.
 */
case class AdresseDTO(val numero: Int,
                      val adresse: String,
                      val code: String,
                      val ville: String) extends DataTransfertObject("Adresse") {

  override def toObject(): Persistable = new Adresse(numero, adresse, code, ville)

}
