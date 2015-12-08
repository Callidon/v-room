package fr.univnantes.vroom.control.update

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.SalleDTO
import fr.univnantes.vroom.datacontroller.Mediator

/**
  * Commande pour mettre à jour une réservation
  */
class UpdateSalleCommande(system : Systeme,
                          mediator: Mediator,
                          ancien_salle : SalleDTO,
                          nouveau_salle : SalleDTO ) extends Command[Unit](system) {

  /**
    * Méthode exécutant la commande contre le système
    */
  override def execute(): Unit = {
    //On supprime l'ancienne version
    system.popSalle(ancien_salle)
    //On ajoute la nouvelle
    system.addSalle(nouveau_salle)
    mediator.update(nouveau_salle)
  }
}
