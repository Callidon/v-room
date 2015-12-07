package fr.univnantes.vroom.control.delete

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.dto.tarifs.TarifDTO
import fr.univnantes.vroom.core.{DTOManager, Systeme}
import fr.univnantes.vroom.datacontroller.Mediator

/**
  * EXIGENCE FONCTIONNELLE UC3.5
  */
class SupprimerTarifCommande( system : Systeme,
                              mediator: Mediator,
                              tarif : TarifDTO)extends Command[Unit](system){

  override def execute() : Unit = {
    DTOManager.deleteDto(tarif.code)
    system.popTarif(tarif)
    mediator.delete(tarif)
  }

}
