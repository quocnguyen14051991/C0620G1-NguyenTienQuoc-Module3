package model;

public class EducationDegree {
    private Integer education_Degree;
    private String education_Degree_Name;

    public EducationDegree(Integer education_Degree, String education_Degree_Name) {
        this.education_Degree = education_Degree;
        this.education_Degree_Name = education_Degree_Name;
    }

    public EducationDegree() {
    }

    public Integer getEducation_Degree() {
        return education_Degree;
    }

    public void setEducation_Degree(Integer education_Degree) {
        this.education_Degree = education_Degree;
    }

    public String getEducation_Degree_Name() {
        return education_Degree_Name;
    }

    public void setEducation_Degree_Name(String education_Degree_Name) {
        this.education_Degree_Name = education_Degree_Name;
    }
}
