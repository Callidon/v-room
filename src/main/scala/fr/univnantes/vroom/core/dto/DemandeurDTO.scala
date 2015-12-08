package fr.univnantes.vroom.core.dto

import fr.univnantes.vroom.core.DTOManager
import fr.univnantes.vroom.core.dto.tarifs.{TarifOrigineDTO, TarifTitreDTO}
import fr.univnantes.vroom.core.persistable.tarifs.{TarifOrigine, TarifTitre}
import fr.univnantes.vroom.core.persistable.{Adresse, Demandeur, Persistable}

/**
 * Projet : Default (Template) Project
 * Créé par E122371M le 07/12/15 à 23:05.
 *
 */
case class DemandeurDTO(var no_dem: Int,
                        var nom: String,
                        var adresse: AdresseDTO,
                        var origine: TarifOrigineDTO,
                        var titre: TarifTitreDTO) extends DataTransfertObject("Demandeur") {

  override def toObject(): Persistable = new Demandeur( no_dem,
                                                        nom,
                                                        DTOManager.dtoToObject(adresse.numero, adresse).asInstanceOf[Adresse],
                                                        DTOManager.dtoToObject(origine.code, origine).asInstanceOf[TarifOrigine],
                                                        DTOManager.dtoToObject(titre.code, titre).asInstanceOf[TarifTitre])

}
