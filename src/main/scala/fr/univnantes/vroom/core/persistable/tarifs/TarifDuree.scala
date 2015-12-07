package fr.univnantes.vroom.core.persistable.tarifs

/**
 * Classe représentant un tarif lié à la durée d'un évènement
 *
 * @constructor Crée un nouveau tarif lié à la durée d'un évènement
 * @param code Le code qui représente de manière unique la tarif
 * @param libelle Le nom associé à ce tarif
 * @param tarif La valeur du tarif
 */
class TarifDuree(code: Int,
                 libelle: String,
                 tarif: Double) extends Tarif(code, libelle, tarif) {

}
