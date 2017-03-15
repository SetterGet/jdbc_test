import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell on 15.03.2017.
 */
public class Start {
    public static void main(String[] args) {
        DBConnector connector = new DBConnector();

        String querySelect = "SELECT *FROM spr_company;";

        String sqlInsert = "INSERT INTO spr_company(name) VALUES ('TurboBus');";

//        String sqlUpdate = "UPDATE spr_company SET name = 'SlowAir' WHERE id = 1);";
                           //"UPDATE spr_company SET desc = 'This plane has classic speed and normal price';";

        try {
            Statement statement = connector.getConnection().createStatement();

//            statement.executeUpdate(sqlUpdate);
//             statement.execute(sqlInsert);

            Company company;
            ResultSet resultSet = statement.executeQuery(querySelect);

            List<Company> companyList = new ArrayList<Company>();
            while (resultSet.next()) {
                company = new Company();
                company.setId(resultSet.getLong("id"));
                company.setName(resultSet.getString("name"));
                company.setDesc(resultSet.getString("desc"));
                companyList.add(company);
            }

            System.out.println(companyList);

        } catch (SQLException e) {
            System.err.println("Error create statement");
        }
    }
}
