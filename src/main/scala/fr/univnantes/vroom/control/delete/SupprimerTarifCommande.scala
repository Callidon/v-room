package fr.univnantes.vroom.control.delete

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.tarifs.Tarif
import fr.univnantes.vroom.datacontroller.Mediator

/**
  * EXIGENCE FONCTIONNELLE UC3.5
  */
class SupprimerTarifCommande( system : Systeme,
                              mediator: Mediator,
                              tarif : Tarif)extends Command[Unit](system){

  override def execute() : Unit = {
    system.popTarif(tarif)
    mediator.delete(tarif)
  }

}
