package gov.ssa.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import gov.ssa.entity.Account;
import gov.ssa.entity.Building;
import gov.ssa.entity.Class;
import gov.ssa.entity.ClassList;
import gov.ssa.entity.Classroom;
import gov.ssa.entity.Department;
import gov.ssa.entity.Instructor;
import gov.ssa.entity.Major;
import gov.ssa.entity.MajorClass;
import gov.ssa.entity.Prerequisite;
import gov.ssa.entity.SchoolYear;
import gov.ssa.entity.Student;
import gov.ssa.entity.StudentClassesTaken;

@Configuration
@EnableTransactionManagement
public class DbConfiguration {
	
	@Bean
    public HibernateTemplate hibernateTemplate() {
        return new HibernateTemplate(sessionFactory());
    }

    @Bean
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/education?autoReconnect=true&useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("evig1212");
        return dataSource;
    }

    @Bean
    public SessionFactory sessionFactory() {
        return new LocalSessionFactoryBuilder(getDataSource()).addAnnotatedClasses(Major.class)
        													  .addAnnotatedClasses(SchoolYear.class)
        													  .addAnnotatedClasses(Student.class)
        													  .addAnnotatedClasses(Department.class)
        													  .addAnnotatedClasses(Class.class)
        													  .addAnnotatedClasses(Instructor.class)
        													  .addAnnotatedClasses(MajorClass.class)
        													  .addAnnotatedClasses(Building.class)
        													  .addAnnotatedClasses(Classroom.class)
        													  .addAnnotatedClasses(ClassList.class)
        													  .addAnnotatedClasses(StudentClassesTaken.class)
        													  .addAnnotatedClasses(Prerequisite.class)
        													  .addAnnotatedClasses(Account.class)
                .buildSessionFactory();
    }

    @Bean
    public HibernateTransactionManager hibTransMan() {
        return new HibernateTransactionManager(sessionFactory());
    }
	
}
