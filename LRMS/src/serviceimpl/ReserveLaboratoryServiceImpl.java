// 
// 
// 

package serviceimpl;

import entity.user_lab_reservation;
import entity.lab_schedule;
import entity.lab_reservation;
import java.util.List;
import entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import dao.ReserveLaboratoryDao;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import service.ReserveLaboratoryService;

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class ReserveLaboratoryServiceImpl implements ReserveLaboratoryService
{
    @Autowired
    private ReserveLaboratoryDao reserveLaboratoryDao;
    
    @Override
    public int reserveLab(final Reservation reservation) {
        int result = 0;
        if (reservation.getReserve_type() == 1) {
            result = this.reserveLaboratoryDao.reserveLab(reservation);
        }
        else {
            result = this.reserveLaboratoryDao.reserveLab2(reservation);
        }
        return result;
    }
    
    @Override
    public List<lab_reservation> getLab_reservations(final int lab_id) {
        final List<lab_reservation> lab_reservation_list = this.reserveLaboratoryDao.getLab_reservations(lab_id);
        return lab_reservation_list;
    }
    
    @Override
    public List<lab_schedule> getSchedule_table(final int lab_id) {
        return this.reserveLaboratoryDao.getSchedule_table(lab_id);
    }
    
    @Override
    public List<lab_reservation> reservationByUser(final int user_id) {
        return this.reserveLaboratoryDao.reservationByUser(user_id);
    }
    
    @Override
    public int deleteReservation(final int reserve_id) {
        return this.reserveLaboratoryDao.deleteReservation(reserve_id);
    }
    
    @Override
    public List<lab_reservation> ReservationTeacherForStudent(final int user_id) {
        return this.reserveLaboratoryDao.ReservationTeacherForStudent(user_id);
    }
    
    @Override
    public List<user_lab_reservation> selectReservation(final int user_id, final int user_type, final String user_name, final int reserve_type, final String from, final String end) {
        return this.reserveLaboratoryDao.selectReservation(user_id, user_type, user_name, reserve_type, from, end);
    }
}
