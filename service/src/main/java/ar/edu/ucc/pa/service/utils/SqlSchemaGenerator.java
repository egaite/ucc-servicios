package ar.edu.ucc.pa.service.utils;

import java.util.EnumSet;
import java.util.Properties;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.hbm2ddl.SchemaExport.Action;
import org.hibernate.tool.schema.TargetType;

import ar.edu.ucc.pa.service.model.GenericObject;
import ar.edu.ucc.pa.service.model.Telefono;
import ar.edu.ucc.pa.service.model.Usuario;


public class SqlSchemaGenerator {

	public static void main(String[] args) {
		
		
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		properties.put("hibernate.connection.url", "jdbc:mysql://127.0.0.1:3306/PA"); 
		properties.put("hibernate.connection.username", "root");
		properties.put("hibernate.connection.password", "root");
		properties.put("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		properties.put("hibernate.show_sql", "true");
		
		MetadataSources metadata = new MetadataSources(
	            new StandardServiceRegistryBuilder().applySettings(properties)
	                    .build());

	   metadata.addAnnotatedClass(GenericObject.class);
	   metadata.addAnnotatedClass(Telefono.class);
	   metadata.addAnnotatedClass(Usuario.class);
	    
		
		SchemaExport schemaExport = new SchemaExport();
		schemaExport.setDelimiter(";");

		schemaExport.setOutputFile("src/main/resources/Schema.sql");
		schemaExport.setFormat(true);
		schemaExport.execute(EnumSet.of(TargetType.SCRIPT), Action.BOTH, metadata.buildMetadata());
	}
}
