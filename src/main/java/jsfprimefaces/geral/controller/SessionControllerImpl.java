package jsfprimefaces.geral.controller;

import java.util.HashMap;

import javax.faces.bean.ApplicationScoped;
import javax.servlet.http.HttpSession;

@ApplicationScoped
public class SessionControllerImpl implements SessionController {

	private static final long serialVersionUID = 1L;
	
	private HashMap<String, HttpSession> hashMap = new HashMap<String, HttpSession>();

	@Override
	public void addSession(String keyLoginUser, HttpSession httpSession) {
		hashMap.put(keyLoginUser, httpSession);
	}

	@Override
	public void invalidateSession(String KeyLoginUser) {
		HttpSession session = hashMap.get(KeyLoginUser);
		if(session != null) { //Remove sessão do usuário passado como parâmetro
			try {
				session.invalidate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Não tem usuário.");
		}
		
		hashMap.remove(KeyLoginUser);
	}

}
