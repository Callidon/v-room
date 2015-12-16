package fr.univnantes.vroom.control.delete

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.DemandeurDTO
import fr.univnantes.vroom.datacontroller.Mediator

/**
  * Commande de suppression d'un emandeur
  * @param system  Objet utilisé pour le fonctionnement du logiciel
  * @param mediator Objet utilisé pour la persistence des données
  * @param demandeur DTO
  */
class SupprimerDemandeurCommande(
                                  system: Systeme,
                                  mediator: Mediator,
                                  demandeur: DemandeurDTO
                                ) extends Command[Unit](system) {
  /**
    * Execute la commande
    */
  override def execute(): Unit = {
    system.popDemandeur(demandeur)
    mediator.delete(demandeur)
  }

}
