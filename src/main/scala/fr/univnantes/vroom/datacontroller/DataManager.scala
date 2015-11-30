package fr.univnantes.vroom.datacontroller

/**
 * Classe représentant un gestionnaire de données abstrait
 */
abstract class DataManager() {

  def insert(value: Any): Unit;

  def update(value: Any) : Unit;

  def delete(value : Any) : Unit;

}
