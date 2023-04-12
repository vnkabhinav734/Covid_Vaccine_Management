package model.user;

import database.DatabaseConnection;
import model.vaccinationDetails.VaccinationDetailsDatabaseColumns;
import model.vaccinationDetails.VaccinationDetailsQuery;
import model.vaccinationDetails.VaccinationStatus;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class VaccinationStatusUpdateImpl {

	public boolean updateVaccinationStatus(User user){
		try {

			Connection connection = DatabaseConnection.instance().getDatabaseConnection();
			Statement statement=connection.createStatement();
			String query= VaccinationDetailsQuery.fetchVaccinationDetailsQuery(user.getUserId());
			ResultSet resultSet=statement.executeQuery(query);
			String currentVaccinationStatus=new String();
			if(resultSet.next()) {
				currentVaccinationStatus= resultSet.getString(VaccinationDetailsDatabaseColumns.vaccination_status);
			}

			if(currentVaccinationStatus.isEmpty())
			{
				Statement updateStatement=connection.createStatement();
				String updateQuery=UserQuery.instance().updateVaccinationStatus(user, VaccinationStatus.partially_vaccinated);
				int rowCount=updateStatement.executeUpdate(updateQuery);
				if (rowCount > 0)
				{
					return true;
				}
			}
			else {
				Statement updateStatement=connection.createStatement();
				String updateQuery=UserQuery.instance().updateVaccinationStatus(user,VaccinationStatus.fully_vaccinated);
				int rowCount=updateStatement.executeUpdate(updateQuery);
				if (rowCount > 0)
				{
					return true;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
}
