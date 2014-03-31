/**
 * ����:Logger.java
 * ����:������
 * ����ʱ��:2012-5-3
 * �汾:1.0.0 alpha 
 * ��Ȩ:CopyRight(c)2012 ������  ����Ŀ��������Ȩ������������  
 * ����:
 */

package darks.codec.logs;

public abstract class Logger
{
    
    public static Logger getLogger(Class<?> clazz)
    {
        return LoggerFactory.getLogger(clazz);
    }
    
    public static Logger getLogger(String tag)
    {
        return LoggerFactory.getLogger(tag);
    }
    
    public abstract boolean isDebugEnabled();
    
    public abstract void info(String paramString, Throwable e);
    
    public abstract void info(String paramString);
    
    public abstract void error(String paramString, Throwable e);
    
    public abstract void error(String paramString);
    
    public abstract void debug(String paramString);
    
    public abstract void debug(String s, Throwable e);
    
    public abstract void warn(String paramString);
    
    public abstract void warn(String paramString, Throwable e);
}
