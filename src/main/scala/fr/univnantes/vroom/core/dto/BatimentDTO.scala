package fr.univnantes.vroom.core.dto

import fr.univnantes.vroom.core.DTOManager
import fr.univnantes.vroom.core.persistable.{Adresse, Batiment, Persistable}

/**
  * Classe représentant une batiment
  * @param no_bat Int numéro du batiment
  * @param nom String nom du batiment
  * @param adresse DTO représentant l'adresse du batiment
  */
case class BatimentDTO(var no_bat: Int,
                       var nom: String,
                       var adresse: AdresseDTO) extends DataTransfertObject("Batiment") {
  /**
    * Transforme le DTO en objet concret du système
    * @return
    */
  override def toObject: Persistable = new Batiment(no_bat, nom, DTOManager.dtoToObject(adresse.numero, adresse).asInstanceOf[Adresse])

}
