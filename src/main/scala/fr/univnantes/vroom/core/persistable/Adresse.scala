package fr.univnantes.vroom.core.persistable

import fr.univnantes.vroom.core.dto.{AdresseDTO, DataTransfertObject}

/**
 * Classe représentant une adresse
 *
 * @constructor Crée une nouvelle adresse
 * @param numero Le numéro de rue qui correspond à l'adresse
 * @param adresse L'adresse en question
 * @param code Le code postal associé à l'adresse
 * @param ville Le nom de la ville associée à l'adresse
 */
case class Adresse( var numero: Int,
                    var adresse: String,
                    var code: String,
                    var ville: String ) extends Persistable {

  override def toDTO() = new AdresseDTO(numero, adresse, code, ville)

  /**
    * Affiche les informations de l'adresse
    * @return
    */
  override def toString: String = " Adresse :  " +
    " \n  | Numero : " + numero +
    " \n  | Adresse : " + adresse +
    " \n  | Code postal : " + code +
    " \n  | Ville : " + ville
}
