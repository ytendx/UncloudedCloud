package de.ytendx.mccloud.common.configuration;

import de.ytendx.mccloud.api.database.NullDefault;
import lombok.Getter;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * This is a special class used to manage environmental variables.
 * Provides an easy use and looks out for non-existent env variables.
 * <p>
 * By using @Nullable annotations you are able to let a field be null.
 */
@Getter
public class EnviromentalConfigurationValueContainer {

    @Nullable
    private String redisPW;

    private String redisURL;

    @NullDefault(value = "./config")
    private String configCachePath;

    @NullDefault(value = "./tmp")
    private String tempPath;

    @NullDefault(value = "./static")
    private String staticPath;

    public EnviromentalConfigurationValueContainer() throws IllegalAccessException {
        final List<String> nullEnvVariables = new ArrayList<>();

        for (Field field : this.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            String value = System.getenv(field.getName().toUpperCase(Locale.ROOT));

            handleSetField: {
                if (value == null && field.isAnnotationPresent(NullDefault.class)) {
                    field.set(this, field.getAnnotation(NullDefault.class).value());
                    break handleSetField;
                }

                if (value == null && !field.isAnnotationPresent(Nullable.class)) {
                    // TODO: Fix
                    System.out.println(field.getName());
                    field.set(this, value);
                    nullEnvVariables.add(field.getName().toUpperCase(Locale.ROOT));
                    break handleSetField;
                }

                field.set(this, value);
            }
        }

        if(this.getClass().getSuperclass() != null){
            for (Field field : this.getClass().getSuperclass().getDeclaredFields()) {
                field.setAccessible(true);
                String value = System.getenv(field.getName().toUpperCase(Locale.ROOT));

                try {
                    handleSetField: {

                        if (value == null && !field.isAnnotationPresent(Nullable.class)) {
                            // TODO: Fix
                            field.set(this, value);
                            //nullEnvVariables.add(field.getName().toUpperCase(Locale.ROOT));
                            break handleSetField;
                        }

                        field.set(this, value);
                    }
                } catch (Exception ignored){
                    // TODO: Handle? Ignored
                }
            }
        }

        if (nullEnvVariables.size() > 0) {
            StringBuilder builder = new StringBuilder();

            for (String string : nullEnvVariables) {
                builder.append(string + ",");
            }

            System.err.println("Environment variables missing: " + builder.substring(0, builder.length() - 1));
            System.exit(0);
        }
    }
}
