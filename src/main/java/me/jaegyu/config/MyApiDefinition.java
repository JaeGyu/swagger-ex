package me.jaegyu.config;

import org.springframework.beans.factory.parsing.AliasDefinition;
import org.springframework.beans.factory.parsing.ComponentDefinition;
import org.springframework.beans.factory.parsing.DefaultsDefinition;
import org.springframework.beans.factory.parsing.ImportDefinition;
import org.springframework.beans.factory.parsing.ReaderEventListener;
import io.swagger.annotations.SwaggerDefinition;

@SwaggerDefinition
public class MyApiDefinition implements ReaderEventListener {
	public static final String BASIC_AUTH_SCHEME = "basicAuth";

	@Override
	public void defaultsRegistered(DefaultsDefinition defaultsDefinition) {

	}

	@Override
	public void componentRegistered(ComponentDefinition componentDefinition) {

	}

	@Override
	public void aliasRegistered(AliasDefinition aliasDefinition) {

	}

	@Override
	public void importProcessed(ImportDefinition importDefinition) {

	}

}
