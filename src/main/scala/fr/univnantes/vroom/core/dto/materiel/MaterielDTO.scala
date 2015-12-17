package fr.univnantes.vroom.core.dto.materiel

import fr.univnantes.vroom.core.dto.DataTransfertObject

/**
  * CLasse Abstrait représentant un matériel
  * @param code Entier, Code du materiel
  * @param libelle String, Libellé du materiel
  * @param tarif DTO, Tarif du matériel
  */
abstract case class MaterielDTO(  var code: Int,
                                  var libelle: String,
                                  var tarif: DataTransfertObject) extends DataTransfertObject("Materiel") {

}
