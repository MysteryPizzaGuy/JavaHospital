package com.smiletic.JavaHospital.Assist;

import com.smiletic.JavaHospital.DAO.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.metamodel.spi.MetamodelImplementor;
import org.hibernate.persister.entity.AbstractEntityPersister;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
    public static void insertDoctor(String name, SpecializationEntity spec){
        final Session session = getSession();
        try {
            session.beginTransaction();
            DoctorEntity doc = new DoctorEntity();
            doc.setName(name);
            doc.setSpecialization(spec);
            session.save(doc);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    public static void insertAppointment(String fromDate, String toDate,String fromTime, String toTime, PersonEntity patient, DoctorEntity doctor){
        final Session session = getSession();
        String DateTimeFrom = fromDate+ " " + fromTime;
        String DateTimeTo = toDate + " " +toTime;
        try {
            session.beginTransaction();
            AppointmentEntity appo = new AppointmentEntity();
            appo.setFromDate(DateTimeFrom);
            appo.setToDate(DateTimeTo);
            appo.setPatient(patient);
            appo.setDoctor(doctor);
            session.save(appo);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }
    public static void deleteAppointment(AppointmentEntity appo){
        final Session session = getSession();
        try {
            session.beginTransaction();
            session.delete(appo);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }


    public static void updateDoctor(String name, SpecializationEntity spec,DoctorEntity doctor){
        final Session session = getSession();
        try {
            session.beginTransaction();
            doctor.setName(name);
            doctor.setSpecialization(spec);
            session.update(doctor);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }
    public static void deleteDoctor(DoctorEntity doctor){
        final Session session = getSession();
        try {
            session.beginTransaction();
            session.delete(doctor);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }


    public static void insertAvailability(String dateFrom, String dateTo, String timeFrom, String timeTo,DoctorEntity doctor){
         final Session session = getSession();
         try{
             session.beginTransaction();
             AvailabilityEntity avail = new AvailabilityEntity();
             avail.setDoctor(doctor);
             avail.setFromDate(dateFrom);
             avail.setToDate(dateTo);
             avail.setFromTime(timeFrom);
             avail.setToTime(timeTo);

             session.save(avail);
             session.getTransaction().commit();
         }finally {
             session.close();
         }

    }
    public static void updateAvailability(String dateFrom, String dateTo, String timeFrom, String timeTo,DoctorEntity doctor,AvailabilityEntity existing){
        final Session session = getSession();
        try{

            session.beginTransaction();
            existing.setDoctor(doctor);
            existing.setFromDate(dateFrom);
            existing.setToDate(dateTo);
            existing.setFromTime(timeFrom);
            existing.setToTime(timeTo);

            session.update(existing);
            session.getTransaction().commit();
        }finally {
            session.close();
        }

    }
    public static void deleteAvailability(AvailabilityEntity avail){
        final Session session = getSession();
        try{

            session.beginTransaction();
            session.delete(avail);
            session.getTransaction().commit();
        }finally {
            session.close();
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
    public static List<DoctorEntity> getListofDoctorsforAppointment(String dateFrom, String dateTo, String timeFrom, String timeTo){
        final Session session = getSession();
        List<DoctorEntity> results = new ArrayList<>();
        String DateTimeFrom = dateFrom+ " " + timeFrom;
        String DateTimeTo = dateTo + " " +timeTo;

        try {
            session.beginTransaction();
            String hq = "select doc from DoctorEntity as doc " +
                    "INNER JOIN doc.availabilities as avail" +
                    " INNER JOIN doc.appointments as app "+
                    " WHERE (avail.fromDate<=:dateFromTarget AND avail.toDate>=:dateToTarget AND avail.fromTime<=:timeFromTarget AND avail.toTime>=:timeToTarget) "+
                    " group by doc.idDoctor ";
            Query query = session.createQuery(hq);
            query.setParameter("dateFromTarget",dateFrom);
            query.setParameter("dateToTarget",dateTo);
            query.setParameter("timeFromTarget",timeFrom);
            query.setParameter("timeToTarget",timeTo);

            String sq = "select doc from DoctorEntity as doc " +
                        "INNER JOIN doc.availabilities as avail" +
                        " INNER JOIN doc.appointments as app "+
                        " WHERE  app.fromDate <:dateTimeTo AND app.toDate>:dateTimeFrom"+
                        " group by doc.idDoctor ";
            Query query2 = session.createQuery(sq);
            query2.setParameter("dateTimeFrom",DateTimeFrom);
            query2.setParameter("dateTimeTo",DateTimeTo);


            results = query.getResultList();
            List<DoctorEntity> crossout = query2.getResultList();
            for (DoctorEntity doc:crossout
                 ) {
                if (results.contains(doc)){
                    results.remove(doc);
                }
            }

            session.getTransaction().commit();
            System.out.println(results);

        } finally {
            session.close();
        }

        return results;

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
