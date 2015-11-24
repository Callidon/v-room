package fr.univnantes.vroom.datacontroller


import fr.univnantes.vroom.core._;

/**
 * Classe représentant un médiateur chargé de rediriger les données vers
 * les classes chargée de leur persistance dans la base de données
 */
class Mediator(adresseManager : DataManager,
               batimentManager : DataManager,
               demandeurManager : DataManager,
               reservationManager : DataManager,
               salleManager : DataManager ) {

  //TODO remplacer Any par Persistable
  //TODO peut être mettre un type de retour aux fonctions (retourner l'bjet inséré par exemple)

  /**
   *
   * @param donnee
   */
  def insert(donnee : Any) : Unit = donnee match {
    case _ : Adresse => adresseManager.insert(donnee)
    case _ : Batiment => batimentManager.insert(donnee)
    case _ : Demandeur => demandeurManager.insert(donnee)
    case _ : Reservation => reservationManager.insert(donnee)
    case _ : Salle => salleManager.insert(donnee)
    case _ => //TODO trouver le cas d'exception
  }

  /**
   *
   * @param donnee
   */
  def update(donnee : Any) : Unit = donnee match {
    case _ : Adresse => adresseManager.update(donnee)
    case _ : Batiment => batimentManager.update(donnee)
    case _ : Demandeur => demandeurManager.update(donnee)
    case _ : Reservation => reservationManager.update(donnee)
    case _ : Salle => salleManager.update(donnee)
    case _ => //TODO trouver le cas d'exception
  }

  /**
   *
   * @param donnee
   */
  def delete(donnee : Any) : Unit = donnee match {
    case _ : Adresse => adresseManager.delete(donnee)
    case _ : Batiment => batimentManager.delete(donnee)
    case _ : Demandeur => demandeurManager.delete(donnee)
    case _ : Reservation => reservationManager.delete(donnee)
    case _ : Salle => salleManager.delete(donnee)
    case _ => //TODO trouver le cas d'exception
  }

}
