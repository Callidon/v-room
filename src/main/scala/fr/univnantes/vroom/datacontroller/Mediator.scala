package fr.univnantes.vroom.datacontroller


import fr.univnantes.vroom.core._;

/**
 * Classe représentant un médiateur chargé de rediriger les données vers
 * les classes chargée de leur persistance dans la base de données
 */
class Mediator {

  private var _adresseManager : DataManager = null;
  private var _batimentManager : DataManager = null;
  private var _demandeurManager : DataManager = null;
  private var _reservationManager : DataManager = null;
  private var _salleManager : DataManager = null;

  //TODO remplacer Any par Persistable
  //TODO peut être mettre un type de retour aux fonctions (retourner l'bjet inséré par exemple)

  /**
   *
   * @pre les managers ont été set
   * @param donnee
   */
  def insert(donnee : Any) : Unit = donnee match {
    case Adresse => _adresseManager.insert(donnee)
    case Batiment => _batimentManager.insert(donnee)
    case Demandeur => _demandeurManager.insert(donnee)
    case Reservation => _reservationManager.insert(donnee)
    case Salle => _salleManager.insert(donnee)
    case _ => //TODO trouver le cas d'exception
  }

  /**
   *
   * @param donnee
   */
  def update(donnee : Any) : Unit = donnee match {
    case Adresse => _adresseManager.update(donnee)
    case Batiment => _batimentManager.update(donnee)
    case Demandeur => _demandeurManager.update(donnee)
    case Reservation => _reservationManager.update(donnee)
    case Salle => _salleManager.update(donnee)
    case _ => //TODO trouver le cas d'exception
  }

  /**
   *
   * @param donnee
   */
  def delete(donnee : Any) : Unit = donnee match {
    case Adresse => _adresseManager.delete(donnee)
    case Batiment => _batimentManager.delete(donnee)
    case Demandeur => _demandeurManager.delete(donnee)
    case Reservation => _reservationManager.delete(donnee)
    case Salle => _salleManager.delete(donnee)
    case _ => //TODO trouver le cas d'exception
  }

}
