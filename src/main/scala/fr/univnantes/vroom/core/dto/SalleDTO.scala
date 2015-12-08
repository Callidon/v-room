package fr.univnantes.vroom.core.dto

import fr.univnantes.vroom.core.DTOManager
import fr.univnantes.vroom.core.dto.tarifs.TarifSalleDTO
import fr.univnantes.vroom.core.persistable.tarifs.TarifSalle
import fr.univnantes.vroom.core.persistable.{Batiment, Salle, Persistable}

/**
 * Created by E122371M on 07/12/15.
 */
case class SalleDTO(val no_etage: Int,
                    val no_salle: Int,
                    val no_bat: Int,
                    val superficie: Int,
                    val batiment: BatimentDTO,
                    val tarif : TarifSalleDTO) extends DataTransfertObject("Salle") {

  override def toObject(): Persistable = new Salle( no_etage,
                                                    no_salle,
                                                    no_bat,
                                                    superficie,
                                                    DTOManager.dtoToObject(batiment.no_bat, batiment).asInstanceOf[Batiment],
                                                    DTOManager.dtoToObject(tarif.code, tarif).asInstanceOf[TarifSalle])
}
