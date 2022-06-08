package de.ytendx.mccloud.master.configuration;

import lombok.Getter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Getter
public class EnviromentalConfigurationValueContainer {

    private String redisPW, redisURL;

    public EnviromentalConfigurationValueContainer() throws IllegalAccessException {
        final List<String> nullEnvVariables = new ArrayList<>();

        for(Field field : this.getClass().getDeclaredFields()){
            field.setAccessible(true);
            String value = System.getenv(field.getName().toUpperCase(Locale.ROOT));

            if(value == null){
                nullEnvVariables.add(field.getName().toUpperCase(Locale.ROOT));
            }
            else{
                field.set(this, value);
            }
        }

        if(nullEnvVariables.size() > 0){
            StringBuilder builder = new StringBuilder();

            for(String string : nullEnvVariables){
                builder.append(string + ",");
            }

            System.err.println("Environment variables missing: " + builder.substring(0, builder.length()-1));
            System.exit(0);
        }
    }
}
