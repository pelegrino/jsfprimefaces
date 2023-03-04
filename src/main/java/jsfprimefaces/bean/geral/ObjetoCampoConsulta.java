package jsfprimefaces.bean.geral;

import java.io.Serializable;
import java.util.Comparator;

public class ObjetoCampoConsulta implements Serializable, Comparator<ObjetoCampoConsulta> {

	private static final long serialVersionUID = 1L;
	
	private String descricao;
	private String campoBanco;
	private Object tipoClass;
	private Integer principal;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCampoBanco() {
		return campoBanco;
	}

	public void setCampoBanco(String campoBanco) {
		this.campoBanco = campoBanco;
	}

	public Object getTipoClass() {
		return tipoClass;
	}

	public void setTipoClass(Object tipoClass) {
		this.tipoClass = tipoClass;
	}

	public Integer getPrincipal() {
		return principal;
	}

	public void setPrincipal(Integer principal) {
		this.principal = principal;
	}

	@Override
	public int compare(ObjetoCampoConsulta o1, ObjetoCampoConsulta o2) {
		return ((ObjetoCampoConsulta)o1).getPrincipal().compareTo(((ObjetoCampoConsulta)o2).getPrincipal());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((campoBanco == null) ? 0 : campoBanco.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ObjetoCampoConsulta other = (ObjetoCampoConsulta) obj;
		if (campoBanco == null) {
			if (other.campoBanco != null)
				return false;
		} else if (!campoBanco.equals(other.campoBanco))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getDescricao()	;
	}
}
