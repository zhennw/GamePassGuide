package revature.project2.Aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


@Aspect
@Component
public class LoggingAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class);

    @AfterReturning("within(revature.project2.Controllers.*)")
    public void logsControllers(JoinPoint joinPoint)
    {
        logger.info("Zhen say " + joinPoint.getSignature().getName() +" pass");
    }

    @AfterThrowing("within(revature.project2.Controllers.*)")
    public void logErrorsControllers(JoinPoint joinPoint)
    {
        logger.error("Zhen say " + joinPoint.getSignature().getName() + " fails");
    }
    @Before("within(revature.project2.Controllers.*)")
    public void beforelog()
    {
        logger.info("Jumphppds");
    }
    @After("within(revature.project2.Controllers.*)")
    public void logRequest()
    {
        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        logger.info(request.getMethod()+ " request made to "+ request.getRequestURI());
    }
    @AfterReturning("within(revature.project2.Service.*)")
    public void logsService(JoinPoint joinPoint)
    {
        logger.info("Zhen say " + joinPoint.getSignature().getName() +" pass");
    }

    @AfterThrowing("within(revature.project2.Service.*)")
    public void logErrorsService(JoinPoint joinPoint)
    {
        logger.error("Zhen say " + joinPoint.getSignature().getName() + " fails");
    }
}
