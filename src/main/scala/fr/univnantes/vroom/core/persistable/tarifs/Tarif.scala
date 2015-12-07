package fr.univnantes.vroom.core.persistable.tarifs

import fr.univnantes.vroom.core.dto.tarifs.TarifDTO
import fr.univnantes.vroom.core.persistable.Persistable

/**
 * Classe abstraite représentant un tarif
 *
 * @constructor Crée un nouveau tarif
 * @param code Le code qui représente de manière unique la tarif
 * @param libelle Le nom associé à ce tarif
 * @param tarif La valeur du tarif
 */
abstract case class Tarif(var code: Int,
                          var libelle: String,
                          var tarif: Double) extends Persistable {

  /**
    * Affiche les informations relatives au tarif
    * @return
    */
  override def toString : String = " Type de tarif : "+
    " \n  | Code :" + code +
    " \n  | Libelle :" + libelle +
    " \n  | Tarif :" + tarif
}
