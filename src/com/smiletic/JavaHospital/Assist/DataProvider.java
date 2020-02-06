package com.smiletic.JavaHospital.Assist;

import com.smiletic.JavaHospital.DAO.ContactdetailsEntity;
import com.smiletic.JavaHospital.DAO.PersonEntity;
import com.smiletic.JavaHospital.DAO.SexEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.metamodel.spi.MetamodelImplementor;
import org.hibernate.persister.entity.AbstractEntityPersister;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataProvider {
    private static final SessionFactory ourSessionFactory;


     static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }


    public static void insertMiniform(String name, SexEntity sex, String briefStatement, String year, String month, String day, String phone1, String phone2, String nextOfKinName, String relationship ) {
        final Session session = getSession();
        try {
            session.beginTransaction();
            PersonEntity person = new PersonEntity();
            person.setName(name);
            person.setSex(sex);
            person.setBriefStatement(briefStatement);
            String dob = year + "-" + month + "-" + day;
            person.setDateOfBirth(dob);
            ContactdetailsEntity cde = new ContactdetailsEntity();
            session.save(cde);
            cde.setTelephoneHome(phone1);
            cde.setTelephoneWork(phone2);
            person.setContactDetails(cde);
            person.setNextOfKinName(nextOfKinName);
            person.setNextOfKinRelationshipWithPatient(relationship);
            session.save(person);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    public static <T> List<T> getListofAllEntities(Class<T> c){
         final Session session = getSession();

        List<T> list;
        try {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<T> criteria  = cb.createQuery(c);
            criteria.from(c);
            list = new ArrayList<T> (session.createQuery(criteria).getResultList());
        } finally {
            session.close();
        }

        return list;

    }
//    public static List<PersonEntity> getAllPersons(){
//        final Session session = getSession();
//        CriteriaBuilder cb = session.getCriteriaBuilder();
//        CriteriaQuery<PersonEntity> criteria  = cb.createQuery(PersonEntity.class);
//        criteria.from(PersonEntity.class);
//        return session.createQuery(criteria).getResultList();
//    }




    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static<T> List<String> getColumnNames(Class<T> c){
        MetamodelImplementor metamodel = (MetamodelImplementor) ourSessionFactory.getMetamodel();
        ClassMetadata classMetadata = (ClassMetadata) metamodel.entityPersister(c);
        return Arrays.asList(classMetadata.getPropertyNames());
    }
}
