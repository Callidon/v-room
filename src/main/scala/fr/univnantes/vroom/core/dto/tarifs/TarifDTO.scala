package fr.univnantes.vroom.core.dto.tarifs

import fr.univnantes.vroom.core.dto.DataTransfertObject

/**
  * Classe abstrait représentant un tarif
  * @param code Int, Code tu tarif
  * @param libelle String, Libellé du tarif
  * @param tarif Double, Valeur du tarif
  */
abstract case class TarifDTO(var code: Int,
                             var libelle: String,
                             var tarif: Double) extends DataTransfertObject("Tarif") {

}
