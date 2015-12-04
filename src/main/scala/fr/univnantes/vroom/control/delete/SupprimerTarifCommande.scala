package fr.univnantes.vroom.control.delete

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.tarifs.Tarif

/**
  * EXIGENCE FONCTIONNELLE UC3.5
  */
class SupprimerTarifCommande (
                             system : Systeme,
                             tarif : Tarif
                             )extends Command[Unit](system){

  override def execute() : Unit = {
    system.popTarif(tarif)
    system.mediator.delete(tarif)
  }

}
