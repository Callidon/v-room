package fr.univnantes.vroom.control

import fr.univnantes.vroom.core.Systeme


/**
  * Classe paramétrable représentant une commande concrète
  * @param system  Objet utilisé pour le fonctionnement du logiciel
  * @tparam R Type de retour,
  */
abstract class Command[R](system: Systeme) {

  /**
    * Méthode exécutant la commande contre le système
    */
  def execute(): R

}
