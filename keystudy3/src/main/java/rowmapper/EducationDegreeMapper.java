package rowmapper;

import model.EducationDegree;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EducationDegreeMapper implements RowMapper<EducationDegree> {
    @Override
    public EducationDegree mapRow(ResultSet resultSet) throws SQLException {
        EducationDegree educationDegree =new EducationDegree();
        educationDegree.setEducation_Degree(resultSet.getInt("education_degree_id"));
        educationDegree.setEducation_Degree_Name("education_degree_name");
        return educationDegree;
    }
}
