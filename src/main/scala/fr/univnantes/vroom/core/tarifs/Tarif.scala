package fr.univnantes.vroom.core.tarifs

/**
 * Classe abstraite représentant un tarif
 *
 * @constructor Crée un nouveau tarif
 * @param code Le code qui représente de manière unique la tarif
 * @param libelle Le nom associé à ce tarif
 * @param tarif La valeur du tarif
 */
abstract class Tarif(var code: Int,
                     var libelle: String,
                     var tarif: Double){

  /**
    * Affiche les informations relatives au tarif
    * @return
    */
  override def toString : String = " Type de tarif : "+
    " \n  | Code :" + code +
    " \n  | Libelle :" + libelle +
    " \n  | Tarif :" + tarif
}
