package fr.univnantes.vroom.core.dto.materiel

import fr.univnantes.vroom.core.DTOManager
import fr.univnantes.vroom.core.dto.tarifs.TarifMaterielDTO
import fr.univnantes.vroom.core.persistable.materiel.MaterielMobile
import fr.univnantes.vroom.core.persistable.tarifs.TarifMateriel

/**
  * CLasse représentant un matériel Mobile
  * @param code Entier, Code du materiel
  * @param libelle String, Libellé du materiel
  * @param tarif DTO, Tarif du matériel
  */
class MaterielMobileDTO(code: Int,
                        libelle: String,
                        tarif: TarifMaterielDTO) extends MaterielDTO(code, libelle, tarif) {
  /**
    * Méthode transformant le DTO en Objet pour le système
    * @return Retourne un objet concret du système
    */
  override def toObject(): MaterielMobile = new MaterielMobile(code, libelle, DTOManager.dtoToObject(tarif.code, tarif).asInstanceOf[TarifMateriel])

}
