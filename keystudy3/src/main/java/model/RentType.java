package model;

public class RentType {
    Integer renTypeId;
    String renTypeName;
    double rentTypeCost;

    public RentType() {
    }

    public RentType(Integer renTypeId, String renTypeName, double rentTypeCost) {
        this.renTypeId = renTypeId;
        this.renTypeName = renTypeName;
        this.rentTypeCost = rentTypeCost;
    }

    public Integer getRenTypeId() {
        return renTypeId;
    }

    public void setRenTypeId(Integer renTypeId) {
        this.renTypeId = renTypeId;
    }

    public String getRenTypeName() {
        return renTypeName;
    }

    public void setRenTypeName(String renTypeName) {
        this.renTypeName = renTypeName;
    }

    public double getRentTypeCost() {
        return rentTypeCost;
    }

    public void setRentTypeCost(double rentTypeCost) {
        this.rentTypeCost = rentTypeCost;
    }
}
