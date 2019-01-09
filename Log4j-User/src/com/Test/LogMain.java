package com.Test;
//log测试

import org.apache.log4j.Logger;

public class LogMain {

	private static Logger log = Logger.getLogger(LogMain.class);  
	
	public static void main(String[] args) {
		
		
		log.debug("dubug测试1");
		log.fatal("fatal测试1");
		log.fatal("fatal测试2");
		log.debug("debug测试2");
		log.debug("debug测试3");
		log.trace("trace测试1");		
		log.trace("trace测试2");
		log.trace("trace测试3");
		log.trace("trace测试4");
		log.error("error测试1");
		log.info ( "info测试1");
	}
}
