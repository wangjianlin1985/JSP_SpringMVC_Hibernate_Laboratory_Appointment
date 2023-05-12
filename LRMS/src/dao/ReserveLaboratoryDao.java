// 
// 
// 

package dao;

import entity.user_lab_reservation;
import entity.lab_schedule;
import entity.lab_reservation;
import java.util.List;
import entity.Reservation;

public interface ReserveLaboratoryDao
{
    int reserveLab(Reservation p0);
    
    int reserveLab2(Reservation p0);
    
    List<lab_reservation> getLab_reservations(int p0);
    
    List<lab_schedule> getSchedule_table(int p0);
    
    List<lab_reservation> reservationByUser(int p0);
    
    Reservation single_reservation_info(int p0);
    
    int deleteReservation(int p0);
    
    List<lab_reservation> ReservationTeacherForStudent(int p0);
    
    List<user_lab_reservation> selectReservation(int p0, int p1, String p2, int p3, String p4, String p5);
}
