package fr.univnantes.vroom.control.add

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.control.dto.BatimentDTO
import fr.univnantes.vroom.core.{Batiment, Systeme}
import fr.univnantes.vroom.datacontroller.Mediator

/**
  * EXIGENCE FONCTIONNELLE UC3.1
 * Classe repésentant la commande ajoutant un batiment au système
 */
class AjouterBatimentCommande(system : Systeme,
                              mediator : Mediator,
                              batiment : BatimentDTO ) extends Command[Unit](system) {

  /**
   * Méthode exécutant la commande contre le système
   */
  override def execute(): Unit = {

    system.addBatiment(batiment)
    mediator.insert(batiment)

  }
}
