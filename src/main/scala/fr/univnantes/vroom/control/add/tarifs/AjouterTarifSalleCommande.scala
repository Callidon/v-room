package fr.univnantes.vroom.control.add.tarifs

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.dto.tarifs.TarifSalleDTO
import fr.univnantes.vroom.core.persistable.tarifs.TarifSalle
import fr.univnantes.vroom.core.{DTOManager, Systeme}
import fr.univnantes.vroom.datacontroller.Mediator

/**
  * Created by folkvir on 07/12/15.
  */
class AjouterTarifSalleCommande( system : Systeme,
                                 mediator : Mediator,
                                 tarif : TarifSalleDTO
                                 ) extends Command[Unit](system) {
  override def execute() : Unit = {
    DTOManager.objectToDTO(tarif.code,new TarifSalle(tarif.code,tarif.libelle,tarif.tarif))
    system.addTarif(tarif)
    mediator.insert(tarif)
  }
}