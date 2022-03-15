package pl.coderslab.webmvc;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
//        Klasa, która posiada @ComponentScan i umożliwia odnalezienie innych komponentów
        return new Class[] {AppConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
//        Klasa, która implementuje WebMvcConfigurer
        return new Class[] {WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
//        mapping/context aplikacji
        return new String[] {"/"};
    }

//    skrót ctrl + o    pozwala znalezc dostepne metody
    @Override
    protected Filter[] getServletFilters() {
//        filtr kodujący znaki dla aplikacji
        return new Filter[]{new CharacterEncodingFilter("UTF-8")};
    }
}
