package fr.univnantes.vroom.datacontroller


import fr.univnantes.vroom.core._;

/**
 * Classe représentant un médiateur chargé de rediriger les données vers
 * les classes chargée de leur persistance dans la base de données
 * @constructor Crée un nouveau médiateur
 * @param adresseManager Le gestionnaire de données pour les objets de type Adresse
 * @param batimentManager Le gestionnaire de données pour les objets de type Batiment
 * @param reservationManager Le gestionnaire de données pour les objets de type Reservation
 * @param salleManager Le gestionnaire de données pour les objets de type Salle
 */
class Mediator(adresseManager : DataManager,
               batimentManager : DataManager,
               demandeurManager : DataManager,
               reservationManager : DataManager,
               salleManager : DataManager ) {

  /**
   * Méthode effectuant l'insertion d'une donnée dans la source de données via le bon gestionnaire
   * @param donnee La donnée à insérer
   * @throws IllegalArgumentException
   */
  def insert(donnee : Any) : Unit = donnee match {
    case _ : Adresse => adresseManager.insert(donnee)
    case _ : Batiment => batimentManager.insert(donnee)
    case _ : Demandeur => demandeurManager.insert(donnee)
    case _ : Reservation => reservationManager.insert(donnee)
    case _ : Salle => salleManager.insert(donnee)
    case _ => throw new IllegalArgumentException("Type d'objet non supporté par le médiateur")
  }

  /**
   * Méthode effectuant la mise à jour d'une donnée dans la source de données via le bon gestionnaire
   * @param donnee La donnée à mettre à jour
   * @throws IllegalArgumentException
   */
  def update(donnee : Any) : Unit = donnee match {
    case _ : Adresse => adresseManager.update(donnee)
    case _ : Batiment => batimentManager.update(donnee)
    case _ : Demandeur => demandeurManager.update(donnee)
    case _ : Reservation => reservationManager.update(donnee)
    case _ : Salle => salleManager.update(donnee)
    case _ => throw new IllegalArgumentException("Type d'objet non supporté par le médiateur")
  }

  /**
   * Méthode effectuant la suppression d'une donnée dans la source de données via le bon gestionnaire
   * @param donnee La donnée à supprimer
   * @throws IllegalArgumentException
   */
  def delete(donnee : Any) : Unit = donnee match {
    case _ : Adresse => adresseManager.delete(donnee)
    case _ : Batiment => batimentManager.delete(donnee)
    case _ : Demandeur => demandeurManager.delete(donnee)
    case _ : Reservation => reservationManager.delete(donnee)
    case _ : Salle => salleManager.delete(donnee)
    case _ => throw new IllegalArgumentException("Type d'objet non supporté par le médiateur")
  }

}
