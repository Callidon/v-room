package fr.univnantes.vroom.core.dto.tarifs

import fr.univnantes.vroom.core.persistable.Persistable
import fr.univnantes.vroom.core.persistable.tarifs.{TarifSalle, TarifManifestation}

/**
  * Created by thomas on 07/12/15.
  */
class TarifSalleDTO(code: Int,
                    libelle: String,
                    tarif: Double) extends TarifDTO(code, libelle, tarif) {

  override def toObject(): Persistable = new TarifSalle(code, libelle, tarif)

}
