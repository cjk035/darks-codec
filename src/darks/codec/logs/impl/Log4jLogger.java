/**
 * ����:Log4jLogger.java
 * ����:������
 * ����ʱ��:2012-5-3
 * �汾:1.0.0 alpha 
 * ��Ȩ:CopyRight(c)2012 ������  ����Ŀ��������Ȩ������������  
 * ����:Log4jLogger
 */

package darks.codec.logs.impl;

import darks.codec.logs.Logger;

public class Log4jLogger extends Logger
{
    private org.apache.log4j.Logger log;
    
    public Log4jLogger(String clazz)
    {
        this.log = org.apache.log4j.Logger.getLogger(clazz);
    }
    
    public boolean isDebugEnabled()
    {
        return this.log.isDebugEnabled();
    }
    
    public void error(String s, Throwable e)
    {
        this.log.error(s, e);
    }
    
    public void error(String s)
    {
        this.log.error(s);
    }
    
    public void debug(String s)
    {
        this.log.debug(s);
    }
    
    public void debug(String s, Throwable e)
    {
        this.log.debug(s, e);
    }
    
    public void warn(String s)
    {
        this.log.warn(s);
    }

    @Override
    public void warn(String paramString, Throwable e)
    {
        log.warn(paramString, e);
    }

    @Override
    public void info(String paramString, Throwable e)
    {
        this.log.info(paramString, e);
    }

    @Override
    public void info(String paramString)
    {
        this.log.info(paramString);
    }
}
