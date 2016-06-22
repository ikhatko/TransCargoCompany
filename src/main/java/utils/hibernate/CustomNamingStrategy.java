package utils.hibernate;

import org.hibernate.cfg.ImprovedNamingStrategy;

/**
 * The type Custom naming strategy.
 */
public class CustomNamingStrategy extends ImprovedNamingStrategy {

    @Override
    public String classToTableName(String className) {
        String tableNameInSingularForm = super.classToTableName(className);
        return tableNameInSingularForm;
    }

}