package fr.univnantes.vroom.core.dto.tarifs

import fr.univnantes.vroom.core.persistable.Persistable
import fr.univnantes.vroom.core.persistable.tarifs.{TarifMateriel, TarifManifestation}

/**
  * Created by thomas on 07/12/15.
  */
class TarifMaterielDTO(code: Int,
                       libelle: String,
                       tarif: Double) extends TarifDTO(code, libelle, tarif) {

  override def toObject(): Persistable = new TarifMateriel(code, libelle, tarif)

}