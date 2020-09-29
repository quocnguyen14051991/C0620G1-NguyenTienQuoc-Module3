package service;

import model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImp implements CustomerService {
    private static Map<Integer, Customer> customers;

    static {
        customers = new HashMap<>();
        customers.put(1, new Customer(1, "Doan Chi Binh", "quocnguyen@gmail.com", "Da nang"));
        customers.put(2, new Customer(2, "Nguyen Tien Quang", "quocnguyen@gmail.com", "Da nang"));
        customers.put(3, new Customer(3, "Nguyen Tien Quy", "quocnguyen@gmail.com", "Da nang"));
        customers.put(4, new Customer(4, "Nguyen Tien Phuong", "quocnguyen@gmail.com", "Da nang"));
        customers.put(5, new Customer(5, "Nguyen Tien Truong", "quocnguyen@gmail.com", "Da nang"));
        customers.put(6, new Customer(6, "Lam Chi Khanh", "quocnguyen@gmail.com", "Da nang"));
        customers.put(7, new Customer(7, "Duong Qua", "quocnguyen@gmail.com", "Da nang"));
        customers.put(8, new Customer(8, "Tieu Long Nu", "quocnguyen@gmail.com", "Da nang"));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<Customer>(customers.values());
    }

    @Override
    public void save(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    @Override
    public Customer findById(int id) {
        return customers.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customers.put(id, customer);
    }

    @Override
    public void remove(int id) {
        customers.remove(id);
    }
}
