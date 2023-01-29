package jsfprimefaces.model.classes;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

import jsfprimefaces.listener.CustomListener;

@Entity
@Table(name = "revinfo")
@RevisionEntity(CustomListener.class)
public class InformacaoRevisao extends DefaultRevisionEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@ForeignKey(name = "entidade_fk")
	@JoinColumn(nullable = false, name = "entidade")
	private Entidade entidade;
	
	public void setEntidade(Entidade entidade) {
		this.entidade = entidade;
	}
	
	public Entidade getEntidade() {
		return entidade;
	}

}
