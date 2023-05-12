// 
// 
// 

package dao;

import java.util.List;
import entity.Laboratory;

public interface LaboratoryDao
{
    int addLab(Laboratory p0);
    
    List<Laboratory> getAllLab();
    
    boolean delLab(Laboratory p0);
    
    Laboratory getLabById(Laboratory p0);
    
    boolean updateLab(Laboratory p0);
}
