package jsfprimefaces.model.classes;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.envers.Audited;

@Audited
@Entity
public class Entidade implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long ent_codigo;
	private String ent_login = null;
	private String ent_senha;
	private boolean ent_inativo = false;
	
	public Entidade() {
		
	}
	
	
	@Id
	public Long getEnt_codigo() {
		return ent_codigo;
	}
	
	public void setEnt_codigo(Long ent_codigo) {
		this.ent_codigo = ent_codigo;
	}
	
	public String getEnt_login() {
		return ent_login;
	}
	
	public void setEnt_login(String ent_login) {
		this.ent_login = ent_login;
	}
	
	public String getEnt_senha() {
		return ent_senha;
	}
	
	public void setEnt_senha(String ent_senha) {
		this.ent_senha = ent_senha;
	}
	
	public void setEnt_inativo(boolean ent_inativo) {
		this.ent_inativo = ent_inativo;
	}

	public boolean getEnt_inativo() {
		return ent_inativo;
	}
	
}
