// 
// 
// 

package interceptor;

import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor
{
    public void afterCompletion(final HttpServletRequest arg0, final HttpServletResponse arg1, final Object arg2, final Exception arg3) throws Exception {
    }
    
    public void postHandle(final HttpServletRequest arg0, final HttpServletResponse arg1, final Object arg2, final ModelAndView arg3) throws Exception {
    }
    
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object arg2) throws Exception {
        return true;
    }
}
