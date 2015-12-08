package fr.univnantes.vroom.core.persistable.materiel

import fr.univnantes.vroom.core.dto.DataTransfertObject
import fr.univnantes.vroom.core.dto.materiel.MaterielMobileDTO
import fr.univnantes.vroom.core.persistable.tarifs.TarifMateriel

/**
 * Classe abstraite représentant un matériel mobile
 *
 * @constructor Crée un nouveau matériel mobile
 * @param code Un code unique représentant le matériel
 * @param libelle le nom du matériel
 * @param tarif Le tarif correspondant à ce matériel
 */
class MaterielMobile(code: Int,
                     libelle: String,
                     tarif: TarifMateriel ) extends Materiel(code, libelle, tarif) {

  override def toDTO() = new MaterielMobileDTO(code, libelle, tarif.toDTO())

}
