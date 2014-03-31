/**
 * ����:LoggerFactroy.java
 * ����:������
 * ����ʱ��:2012-5-3
 * �汾:1.0.0 alpha 
 * ��Ȩ:CopyRight(c)2012 ������  ����Ŀ��������Ȩ������������  
 * ����:
 */

package darks.codec.logs;

import java.lang.reflect.Constructor;

import darks.codec.exceptions.LogException;

public class LoggerFactory
{
    
    private static volatile Constructor<? extends Logger> logConstructor;
    
    static
    {
        setLogConstructor("darks.codec.logs.impl.DarksLogger");
        setLogConstructor("darks.codec.logs.impl.Log4jLogger");
        setLogConstructor("darks.codec.logs.impl.Slf4jLogger");
        setLogConstructor("darks.codec.logs.impl.Jdk14Logger");
        setLogConstructor("darks.codec.logs.impl.StdIOLogger");
        setLogConstructor("darks.codec.logs.impl.NoOpLogger");
    }
    
    static Logger getLogger(Class<?> aClass)
    {
        return getLogger(aClass.getName());
    }
    
    static Logger getLogger(String logger)
    {
        try
        {
            return (Logger)logConstructor.newInstance(new Object[] {logger});
        }
        catch (Throwable t)
        {
            throw new LogException("Error creating logger for logger " + logger + ".  Cause: " + t, t);
        }
    }
    
    @SuppressWarnings("unchecked")
    private static void setLogConstructor(String className)
    {
        if (logConstructor == null)
        {
            try
            {
                Class<?> implClass = Class.forName(className);
                Constructor<?> candidate = implClass.getConstructor(new Class[] {String.class});
                candidate.newInstance(new Object[] {LoggerFactory.class.getName()});
                logConstructor = (Constructor<? extends Logger>)candidate;
            }
            catch (Exception e)
            {
                
            }
        }
    }
    
}
