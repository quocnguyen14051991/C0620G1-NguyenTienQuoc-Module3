package model;

public class Position {
    private Integer position_ID;
    private String position_Name;

    public Position(Integer position_ID, String position_Name) {
        this.position_ID = position_ID;
        this.position_Name = position_Name;
    }

    public Position() {
    }

    public Integer getPosition_ID() {
        return position_ID;
    }

    public void setPosition_ID(Integer position_ID) {
        this.position_ID = position_ID;
    }

    public String getPosition_Name() {
        return position_Name;
    }

    public void setPosition_Name(String position_Name) {
        this.position_Name = position_Name;
    }
}
