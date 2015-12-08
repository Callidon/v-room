package fr.univnantes.vroom.core.dto

import fr.univnantes.vroom.core.persistable.{Adresse, Persistable}

/**
 * Projet : Default (Template) Project
 * Créé par E122371M le 07/12/15 à 23:05.
 *
 */
case class AdresseDTO(var numero: Int,
                      var adresse: String,
                      var code: String,
                      var ville: String) extends DataTransfertObject("Adresse") {

  override def toObject(): Persistable = new Adresse(numero, adresse, code, ville)

}
