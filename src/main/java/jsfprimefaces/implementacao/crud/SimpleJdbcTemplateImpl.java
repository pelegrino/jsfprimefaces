package jsfprimefaces.implementacao.crud;

import java.io.Serializable;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class SimpleJdbcTemplateImpl extends SimpleJdbcTemplate implements Serializable {

	private static final long serialVersionUID = 1L;

	public SimpleJdbcTemplateImpl(DataSource dataSource) {
		super(dataSource);
	}

}
