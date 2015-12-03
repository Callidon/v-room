package fr.univnantes.vroom.control.update

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.{Batiment, Systeme}

/**
  * Created by folkvir on 03/12/15.
  */
class UpdateBatimentCommande (system : Systeme,
                              ancien_batiment : Batiment,
                              nouveau_batiment : Batiment ) extends Command[Unit](system) {

  /**
    * Méthode exécutant la commande contre le système
    */
  override def execute(): Unit = {
    //On supprime l'ancienne version
    system.popBatiment(ancien_batiment)
    system.mediator.delete(ancien_batiment)

    //On ajoute la nouvelle
    system.addBatiment(nouveau_batiment)
    system.mediator.insert(nouveau_batiment)

  }
}
