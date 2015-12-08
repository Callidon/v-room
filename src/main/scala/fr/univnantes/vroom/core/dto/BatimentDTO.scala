package fr.univnantes.vroom.core.dto

import fr.univnantes.vroom.core.DTOManager
import fr.univnantes.vroom.core.persistable.{Adresse, Batiment, Persistable}

/**
 * Projet : Default (Template) Project
 * Créé par E122371M le 07/12/15 à 23:05.
 *
 */
case class BatimentDTO( var no_bat: Int,
                        var nom: String,
                        var adresse: AdresseDTO) extends DataTransfertObject("Batiment") {

  override def toObject(): Persistable = new Batiment(no_bat, nom, DTOManager.dtoToObject(adresse.numero, adresse).asInstanceOf[Adresse])

}
