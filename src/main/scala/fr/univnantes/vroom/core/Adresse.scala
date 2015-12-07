package fr.univnantes.vroom.core

import fr.univnantes.vroom.control.dto.AdresseDTO

/**
 * Classe représentant une adresse
 *
 * @constructor Crée une nouvelle adresse
 * @param numero Le numéro de rue qui correspond à l'adresse
 * @param adresse L'adresse en question
 * @param code Le code postal associé à l'adresse
 * @param ville Le nom de la ville associée à l'adresse
 */
case class Adresse( var numero: String,
                    var adresse: String,
                    var code: String,
                    var ville: String ) extends Persistable {

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
