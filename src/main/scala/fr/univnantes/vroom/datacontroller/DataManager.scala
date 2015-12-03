package fr.univnantes.vroom.datacontroller

/**
 * Classe représentant un gestionnaire de données abstrait
  * @constructor Crée un nouveau gestionnaire de données
  * @param source La source de données avec laquelle le gestionnaire interagit
 */
abstract class DataManager[T](source: DataSource) {

  /**
    * Méthode récupérant une donnée de type T depuis la source de données
    * @param id L'identifiant unique de la donnée à récupérer
    * @return La donnée correspondant à l'identifiant
    */
  def get(id : Int) : T

  /**
    * Méthode récupérant l'ensemble des données gérée par le gestionnaire
    * @return L'ensemble des données gérée par le gestionnaire
    */
  def getAll() : Set[T]

  /**
    * Méthode insérant une donnée de type T dans la source de données
    * @param donnee La donnée à insérer
    */
  def insert(donnee: Any): Unit

  /**
    * Méthode mettant à jour une donnée dans la source de données
    * @param donnee La donnée à mettre à jour
    */
  def update(donnee: Any) : Unit

  /**
    * Méthode supprimant une donnée de la source de données
    * @param donnee La donnée à supprimer
    */
  def delete(donnee : Any) : Unit

}
