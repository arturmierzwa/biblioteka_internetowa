package pl.am.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
public class DatabaseConfiguration {
   
	 @Bean //definicja obiektu
	   public EntityManagerFactory entityManagerFactory(DataSource dataSource) {

	       HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	       vendorAdapter.setGenerateDdl(true);

	       LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
	       factory.setJpaVendorAdapter(vendorAdapter);
	       factory.setPackagesToScan("pl.am.model");
	       factory.setDataSource(dataSource);
	       factory.afterPropertiesSet();

	       return factory.getObject();
	   }

	   @Bean //do obslugi transakcji, nieobligatoryjne w mojej aplikacji
	   public PlatformTransactionManager transactionManager(DataSource dataSource) {
	       JpaTransactionManager txManager = new JpaTransactionManager();
	       txManager.setEntityManagerFactory(entityManagerFactory(dataSource));
	       return txManager;
	   }
}