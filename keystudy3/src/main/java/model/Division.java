package model;

public class Division {
   private Integer divison_Id;
   private String divison_Name;

    public Division(Integer divison_Id, String divison_Name) {
        this.divison_Id = divison_Id;
        this.divison_Name = divison_Name;
    }

    public Division() {
    }

    public Integer getDivison_Id() {
        return divison_Id;
    }

    public void setDivison_Id(Integer divison_Id) {
        this.divison_Id = divison_Id;
    }

    public String getDivison_Name() {
        return divison_Name;
    }

    public void setDivison_Name(String divison_Name) {
        this.divison_Name = divison_Name;
    }
}
