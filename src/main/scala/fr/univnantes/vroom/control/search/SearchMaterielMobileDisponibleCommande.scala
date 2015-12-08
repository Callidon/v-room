package fr.univnantes.vroom.control.search

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.materiel.MaterielMobileDTO

/**
 * EXIGENCE FONCTIONNELLE UC3.5
 */
class SearchMaterielMobileDisponibleCommande(system : Systeme,
                                             search_pred : (MaterielMobileDTO) => Boolean) extends Command[Set[MaterielMobileDTO]](system) {
  /**
   * Méthode exécutant la commande contre le système
   */
  override def execute(): Set[MaterielMobileDTO] = {
    system.searchMaterielMobileDisponible(search_pred)
  }
}
