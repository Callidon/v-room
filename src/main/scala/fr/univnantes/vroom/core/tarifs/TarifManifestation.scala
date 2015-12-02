package fr.univnantes.vroom.core.tarifs

/**
 * Classe représentant un tarif lié à un type de manifestation
 *
 * @constructor Crée un nouveau tarif lié à une manifestation
 * @param code Le code qui représente de manière unique la tarif
 * @param libelle Le nom associé à ce tarif
 * @param tarif La valeur du tarif
 */
class TarifManifestation(code: Int,
                         libelle: String,
                         tarif: Double) extends Tarif(code, libelle, tarif) {

}
