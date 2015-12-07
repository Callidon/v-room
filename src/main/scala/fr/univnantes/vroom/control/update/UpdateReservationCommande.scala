package fr.univnantes.vroom.control.update

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.persistable.Reservation
import fr.univnantes.vroom.datacontroller.Mediator

class UpdateReservationCommande(system : Systeme,
                                mediator: Mediator,
                                ancien_reservation : Reservation,
                                nouveau_reservation : Reservation ) extends Command[Unit](system) {

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
