package fr.univnantes.vroom.core.dto

import fr.univnantes.vroom.core.DTOManager
import fr.univnantes.vroom.core.dto.tarifs.{TarifTitreDTO, TarifOrigineDTO}
import fr.univnantes.vroom.core.persistable.tarifs.{TarifTitre, TarifOrigine}
import fr.univnantes.vroom.core.persistable.{Adresse, Demandeur, Persistable}

/**
 * Created by E122371M on 07/12/15.
 */
case class DemandeurDTO(val no_dem: Int,
                        val nom: String,
                        val adresse: AdresseDTO,
                        val origine: TarifOrigineDTO,
                        val titre: TarifTitreDTO) extends DataTransfertObject("Demandeur") {

  override def toObject(): Persistable = new Demandeur( no_dem,
                                                        nom,
                                                        DTOManager.dtoToObject(adresse.numero, adresse).asInstanceOf[Adresse],
                                                        DTOManager.dtoToObject(origine.code, origine).asInstanceOf[TarifOrigine],
                                                        DTOManager.dtoToObject(titre.code, titre).asInstanceOf[TarifTitre])

}
