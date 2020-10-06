package model;

public class TypeOfCustomer {
    private int idCustomerType;
    private String nameTypeCustomer;

    public TypeOfCustomer(int idCustomerType, String nameTypeCustomer) {
        this.idCustomerType = idCustomerType;
        this.nameTypeCustomer = nameTypeCustomer;
    }

    public TypeOfCustomer() {
    }

    public int getIdCustomerType() {
        return idCustomerType;
    }

    public void setIdCustomerType(int idCustomerType) {
        this.idCustomerType = idCustomerType;
    }

    public String getNameTypeCustomer() {
        return nameTypeCustomer;
    }

    public void setNameTypeCustomer(String nameTypeCustomer) {
        this.nameTypeCustomer = nameTypeCustomer;
    }

    @Override
    public String toString() {
        return "TypeOfCustomer{" +
                "idCustomerType=" + idCustomerType +
                ", nameTypeCustomer='" + nameTypeCustomer + '\'' +
                '}';
    }
}
