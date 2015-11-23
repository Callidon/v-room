package fr.univnantes.vroom.core

import fr.univnantes.vroom.tarifs.{TarifTitre, TarifOrigine}

/**
 * Classe représentant un démandeur, qui cherche à réserver une salle
 *
 * @constructor Crée un nouveau demandeur
 * @param no_dem Un numéro unique qui représente le demandeur
 * @param nom Le nom du demandeur
 * @param adresse L'adresse du demandeur
 * @param origine Le tarif lié à l'origine du demandeur
 * @param titre Le tarif lié au titre du demandeur
 */
case class Demandeur(var no_dem: Int,
                var nom: String,
                var adresse: Adresse,
                var origine: TarifOrigine,
                var titre: TarifTitre) {

}
