package routineplanner.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class ApiPathConfig implements WebMvcConfigurer {

    // TODO prefix psuje /error !
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.addPathPrefix("/routine_planner/api", c -> c.isAnnotationPresent(RequestMapping.class));
    }


}
