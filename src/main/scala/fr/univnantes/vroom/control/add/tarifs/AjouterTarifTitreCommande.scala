package fr.univnantes.vroom.control.add.tarifs

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.dto.tarifs.TarifTitreDTO
import fr.univnantes.vroom.core.persistable.tarifs.TarifTitre
import fr.univnantes.vroom.core.{DTOManager, Systeme}
import fr.univnantes.vroom.datacontroller.Mediator

/**
  * Created by folkvir on 07/12/15.
  */
class AjouterTarifTitreCommande(system : Systeme,
                                mediator : Mediator,
                                tarif : TarifTitreDTO
                                 ) extends Command[Unit](system) {
  override def execute() : Unit = {
    DTOManager.objectToDTO(tarif.code,new TarifTitre(tarif.code,tarif.libelle,tarif.tarif))
    system.addTarif(tarif)
    mediator.insert(tarif)
  }
}