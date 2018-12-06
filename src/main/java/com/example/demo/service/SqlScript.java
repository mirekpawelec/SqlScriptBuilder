package com.example.demo.service;

import org.springframework.context.ApplicationContext;

import javax.persistence.EntityManager;
import java.util.List;

public class SqlScript {
    private ApplicationContext context;
    private EntityManager entityManager;
    private List<String> ignoreTables;

    private SqlScript() {
    }

    public static SqlScriptBuilder getBuilder(ApplicationContext context, EntityManager entityManager) {
        return new SqlScript().new SqlScriptBuilder(context, entityManager);
    }

    public String showInfo() {
        return "SqlScript (ctx:" + this.context + ", em: " + this.entityManager + ", tables: " + this.ignoreTables + ")";
    }

//    public void build(ApplicationContext ctx, EntityManager em) {
//        DefaultListableBeanFactory factory = ( DefaultListableBeanFactory )
//                ( (ConfigurableApplicationContext) ctx ).getBeanFactory();
//
//        MutablePropertyValues propertyValues = new MutablePropertyValues();
//        propertyValues.add( "context", ctx );
//        propertyValues.add( "entityManager", em );
//
//        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
//        beanDefinition.setBeanClass( SqlScript.class );
//        beanDefinition.setScope( BeanDefinition.SCOPE_SINGLETON );
//        beanDefinition.setPropertyValues( propertyValues );
//
//        factory.registerBeanDefinition( "sqlScript", beanDefinition );
//        ((ConfigurableApplicationContext) ctx).refresh();
//    }

    public class SqlScriptBuilder {
        private ApplicationContext context;
        private EntityManager entityManager;
        private List<String> ignoreTables;

        public SqlScriptBuilder(ApplicationContext context, EntityManager entityManager) {
            this.context = context;
            this.entityManager = entityManager;
        }

        public SqlScriptBuilder withIgnoreTables(List<String> ignoreTables) {
            this.ignoreTables = ignoreTables;
            return this;
        }

        public SqlScriptBuilder addIgnoreTable(String ignoreTable) {
            this.ignoreTables.add(ignoreTable);
            return this;
        }

        public SqlScript build(){
            SqlScript entity = new SqlScript();
            entity.context = this.context;
            entity.entityManager = this.entityManager;
            entity.ignoreTables = this.ignoreTables;
            return entity;
        }
    }

}
