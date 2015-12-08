package fr.univnantes.vroom.core.dto

import fr.univnantes.vroom.core.DTOManager
import fr.univnantes.vroom.core.dto.tarifs.{TarifDureeDTO, TarifManifestationDTO}
import fr.univnantes.vroom.core.persistable.tarifs.{TarifDuree, TarifManifestation}
import fr.univnantes.vroom.core.persistable.{Demandeur, Salle, Reservation, Persistable}

/**
 * Created by E122371M on 07/12/15.
 */
case class ReservationDTO(var ref_resa: Int,
                          var date_resa: String,
                          var montant: Double,
                          var salle: SalleDTO,
                          var demandeur: DemandeurDTO,
                          var manifestation: TarifManifestationDTO,
                          var duree: TarifDureeDTO) extends DataTransfertObject("Reservation") {

  override def toObject(): Persistable = new Reservation( ref_resa,
                                                          date_resa,
                                                          montant,
                                                          DTOManager.dtoToObject(salle.no_salle, salle).asInstanceOf[Salle],
                                                          DTOManager.dtoToObject(demandeur.no_dem, demandeur).asInstanceOf[Demandeur],
                                                          DTOManager.dtoToObject(manifestation.code, manifestation).asInstanceOf[TarifManifestation],
                                                          DTOManager.dtoToObject(duree.code, duree).asInstanceOf[TarifDuree])

}
