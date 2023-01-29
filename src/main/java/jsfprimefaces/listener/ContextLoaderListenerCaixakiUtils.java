package jsfprimefaces.listener;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@ApplicationScoped
public class ContextLoaderListenerCaixakiUtils extends ContextLoader implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static WebApplicationContext getWac() {
		return WebApplicationContextUtils.getWebApplicationContext(getCurrentWebApplicationContext().getServletContext());
		
	}
	
	public static Object getBean(String idNomeBean) {
		return getWac().getBean(idNomeBean);
		
	}
	
	public static Object getBean(Class<?> classe) {
		return getWac().getBean(classe);
	}

}
