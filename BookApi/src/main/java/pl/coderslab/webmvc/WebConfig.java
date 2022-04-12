// Dezaktywowane na potrzeby warsztatu z modulu 6, hibernate:
package pl.coderslab.webmvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.persistence.EntityManagerFactory;
import javax.validation.Validator;
import java.util.Locale;

@Configuration
public class WebConfig implements WebMvcConfigurer {

//    Poniższe przekazuje do tomcata zapytanie, jeśli spring nie potrafi go obsłużyć (np. pliki statyczne, jpg, itd.)
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

////    Poniższe pozwala dodać prefix i sufix na widoki. Ułatwia ustalanie ścieżek
//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        registry.jsp("/WEB-INF/views/",".jsp");
//    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver =
                new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactory() {
        LocalEntityManagerFactoryBean emfb = new LocalEntityManagerFactoryBean();
        emfb.setPersistenceUnitName("workshopHibernate");
        return emfb;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }

    //    każdy @Bean konwerter musi zostać dodany jako dodatkowa linia w formie registry.addConverter(getNowyKonwerter());
    @Override
    public void addFormatters(FormatterRegistry registry) {
//        registry.addConverter(getPublisherConverter());
    }

    //    Każdy konwerter musi mieć osobne ziarenko (Bean), tak jak poniżej:
//    @Bean
//    public PublisherConverter getPublisherConverter() {
//        return new PublisherConverter();
//    }

    //    Ustawienia lokalizacyjne:
    @Bean(name="localeResolver")
    public LocaleContextResolver getLocaleContextResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(new Locale("pl","PL"));
        return localeResolver;
    }

    //    Ziarno walidacji:
    @Bean
    public Validator validator() {
        return new LocalValidatorFactoryBean();
    }
}

