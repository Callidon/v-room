package fr.univnantes.vroom.core.dto

import fr.univnantes.vroom.core.DTOManager
import fr.univnantes.vroom.core.persistable.{Adresse, Batiment, Persistable}

/**
 * Created by E122371M on 07/12/15.
 */
case class BatimentDTO( val no_bat: Int,
                        val nom: String,
                        val adresse: AdresseDTO) extends DataTransfertObject("Batiment") {

  override def toObject(): Persistable = new Batiment(no_bat, nom, DTOManager.dtoToObject(adresse.numero, adresse).asInstanceOf[Adresse])

}
