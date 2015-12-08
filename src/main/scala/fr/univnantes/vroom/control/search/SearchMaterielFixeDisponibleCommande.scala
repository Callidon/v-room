package fr.univnantes.vroom.control.search

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.materiel.MaterielFixeDTO

/**
 * EXIGENCE FONCTIONNELLE UC3.5
 */
class SearchMaterielFixeDisponibleCommande(system : Systeme,
                                           search_pred : (MaterielFixeDTO) => Boolean) extends Command[Set[MaterielFixeDTO]](system) {
  /**
   * Méthode exécutant la commande contre le système
   */
  override def execute(): Set[MaterielFixeDTO] = {
    system.searchMaterielFixeDisponible(search_pred)
  }
}
