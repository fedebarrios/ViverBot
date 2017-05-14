package viverbot.Model;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Log {
	
	@SuppressWarnings("rawtypes")
	public static Logger getLog(Class c){
		BasicConfigurator.configure();
		Logger log = Logger.getLogger(c);
		return log;
	}

}
