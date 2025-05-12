package guru.springframework.configuration;

//import org.h2.server.web.WebServlet;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;

//@Configuration
public class WebConfiguration {

    public WebConfiguration() {
        // Constructor for manual configuration setup
    }

    public void configureServlet() {
        // Simulate H2 Console Servlet registration
        System.out.println("Registering H2 Console Servlet at /console/*");
        // Simulate adding servlet mappings
        registerServletMappings();
    }

    private void registerServletMappings() {
        System.out.println("Servlet mapping added: /console/*");
    }

   
} 

