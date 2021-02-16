package rs.ac.uns.ftn.informatika.udd.vezbe04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class TestApplication   
{
	
	public static void main( String[] args )
    {
    	SpringApplication.run(TestApplication.class, args);
    	  	
    }
	@Bean
    public WebMvcConfigurer corsConfigurer() {
      return new WebMvcConfigurerAdapter() {
         @Override
         public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
		            .allowedMethods("GET", "POST", "PUT", "DELETE")
		            .allowedHeaders("*")
            		.allowedOrigins("http://localhost:4200");
         }
      };
    }
    
}

  