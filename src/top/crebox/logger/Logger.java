package top.crebox.logger;

import top.crebox.boxcore.CreboxProperties;

import java.lang.reflect.Type;

public class Logger {
    private static Logger instance;

    private Logger(){}

    public static Logger getInstance() {
        if (instance == null)
            instance = new Logger();
        return instance;
    }

    public void log(LogType TypeLog,String msg) {
        String TypeStr;
        switch(TypeLog) {
            case INFO:TypeStr="INFO";break;
            case WARNING:TypeStr="WARN";break;
            case ERROR:TypeStr="ERR";break;
            default:TypeStr="UNKNOWN";
        }
        System.out.println("["+TypeStr+"]"+msg);
    }
    public void logInfo(String msg) {
        this.log(LogType.INFO,msg);
    }
    public void logError(String msg) {
        this.log(LogType.ERROR,msg);
    }

    public void logWaring(String msg) {
        this.log(LogType.WARNING,msg);
    }
}
