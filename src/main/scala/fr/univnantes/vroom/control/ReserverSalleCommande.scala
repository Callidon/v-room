package fr.univnantes.vroom.control

import fr.univnantes.vroom.core.{Reservation, Systeme}

/**
 * Classe repésentant la commande ajoutant une salle au système
 */
class ReserverSalleCommande( system : Systeme,
                             reservation : Reservation ) extends Command(system) {

  /**
   * Méthode exécutant la commande contre le système
   */
  override def execute(): Unit = {

    system.addReservation(reservation);
    system.mediator.insert(reservation);

  }
}
