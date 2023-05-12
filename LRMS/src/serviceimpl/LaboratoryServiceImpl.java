// 
// 
// 

package serviceimpl;

import java.util.List;
import entity.Laboratory;
import org.springframework.beans.factory.annotation.Autowired;
import dao.LaboratoryDao;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import service.LaboratoryService;

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class LaboratoryServiceImpl implements LaboratoryService
{
    @Autowired
    private LaboratoryDao laboratoryDao;
    
    @Override
    public int addLab(final Laboratory laboratory) {
        System.out.println("LaboratoryServiceImpl - addLab");
        final int result = this.laboratoryDao.addLab(laboratory);
        return result;
    }
    
    @Override
    public List<Laboratory> getAllLab() {
        final List<Laboratory> labList = this.laboratoryDao.getAllLab();
        return labList;
    }
    
    @Override
    public boolean delLab(final Laboratory laboratory) {
        final boolean isDel = this.laboratoryDao.delLab(laboratory);
        return isDel;
    }
    
    @Override
    public Laboratory getLabById(final Laboratory laboratory) {
        final Laboratory lab = this.laboratoryDao.getLabById(laboratory);
        return lab;
    }
    
    @Override
    public boolean updateLab(final Laboratory laboratory) {
        final boolean isUpdate = this.laboratoryDao.updateLab(laboratory);
        return isUpdate;
    }
}
