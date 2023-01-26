package jsfprimefaces.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public abstract @interface IdentificaCampoPesquisa {
	
	String descricaoCampo(); //Descricao do campo para a tela
	String campoConsulta(); //Campo do BD
	int principal() default 10000; //Posição que irá aparecer no combo
}
