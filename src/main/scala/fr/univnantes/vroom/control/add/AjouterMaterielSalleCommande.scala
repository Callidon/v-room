package fr.univnantes.vroom.control.add

import fr.univnantes.vroom.control.Command
import fr.univnantes.vroom.core.Systeme
import fr.univnantes.vroom.core.dto.SalleDTO
import fr.univnantes.vroom.core.dto.materiel.MaterielDTO
import fr.univnantes.vroom.datacontroller.Mediator

/**
  * EXIGENCE FONCTIONNELLE UC2.1
 * Classe repésentant la commande ajoutant une salle au système
 */
class AjouterMaterielSalleCommande(system : Systeme,
                                   mediator : Mediator,
                                   salle : SalleDTO,
                                   materiel : MaterielDTO ) extends Command[Unit](system) {

  /**
   * Méthode exécutant la commande contre le système
   */
  override def execute(): Unit = {
    val new_salle = system.addMaterielFixe(salle,materiel).asInstanceOf[SalleDTO]
    system.popSalle(salle)
    system.addSalle(new_salle)
    mediator.update(new_salle)

  }
}
