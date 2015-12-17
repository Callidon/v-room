package fr.univnantes.vroom.core.dto

import fr.univnantes.vroom.core.persistable.{Adresse, Persistable}

/**
  * Classe représentant une Adresse
  * @param numero Int numéro de l'adresse
  * @param adresse String Libellé de l'adresse
  * @param code String code postal de la ville
  * @param ville String Nom de la Ville
  */
case class AdresseDTO(var numero: Int,
                      var adresse: String,
                      var code: String,
                      var ville: String) extends DataTransfertObject("Adresse") {
  /**
    * Transforme le DTO en objet concret du système
    * @return
    */
  override def toObject: Persistable = new Adresse(numero, adresse, code, ville)

}
