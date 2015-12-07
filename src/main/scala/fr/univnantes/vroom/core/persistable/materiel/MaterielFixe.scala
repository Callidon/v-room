package fr.univnantes.vroom.core.persistable.materiel

import fr.univnantes.vroom.core.persistable.tarifs.TarifMateriel

/**
 * Classe abstraite représentant un matériel fixe
 *
 * @constructor Crée un nouveau matériel fixe
 * @param code Un code unique représentant le matériel
 * @param libelle le nom du matériel
 * @param tarif Le tarif correspondant à ce matériel
 */
class MaterielFixe(code: Int,
                   libelle: String,
                   tarif: TarifMateriel ) extends Materiel(code, libelle, tarif) {

}
