package fr.univnantes.vroom.core.persistable.tarifs

/**
 * Classe représentant un tarif lié à l'origine du demandeur
 *
 * @constructor Crée un nouveau tarif lié à l'origine du demandeur
 * @param code Le code qui représente de manière unique la tarif
 * @param libelle Le nom associé à ce tarif
 * @param tarif La valeur du tarif
 */
class TarifOrigine(code: Int,
                   libelle: String,
                   tarif: Double) extends Tarif(code, libelle, tarif) {

}
