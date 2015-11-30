package fr.univnantes.vroom.control.search

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.{Demandeur, Systeme}

/**
 * Created by E122371M on 30/11/15.
 */
class SearchDemandeurCommande(
                                 system : Systeme,
                                 search_pred : (Demandeur) => Boolean
                                 ) extends Command[Set[Demandeur]](system) {
  /**
   * Méthode exécutant la commande contre le système
   */
  override def execute(): Set[Demandeur] = {
    system.searchDemandeur(search_pred)
  }
}
