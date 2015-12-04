package fr.univnantes.vroom.control.add

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.tarifs.Tarif

/**
  * EXIGENCE FONCTIONNELLE UC3.5
  */
class AjouterTarifCommande (
                                 system : Systeme,
                                 tarif : Tarif
                               ) extends Command[Unit](system){
  override def execute() : Unit = {
    system.addTarif(tarif)
    system.mediator.insert(tarif)
  }
}
