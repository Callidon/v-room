package fr.univnantes.vroom.control.delete

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.dto.BatimentDTO
import fr.univnantes.vroom.core.{DTOManager, Systeme}
import fr.univnantes.vroom.datacontroller.Mediator

/**
  * Commande de suppression d'un batiment
  * @param system  Objet utilisé pour le fonctionnement du logiciel
  * @param mediator Objet utilisé pour la persistence des données
  * @param batiment DTO
  */
class SupprimerBatimentCommande(system: Systeme,
                                mediator: Mediator,
                                batiment: BatimentDTO) extends Command[Unit](system) {
  /**
    * Execute la commande
    */
  override def execute(): Unit = {
    DTOManager.deleteDto(batiment.no_bat)
    system.popBatiment(batiment)
    mediator.delete(batiment)
  }
}
