package fr.univnantes.vroom.control.add

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.{Salle, Systeme}
import fr.univnantes.vroom.datacontroller.Mediator

/**
  * EXIGENCE FONCTIONNELLE UC2.1
 * Classe repésentant la commande ajoutant une salle au système
 */
class AjouterSalleCommande(system : Systeme,
                           mediator : Mediator,
                           salle : Salle ) extends Command[Unit](system) {

  /**
   * Méthode exécutant la commande contre le système
   */
  override def execute(): Unit = {

    system.addSalle(salle)
    mediator.insert(salle)

  }
}
