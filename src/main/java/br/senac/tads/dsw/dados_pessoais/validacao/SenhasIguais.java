package br.senac.tads.dsw.dados_pessoais.validacao;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

	@Documented
	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	@Constraint(validatedBy = SenhasIguaisValidator.class)

	public @interface SenhasIguais {

		String message() default "A senha e a repetição devem ser iguais";

		Class<?>[] groups() default {};

		Class<? extends Payload> [] payload() default {};

}
