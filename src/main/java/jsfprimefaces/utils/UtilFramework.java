package jsfprimefaces.utils;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class UtilFramework implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static ThreadLocal<Long> threadLocal = new ThreadLocal<Long>();
	
	@SuppressWarnings("unused")
	private synchronized static ThreadLocal<Long> getThreadLocal() {
		return threadLocal;
	}

}
