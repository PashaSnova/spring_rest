package com.xen.spring.rest.dao;

import com.xen.spring.rest.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDaoImplementation implements EmployeeDao {

    @Autowired
    private SessionFactory factory;

    @Override
    public List<Employee> getAllEmployees() {
        Session session = factory.getCurrentSession();
        return session
                .createQuery("from Employee", Employee.class)
                .getResultList();
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session = factory.getCurrentSession();
        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        Session session = factory.getCurrentSession();
        return session.get(Employee.class, id);
    }

    @Override
    public void deleteEmployee(int id) {
        Session session = factory.getCurrentSession();
        Query query = session.createQuery("delete from Employee " +
                "where id =:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
