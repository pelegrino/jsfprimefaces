package jsfprimefaces.util.all;

import java.io.Serializable;

import javax.annotation.PostConstruct;

public interface ActionViewPadrao extends Serializable {

	abstract void limparLista() throws Exception;
	abstract String save() throws Exception;
	abstract void saveNotReturn() throws Exception;
	abstract void saveEdit() throws Exception;
	abstract void excluir() throws Exception;
	abstract String ativar() throws Exception;
	
	@PostConstruct
	abstract String novo() throws Exception;
	
	abstract String editar() throws Exception;
	abstract void setarVariaveisNulas() throws Exception;
	abstract void consultarEntidade() throws Exception;
	abstract void statusOperation(StatusPersistencia a) throws Exception;
	abstract String redirecionarNewEntidade() throws Exception;
	abstract String redirecionarFindEntidade() throws Exception;
	abstract void addMsg() throws Exception;
}
