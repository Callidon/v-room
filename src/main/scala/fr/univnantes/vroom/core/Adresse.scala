package fr.univnantes.vroom.core

/**
 * Classe représentant une adresse
 *
 * @constructor Crée une nouvelle adresse
 * @param numero Le numéro de rue qui correspond à l'adresse
 * @param adresse L'adresse en question
 * @param code Le code postal associé à l'adresse
 * @param ville Le nom de la ville associée à l'adresse
 */
case class Adresse(var numero: String,
              var adresse: String,
              var code: String,
              var ville: String ) {

  //def unapply(adresse: Adresse): Option[(String, Adresse, String, String)] = Some(numero, adresse, code, ville);
}
