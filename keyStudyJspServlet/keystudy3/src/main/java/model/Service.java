package model;

public class Service {
     private Integer service_Id ;
     private String service_Name;
     private int area;
     private double service_Cost;
     private int service_Max_Peole;
     private Integer rent_Type_ID;
     private Integer service_Type_Id;
     private String standard_Room;
     private String description_Other;
     private double pool_Area;
     private int number_Of_Floor;

    public Service(Integer service_Id, String service_Name, int area, double service_Cost, int service_Max_Peole, Integer rent_Type_ID, Integer service_Type_Id,
                   String standard_Room, String description_Other, double pool_Area, int number_Of_Floor) {
        this.service_Id = service_Id;
        this.service_Name = service_Name;
        this.area = area;
        this.service_Cost = service_Cost;
        this.service_Max_Peole = service_Max_Peole;
        this.rent_Type_ID = rent_Type_ID;
        this.service_Type_Id = service_Type_Id;
        this.standard_Room = standard_Room;
        this.description_Other = description_Other;
        this.pool_Area = pool_Area;
        this.number_Of_Floor = number_Of_Floor;
    }

    public Service() {
    }

    public Integer getService_Id() {
        return service_Id;
    }

    public void setService_Id(Integer service_Id) {
        this.service_Id = service_Id;
    }

    public String getService_Name() {
        return service_Name;
    }

    public void setService_Name(String service_Name) {
        this.service_Name = service_Name;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public double getService_Cost() {
        return service_Cost;
    }

    public void setService_Cost(double service_Cost) {
        this.service_Cost = service_Cost;
    }

    public int getService_Max_Peole() {
        return service_Max_Peole;
    }

    public void setService_Max_Peole(int service_Max_Peole) {
        this.service_Max_Peole = service_Max_Peole;
    }

    public Integer getRent_Type_ID() {
        return rent_Type_ID;
    }

    public void setRent_Type_ID(Integer rent_Type_ID) {
        this.rent_Type_ID = rent_Type_ID;
    }

    public Integer getService_Type_Id() {
        return service_Type_Id;
    }

    public void setService_Type_Id(Integer service_Type_Id) {
        this.service_Type_Id = service_Type_Id;
    }

    public String getStandard_Room() {
        return standard_Room;
    }

    public void setStandard_Room(String standard_Room) {
        this.standard_Room = standard_Room;
    }

    public String getDescription_Other() {
        return description_Other;
    }

    public void setDescription_Other(String description_Other) {
        this.description_Other = description_Other;
    }

    public double getPool_Area() {
        return pool_Area;
    }

    public void setPool_Area(double pool_Area) {
        this.pool_Area = pool_Area;
    }

    public int getNumber_Of_Floor() {
        return number_Of_Floor;
    }

    public void setNumber_Of_Floor(int number_Of_Floor) {
        this.number_Of_Floor = number_Of_Floor;
    }

    @Override
    public String toString() {
        return "Service{" +
                "service_Id=" + service_Id +
                ", service_Name='" + service_Name + '\'' +
                ", area=" + area +
                ", service_Cost=" + service_Cost +
                ", service_Max_Peole=" + service_Max_Peole +
                ", rent_Type_ID=" + rent_Type_ID +
                ", service_Type_Id=" + service_Type_Id +
                ", standard_Room='" + standard_Room + '\'' +
                ", description_Other='" + description_Other + '\'' +
                ", pool_Area=" + pool_Area +
                ", number_Of_Floor=" + number_Of_Floor +
                '}';
    }
}
