package fr.univnantes.vroom.core.dto.tarifs

import fr.univnantes.vroom.core.persistable.Persistable
import fr.univnantes.vroom.core.persistable.tarifs.{TarifOrigine, TarifManifestation}

/**
  * Created by thomas on 07/12/15.
  */
class TarifOrigineDTO(code: Int,
                      libelle: String,
                      tarif: Double) extends TarifDTO(code, libelle, tarif) {

  override def toObject(): Persistable = new TarifOrigine(code, libelle, tarif)

}
