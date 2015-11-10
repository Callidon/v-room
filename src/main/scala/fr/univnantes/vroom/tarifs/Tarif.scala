package fr.univnantes.vroom.tarifs

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
                     var tarif: Double);
