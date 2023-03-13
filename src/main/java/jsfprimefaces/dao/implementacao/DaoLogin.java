package jsfprimefaces.dao.implementacao;

import org.springframework.stereotype.Repository;

import jsfprimefaces.implementacao.crud.ImplementacaoCrud;
import jsfprimefaces.repository.interfaces.RepositoryLogin;

@Repository
public class DaoLogin extends ImplementacaoCrud<Object> implements RepositoryLogin {

	private static final long serialVersionUID = 1L;

	@Override
	public boolean autentico(String login, String senha) throws Exception {

		return false;
	}

}
