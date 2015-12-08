package fr.univnantes.vroom.core.dto.materiel

import fr.univnantes.vroom.core.DTOManager
import fr.univnantes.vroom.core.dto.tarifs.TarifMaterielDTO
import fr.univnantes.vroom.core.persistable.materiel.MaterielFixe
import fr.univnantes.vroom.core.persistable.tarifs.TarifMateriel

/**
  * Created by thomas on 07/12/15.
  */
class MaterielFixeDTO(code: Int,
                      libelle: String,
                      tarif: TarifMaterielDTO) extends MaterielDTO(code, libelle, tarif) {

  override def toObject(): MaterielFixe = new MaterielFixe(code, libelle, DTOManager.dtoToObject(tarif.code, tarif).asInstanceOf[TarifMateriel])
}
