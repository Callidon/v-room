package fr.univnantes.vroom.core.dto

/**
 * Created by E122371M on 07/12/15.
 */
case class ReservationDTO(var ref_resa: Int,
                          var date_resa: String,
                          var montant: Double,
                          var salle: DataTransfertObject,
                          var demandeur: DataTransfertObject,
                          var manifestation: DataTransfertObject,
                          var duree: DataTransfertObject) extends DataTransfertObject("Reservation") {

}
