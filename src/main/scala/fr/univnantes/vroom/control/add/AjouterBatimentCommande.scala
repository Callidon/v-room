package fr.univnantes.vroom.control.add

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.{Batiment, Systeme}

/**
 * Classe repésentant la commande ajoutant un batiment au système
 */
class AjouterBatimentCommande(system : Systeme,
                              batiment : Batiment ) extends Command[Unit](system) {

  /**
   * Méthode exécutant la commande contre le système
   */
  override def execute(): Unit = {

    system.addBatiment(batiment)
    system.mediator.insert(batiment)

  }
}
