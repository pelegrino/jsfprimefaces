package jsfprimefaces.listener;

import java.io.Serializable;

import org.hibernate.envers.RevisionListener;
import org.springframework.stereotype.Service;

import jsfprimefaces.model.classes.Entidade;
import jsfprimefaces.model.classes.InformacaoRevisao;
import jsfprimefaces.utils.UtilFramework;

@Service
public class CustomListener implements RevisionListener, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public void newRevision(Object revisionEntity) {
		InformacaoRevisao informacaoRevisao = (InformacaoRevisao) revisionEntity;
		Long codUser = UtilFramework.getThreadLocal().get();
		
		Entidade entidade = new Entidade();
		if (codUser != null && codUser != 0L) {
			entidade.setEnt_codigo(codUser);
			informacaoRevisao.setEntidade(entidade);
		}
	}


}
