package fr.univnantes.vroom.core.dto.materiel

import fr.univnantes.vroom.core.dto.DataTransfertObject

/**
  * Created by thomas on 07/12/15.
  */
class MaterielFixeDTO(code: Int,
                      libelle: String,
                      tarif: DataTransfertObject) extends MaterielDTO(code, libelle, tarif) {

}
