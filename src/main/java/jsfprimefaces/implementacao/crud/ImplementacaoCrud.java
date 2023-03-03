package jsfprimefaces.implementacao.crud;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import jsfprimefaces.hibernate.session.HibernateUtil;
import jsfprimefaces.interfac.crud.InterfaceCrud;

@Component
@Transactional
public class ImplementacaoCrud<T> implements InterfaceCrud<T>{

	private static final long serialVersionUID = 1L;
	
	private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	@Autowired
	private JdbcTemplateImpl jdbcTemplate;
	
	@Autowired
	private SimpleJdbcTemplateImpl simpleJdbcTemplate;
	
	@Autowired
	private SimpleJdbcInsertImpl simpleJdbcInsert;
	
	@Autowired
	private SimpleJdbcTemplateImpl simpleJdbcTemplateImpl;
	
	
	public SimpleJdbcTemplateImpl getSimpleJdbcTemplateImpl() {
		return simpleJdbcTemplateImpl;
	}
	
	@Override
	public void save(T obj) throws Exception {
		validarTransaction();
		sessionFactory.getCurrentSession().save(obj);
		executeFlushSession();
		
	}

	@Override
	public void persist(T obj) throws Exception {
		validarTransaction();
		sessionFactory.getCurrentSession().persist(obj);
		executeFlushSession();
		
	}

	@Override
	public void saveOrUpdate(T obj) throws Exception {
		validarTransaction();
		sessionFactory.getCurrentSession().saveOrUpdate(obj);
		executeFlushSession();
		
	}

	@Override
	public void update(T obj) throws Exception {
		validarTransaction();
		sessionFactory.getCurrentSession().update(obj);
		executeFlushSession();
	}

	@Override
	public void delete(T obj) throws Exception {
		validarTransaction();
		sessionFactory.getCurrentSession().delete(obj);
		executeFlushSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T merge(T obj) throws Exception {
		validarTransaction();
		obj = (T) sessionFactory.getCurrentSession().merge(obj);
		executeFlushSession();
		return obj;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findList(Class<T> entidade) throws Exception {
		validarTransaction();
		
		StringBuilder query = new StringBuilder();
		query.append("select distinct(entity) from").append(entidade.getSimpleName()).append(" entity ");
		
		List<T> lista = sessionFactory.getCurrentSession().createQuery(query.toString()).list();
		
		return lista;
	}

	@Override
	public Object findId(Class<T> entidade, Long id) throws Exception {
		validaSessionFactory();
		Object obj = sessionFactory.getCurrentSession().load(getClass(), id);
		return obj;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findById(Class<T> entidade, Long id) throws Exception {
		validaSessionFactory();
		T obj = (T) sessionFactory.getCurrentSession().load(getClass(), id);
		return obj;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findListByQueryDinamica(String s) throws Exception {
		validaSessionFactory();
		List<T> lista = new ArrayList<T>();
		lista = sessionFactory.getCurrentSession().createQuery(s).list();
		return lista;
	}

	@Override
	public void executeUpdateQueryDinamica(String s) throws Exception {
		validaSessionFactory();
		sessionFactory.getCurrentSession().createQuery(s).executeUpdate();
		executeFlushSession();
	}

	@Override
	public void executeUpdateSqlDinamica(String s) throws Exception {
		validaSessionFactory();
		sessionFactory.getCurrentSession().createSQLQuery(s).executeUpdate();
		executeFlushSession();
	}

	@Override
	public void clearSession() throws Exception {
		sessionFactory.getCurrentSession().clear();
	}

	@Override
	public void evict(Object objs) throws Exception {
		validaSessionFactory();
		sessionFactory.getCurrentSession().evict(objs);
			}

	@Override
	public Session getSession() throws Exception {
		validaSessionFactory();
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<?> getListSQLDinamica(String sql) throws Exception {
		validaSessionFactory();
		List<?> lista = sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		return lista;
	}

	@Override
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Override
	public SimpleJdbcTemplate getSimpleJdbcTemplate() {
		return simpleJdbcTemplate;
	}

	@Override
	public SimpleJdbcInsert getsiSimpleJdbcInsert() {
		return simpleJdbcInsert;
	}

	@Override
	public Long totalRegistro(String table) throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append(" select count(1) from ").append(table);
		return jdbcTemplate.queryForLong(sql.toString());
	}

	@Override
	public Query obterQuery(String query) throws Exception {
		validaSessionFactory();
		Query queryReturn = sessionFactory.getCurrentSession().createQuery(query.toString());
		return queryReturn;
	}

	//Realiza consulta no BD iniciando do parâmetro e obtendo o máximo (ex.: de 50 a 80)
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findListByQueryDinamica(String query, int iniciaNoRegistro, int maxResultado) throws Exception {
		validaSessionFactory();
		List<T> lista = new ArrayList<T>();
		lista = sessionFactory.getCurrentSession().createQuery(query).setFirstResult(iniciaNoRegistro).setMaxResults(maxResultado).list();
		return lista;
	}
	
	private void validaSessionFactory() {
		if (sessionFactory == null) {
			sessionFactory = HibernateUtil.getSessionFactory();
		}
		validarTransaction();
	}

	private void validarTransaction() {
		if (!sessionFactory.getCurrentSession().getTransaction().isActive()) {
			sessionFactory.getCurrentSession().beginTransaction();
		}
	}
	
	@SuppressWarnings("unused")
	private void commitProcessoAjax() {
		sessionFactory.getCurrentSession().beginTransaction().commit();
		
	}
	
	@SuppressWarnings("unused")
	private void rollBackProcessoAjax() {
		sessionFactory.getCurrentSession().beginTransaction().rollback();
	}
	
	//Roda implementação SQL no BD
	private void executeFlushSession() {
		sessionFactory.getCurrentSession().flush();
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> getListSQLDinamicaArray(String sql) throws Exception {
		validaSessionFactory();
		List<Object[]> lista = (List<Object[]>) sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		return lista;
	}
}
