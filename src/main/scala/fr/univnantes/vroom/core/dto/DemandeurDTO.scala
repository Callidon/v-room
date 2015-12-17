package fr.univnantes.vroom.core.dto

import fr.univnantes.vroom.core.DTOManager
import fr.univnantes.vroom.core.dto.tarifs.{TarifOrigineDTO, TarifTitreDTO}
import fr.univnantes.vroom.core.persistable.tarifs.{TarifOrigine, TarifTitre}
import fr.univnantes.vroom.core.persistable.{Adresse, Demandeur, Persistable}

/**
  * Classe représentant un Demandeur dans le système
  * @param no_dem numéro du demandeur
  * @param nom nom du demandeur
  * @param adresse DTO Adresse du demandeur
  * @param origine DTO Tarif de l'origine du demandeur
  * @param titre  DTO Tarif du titre du demandeur
  */
case class DemandeurDTO(var no_dem: Int,
                        var nom: String,
                        var adresse: AdresseDTO,
                        var origine: TarifOrigineDTO,
                        var titre: TarifTitreDTO) extends DataTransfertObject("Demandeur") {
  /**
    * Transforme le DTO en objet concret du système
    * @return
    */
  override def toObject: Persistable = new Demandeur(no_dem,
    nom,
    DTOManager.dtoToObject(adresse.numero, adresse).asInstanceOf[Adresse],
    DTOManager.dtoToObject(origine.code, origine).asInstanceOf[TarifOrigine],
    DTOManager.dtoToObject(titre.code, titre).asInstanceOf[TarifTitre])

}
