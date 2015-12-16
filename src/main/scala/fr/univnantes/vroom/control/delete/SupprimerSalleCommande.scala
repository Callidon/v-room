package fr.univnantes.vroom.control.delete

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.dto.SalleDTO
import fr.univnantes.vroom.core.{DTOManager, Systeme}
import fr.univnantes.vroom.datacontroller.Mediator

/**
  *
  * Commande de suppression d'une salle
  * @param system  Objet utilisé pour le fonctionnement du logiciel
  * @param mediator Objet utilisé pour la persistence des données
  * @param salle DTO
  */
class SupprimerSalleCommande(system: Systeme,
                             mediator: Mediator,
                             salle: SalleDTO) extends Command[Unit](system) {
  /**
    * Execute la commande
    */
  override def execute(): Unit = {
    DTOManager.deleteDto(salle.no_salle)
    system.popSalle(salle)
    mediator.delete(salle)
  }
}
