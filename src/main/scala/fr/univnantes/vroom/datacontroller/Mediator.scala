package fr.univnantes.vroom.datacontroller

/**
 * Classe représentant un médiateur chargé de rediriger les données vers
 * les classes chargée de leur persistance dans la base de données
 * @constructor Crée un nouveau médiateur
 */
class Mediator() {

  // Collection des gestionnaires utilisés par le médiateur
  private var _managers : Map[String, DataManager] = Map[String,DataManager]()

  /**
    * Méthode qui enregistre un gestionnaire pour un type de donnée
    * @param manager Le gestionnaire que l'on veut enregistrer
    */
  def registerManager(type_donnee : String, manager : DataManager) : Unit = _managers += (type_donnee -> manager)

  /**
    * Méthode qui récupère un gestionnaire pour un type de donnée
    * @param type_donnee Le type de donnée que gère le gestionnaire que l'on veut récupérer
    * @return Le gestionnaire qui gère le type de donnée voulue
    */
  def getManager(type_donnee : String) : DataManager = _managers(type_donnee)

  /**
    * Méthode récupérant une donnée d'un type précis via le bon gestionnaire
    * @param id L'identifiant unique de la donnée
    * @param type_donnee Le type de la donnée
    * @return La donnée correspondant à l'identifiant
    */
  def get(id : Int, type_donnee : String) : Any = getManager(type_donnee).get(id)

  /**
    * Méthode récupérant toutes données pour un type précis via le bon gestionnaire
    * @param type_donnee Le type des données à récupérer
    * @return L'esenbmel des données correspondant au type précisé
    */
  def getAll(type_donnee : String) : Set[_] = getManager(type_donnee).getAll()

  /**
   * Méthode effectuant l'insertion d'une donnée dans la source de données via le bon gestionnaire
   * @param donnee La donnée à insérer
   */
  def insert(donnee : Any) : Unit = getManager(donnee.getClass.getSimpleName).insert(donnee)

  /**
   * Méthode effectuant la mise à jour d'une donnée dans la source de données via le bon gestionnaire
   * @param donnee La donnée à mettre à jour
   */
  def update(donnee : Any) : Unit = getManager(donnee.getClass.getSimpleName).update(donnee)

  /**
   * Méthode effectuant la suppression d'une donnée dans la source de données via le bon gestionnaire
   * @param donnee La donnée à supprimer
   */
  def delete(donnee : Any) : Unit = getManager(donnee.getClass.getSimpleName).delete(donnee)

}
