package fr.univnantes.vroom.control.add.tarifs

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.dto.tarifs.TarifMaterielDTO
import fr.univnantes.vroom.core.persistable.tarifs.TarifMateriel
import fr.univnantes.vroom.core.{DTOManager, Systeme}
import fr.univnantes.vroom.datacontroller.Mediator

/**
  * Created by folkvir on 07/12/15.
  */
class AjouterTarifMaterielCommande(system: Systeme,
                                   mediator: Mediator,
                                   tarif: TarifMaterielDTO
                                 ) extends Command[Unit](system) {
  override def execute(): Unit = {
    DTOManager.objectToDTO(tarif.code, new TarifMateriel(tarif.code, tarif.libelle, tarif.tarif))
    system.addTarif(tarif)
    mediator.insert(tarif)
  }
}