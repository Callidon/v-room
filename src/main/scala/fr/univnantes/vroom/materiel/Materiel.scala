package fr.univnantes.vroom.materiel

import fr.univnantes.vroom.tarifs.TarifMateriel

/**
 * Classe abstraite représentant un matériel
 *
 * @constructor Crée un nouveau matériel
 * @param code Un code unique représentant le matériel
 * @param libelle le nom du matériel
 * @param tarif Le tarif correspondant à ce matériel
 */
abstract class Materiel(var code: Int,
                        var libelle: String,
                        var tarif: TarifMateriel );
