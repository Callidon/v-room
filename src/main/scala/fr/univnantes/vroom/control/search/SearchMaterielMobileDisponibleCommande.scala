package fr.univnantes.vroom.control.search

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.materiel.MaterielMobileDTO

/**
  * Commande de recherche pour matériel mobile
  * @param system  Objet utilisé pour le fonctionnement du logiciel
  * @param search_pred Prédicat de recherche
  */
class SearchMaterielMobileDisponibleCommande(system: Systeme,
                                             search_pred: (MaterielMobileDTO) => Boolean) extends Command[Set[MaterielMobileDTO]](system) {
  /**
    * Execute la commande
    * @return Set de DTO materiel mobile
    */
  override def execute(): Set[MaterielMobileDTO] = {
    system.searchMaterielMobileDisponible(search_pred)
  }
}
