package fr.univnantes.vroom.control.update

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.tarifs.TarifDTO
import fr.univnantes.vroom.datacontroller.Mediator

/**
  * Commande d'update d'un tarif
  * @param system  Objet utilisé pour le fonctionnement du logiciel
  * @param mediator Objet utilisé pour la persistence des données
  * @param ancien_tarif ancien DTO
  * @param nouveau_tarif nouveau DTO
  */
class UpdateTarifCommande(
                           system: Systeme,
                           mediator: Mediator,
                           ancien_tarif: TarifDTO,
                           nouveau_tarif: TarifDTO
                         ) extends Command[Unit](system) {
  /**
    * Méthode exécutant la commande contre le système
    */
  override def execute(): Unit = {
    //On supprime l'ancienne version
    system.popTarif(ancien_tarif)
    //On ajoute la nouvelle
    system.addTarif(nouveau_tarif)
    mediator.update(nouveau_tarif)
  }
}
