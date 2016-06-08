package utils.hibernate;

import org.hibernate.cfg.ImprovedNamingStrategy;

/**
 * A custom naming strategy implementation which uses following naming conventions:
 * <ul>
 * <li>Table names are lower case and in plural form. Words are separated with '_' character.</li>
 * <li>Column names are lower case and words are separated with '_' character.</li>
 * </ul>
 */
public class CustomNamingStrategy extends ImprovedNamingStrategy {

    /**
     * Transforms class names to table names by using the described naming conventions.
     *
     * @param className
     * @return The constructed table name.
     */
    @Override
    public String classToTableName(String className) {
        String tableNameInSingularForm = super.classToTableName(className);
        return tableNameInSingularForm;
    }
}