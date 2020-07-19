package org.pizzashop.rest.config;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;
import java.util.HashSet;
import java.util.Set;


@ApplicationPath("api")
public class ApplicationConfig extends ResourceConfig {

    public ApplicationConfig() {
        packages("org.pizzashop.rest");
        registerSwaggerResources();
        initSwaggerDocumentation();
    }

    private void registerSwaggerResources() {
        Set<Class<?>> resources = new HashSet();
        resources.add(ApiListingResource.class);
        resources.add(SwaggerSerializers.class);
        registerClasses(resources);
    }

    private void initSwaggerDocumentation() {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0");
        beanConfig.setBasePath("/pizzashop/api");
        beanConfig.setHost("localhost:8080");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setResourcePackage("org.pizzashop.rest.resource");
        beanConfig.setPrettyPrint(true);
        beanConfig.setScan(true);
    }

}
