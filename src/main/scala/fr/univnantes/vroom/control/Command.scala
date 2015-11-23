package fr.univnantes.vroom.control

import fr.univnantes.vroom.core.Systeme

/**
 * Classe représentant une commande concrète
 */
abstract class Command(system : Systeme) {

  /**
   * Méthode exécutant la commande contre le système
   */
  def execute() : Unit;

}
