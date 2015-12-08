package fr.univnantes.vroom.control.add

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.tarifs.TarifDTO
import fr.univnantes.vroom.datacontroller.Mediator

/**
 * Created by E122371M on 08/12/15.
 */
class AjouterTarifCommande(system: Systeme,
                           mediator: Mediator,
                           tarif: TarifDTO) extends Command[Unit](system) {

  override def execute(): Unit = {
    system.addTarif(tarif)
    mediator.insert(tarif)
  }

}
