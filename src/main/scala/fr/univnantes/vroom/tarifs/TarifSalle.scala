package fr.univnantes.vroom.tarifs

/**
 * Classe représentant un tarif lié à un type de salle
 *
 * @constructor Crée un nouveau tarif lié à une salle
 * @param code Le code qui représente de manière unique la tarif
 * @param libelle Le nom associé à ce tarif
 * @param tarif La valeur du tarif
 */
class TarifSalle(code: Int,
                 libelle: String,
                 tarif: Double) extends Tarif(code, libelle, tarif) {

}
