package fr.univnantes.vroom.control.search

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.materiel.MaterielFixeDTO

/**
  * Commande de recherche pour matériel fixe
  * @param system  Objet utilisé pour le fonctionnement du logiciel
  * @param search_pred Prédicat de recherche
  */
class SearchMaterielFixeDisponibleCommande(system: Systeme,
                                           search_pred: (MaterielFixeDTO) => Boolean) extends Command[Set[MaterielFixeDTO]](system) {
  /**
    * Execute la commande
    * @return Set de DTO materiel fixe
    */
  override def execute(): Set[MaterielFixeDTO] = {
    system.searchMaterielFixeDisponible(search_pred)
  }
}
