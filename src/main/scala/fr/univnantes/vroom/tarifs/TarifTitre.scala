package fr.univnantes.vroom.tarifs

/**
 * Classe représentant un tarif lié au titre du demandeur
 *
 * @constructor Crée un nouveau tarif lié au titre du demandeur
 * @param code Le code qui représente de manière unique la tarif
 * @param libelle Le nom associé à ce tarif
 * @param tarif La valeur du tarif
 */
class TarifTitre(code: Int,
                 libelle: String,
                 tarif: Double) extends Tarif(code, libelle, tarif) {

}
