package fr.univnantes.vroom.control.update

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.{Reservation, Systeme}

/**
 * Created by E122371M on 30/11/15.
 */
class UpdateReservationCommande (system : Systeme,
                                 ancien_reservation : Reservation,
                                 nouveau_reservation : Reservation ) extends Command[Unit](system) {

  /**
    * Méthode exécutant la commande contre le système
    */
  override def execute(): Unit = {
    //On supprime l'ancienne version
    system.popReservation(ancien_reservation)
    system.mediator.delete(ancien_reservation)

    //On ajoute la nouvelle
    system.addBatiment(nouveau_reservation)
    system.mediator.insert(nouveau_reservation)

  }
}
