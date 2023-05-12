// 
// 
// 

package controller;

import java.util.List;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import other.ExecResult;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import entity.Laboratory;
import org.springframework.beans.factory.annotation.Autowired;
import service.LaboratoryService;
import org.springframework.stereotype.Controller;

@Controller
public class LaboratoryController
{
    @Autowired
    private LaboratoryService laboratoryService;
    
    @RequestMapping({ "addLab" })
    @ResponseBody
    public ExecResult addLab(final Laboratory laboratory, final HttpSession session, final HttpServletRequest request) {
        final ExecResult er = new ExecResult();
        final int result = this.laboratoryService.addLab(laboratory);
        if (result > 0) {
            er.setMsg("\u65b0\u589e\u6210\u529f");
            er.setSuccess(true);
        }
        else {
            er.setMsg("\u65b0\u589e\u5931\u8d25");
            er.setSuccess(false);
        }
        return er;
    }
    
    @RequestMapping({ "labList" })
    public ModelAndView getAllLab() {
        final ModelAndView view = new ModelAndView("labList");
        final List<Laboratory> labList = this.laboratoryService.getAllLab();
        view.addObject("labList", (Object)labList);
        return view;
    }
    
    @RequestMapping({ "reserveLabList" })
    public ModelAndView getreserveLabList() {
        final ModelAndView view = new ModelAndView("reserveLabList");
        final List<Laboratory> labList = this.laboratoryService.getAllLab();
        view.addObject("labList", (Object)labList);
        return view;
    }
    
    @RequestMapping({ "deleteLab" })
    @ResponseBody
    public ExecResult deleteLab(final Laboratory laboratory, final HttpSession session) {
        final ExecResult er = new ExecResult();
        if (laboratory.getLab_id() == 1) {
            er.setMsg("\u8be5\u5b9e\u9a8c\u5ba4\u88ab\u9650\u5236\u4e3a\u6c38\u4e45\u4e0d\u80fd\u5220\u9664\uff01");
            er.setSuccess(false);
        }
        else {
            final boolean isDel = this.laboratoryService.delLab(laboratory);
            if (isDel) {
                er.setMsg("\u5220\u9664\u6210\u529f");
                er.setSuccess(true);
            }
            else {
                er.setMsg("\u5220\u9664\u5931\u8d25");
                er.setSuccess(false);
            }
        }
        return er;
    }
    
    @RequestMapping({ "getLabById" })
    public ModelAndView getLabById(final Laboratory laboratory, final HttpSession session) {
        final ModelAndView view = new ModelAndView("updateLab");
        final Laboratory lab = this.laboratoryService.getLabById(laboratory);
        view.addObject("lab", (Object)lab);
        return view;
    }
    
    @RequestMapping({ "updateLab" })
    @ResponseBody
    public ExecResult updateLab(final Laboratory laboratory, final HttpSession session) {
        final ExecResult er = new ExecResult();
        final boolean isUpdate = this.laboratoryService.updateLab(laboratory);
        if (isUpdate) {
            er.setMsg("\u66f4\u65b0\u6210\u529f");
            er.setSuccess(true);
        }
        else {
            er.setMsg("\u66f4\u65b0\u5931\u8d25");
            er.setSuccess(false);
        }
        return er;
    }
}
