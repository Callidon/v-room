package fr.univnantes.vroom.control.update

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.ReservationDTO
import fr.univnantes.vroom.datacontroller.Mediator

/**
  * Commande pour mettre à jour une réservation
  */
class UpdateReservationCommande(system : Systeme,
                                mediator: Mediator,
                                ancien_reservation : ReservationDTO,
                                nouveau_reservation : ReservationDTO ) extends Command[Unit](system) {

  /**
    * Méthode exécutant la commande contre le système
    */
  override def execute(): Unit = {
    //On supprime l'ancienne version
    system.popReservation(ancien_reservation)
    //On ajoute la nouvelle
    system.addReservation(nouveau_reservation)
    mediator.update(nouveau_reservation)
  }
}
