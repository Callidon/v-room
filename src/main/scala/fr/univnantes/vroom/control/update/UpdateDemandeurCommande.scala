package fr.univnantes.vroom.control.update

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.DemandeurDTO
import fr.univnantes.vroom.datacontroller.Mediator

/**
  * Commande d'update de demandeur
  * @param system  Objet utilisé pour le fonctionnement du logiciel
  * @param mediator Objet utilisé pour la persistence des données
  * @param old_demandeur ancien DTO
  * @param new_demandeur nouveau DTO
  */
class UpdateDemandeurCommande(
                               system: Systeme,
                               mediator: Mediator,
                               old_demandeur: DemandeurDTO,
                               new_demandeur: DemandeurDTO
                             ) extends Command[Unit](system) {
  /**
    * Méthode exécutant la commande contre le système
    */
  override def execute(): Unit = {
    system.popDemandeur(old_demandeur)
    system.addDemandeur(new_demandeur)
    mediator.update(new_demandeur)
  }

}
