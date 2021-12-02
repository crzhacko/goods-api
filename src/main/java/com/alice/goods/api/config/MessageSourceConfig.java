package com.alice.goods.api.config;

import net.rakugakibox.util.YamlResourceBundle;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

@Configuration
public class MessageSourceConfig {
    private final String path = "i18n/messages";

    @Bean
    public ResourceBundleMessageSource messageSource() {
        YamlMessageSource messageSource = new YamlMessageSource();
        messageSource.setBasename(path);
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(60);
        return messageSource;
    }

    class YamlMessageSource extends ResourceBundleMessageSource {
        @Override
        protected ResourceBundle doGetBundle(String basename, Locale locale) throws MissingResourceException {
            return ResourceBundle.getBundle(basename, locale, YamlResourceBundle.Control.INSTANCE);
        }
    }
}
