package fr.univnantes.vroom.control.add

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.DemandeurDTO
import fr.univnantes.vroom.datacontroller.Mediator

/**
  * Commande d'ajout d'un demandeur
  * @param system  Objet utilisé pour le fonctionnement du logiciel
  * @param mediator Objet utilisé pour la persistence des données
  * @param demandeur DTO
  */
class AjouterDemandeurCommande(
                                system: Systeme,
                                mediator: Mediator,
                                demandeur: DemandeurDTO
                              ) extends Command[Unit](system) {
  /**
    * Méthode exécutant la commande contre le système
    */
  override def execute(): Unit = {
    system.addDemandeur(demandeur)
    mediator.insert(demandeur)
  }
}
