// 
// 
// 

package daoimpl;

import org.hibernate.Query;
import java.util.List;
import org.hibernate.Session;
import entity.Laboratory;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import dao.LaboratoryDao;

@Repository
public class LaboratoryDaoImpl implements LaboratoryDao
{
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public int addLab(final Laboratory laboratory) {
        final Session session = this.sessionFactory.getCurrentSession();
        final int result = (int)session.save((Object)laboratory);
        return result;
    }
    
    @Override
    public List<Laboratory> getAllLab() {
        final Session session = this.sessionFactory.getCurrentSession();
        final StringBuffer hql = new StringBuffer("from Laboratory order by building_name");
        final Query query = session.createQuery(hql.toString());
        return (List<Laboratory>)query.list();
    }
    
    @Override
    public boolean delLab(final Laboratory laboratory) {
        final StringBuffer hql = new StringBuffer("delete Laboratory  where lab_id=?");
        final Query query = this.sessionFactory.getCurrentSession().createQuery(hql.toString());
        query.setInteger(0, laboratory.getLab_id());
        return query.executeUpdate() > 0;
    }
    
    @Override
    public Laboratory getLabById(final Laboratory laboratory) {
        final Session session = this.sessionFactory.getCurrentSession();
        final StringBuffer hql = new StringBuffer("from Laboratory where lab_id=?");
        final Query query = session.createQuery(hql.toString());
        query.setInteger(0, laboratory.getLab_id());
        return (Laboratory)query.uniqueResult();
    }
    
    @Override
    public boolean updateLab(final Laboratory laboratory) {
        final Session session = this.sessionFactory.getCurrentSession();
        final StringBuffer hql = new StringBuffer("update Laboratory set building_name=?,room_number=?,person_number=?,is_free=?,description=? where lab_id=?");
        final Query query = session.createQuery(hql.toString());
        query.setString(0, laboratory.getBuilding_name());
        query.setInteger(1, laboratory.getRoom_number());
        query.setInteger(2, laboratory.getPerson_number());
        query.setInteger(3, laboratory.getIs_free());
        query.setString(4, laboratory.getDescription());
        query.setInteger(5, laboratory.getLab_id());
        return query.executeUpdate() > 0;
    }
}
