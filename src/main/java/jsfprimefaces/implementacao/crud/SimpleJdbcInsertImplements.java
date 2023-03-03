package jsfprimefaces.implementacao.crud;

import java.io.Serializable;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class SimpleJdbcInsertImplements extends SimpleJdbcInsert implements Serializable {

	private static final long serialVersionUID = 1L;

	public SimpleJdbcInsertImplements(DataSource dataSource) {
		super(dataSource);
	}

}
