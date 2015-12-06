package fr.univnantes.vroom.control.update

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.{Batiment, Systeme}
import fr.univnantes.vroom.datacontroller.Mediator

/**
  * EXIGENCE FONCTIONNELLE UC3.3
  */
class UpdateBatimentCommande(system : Systeme,
                             mediator: Mediator,
                             ancien_batiment : Batiment,
                             nouveau_batiment : Batiment ) extends Command[Unit](system) {

  /**
    * Méthode exécutant la commande contre le système
    */
  override def execute(): Unit = {
    //On supprime l'ancienne version
    system.popBatiment(ancien_batiment)
    //On ajoute la nouvelle
    system.addBatiment(nouveau_batiment)

    mediator.update(nouveau_batiment)

  }
}
