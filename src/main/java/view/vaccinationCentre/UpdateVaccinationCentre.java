package view.vaccinationCentre;

import java.util.Scanner;

import controller.vaccinationCentreDetails.VaccinationCentreDetailsController;
import model.vaccinationCentre.VaccinationCenterDatabaseColumns;
import model.vaccinationCentre.VaccinationCentreDetailsImpl;

public class UpdateVaccinationCentre {

	public void display(Scanner scanner) {
		try {
			System.out.println("Enter the Centre number that you want to Update\n");
			String updateResult="";
			String centre_number=scanner.nextLine();
			char ch;

			do
			{
				scanner=new Scanner(System.in);
				String value;
				VaccinationCentreDetailsImpl vaccinationCentreDetailsImpl=new VaccinationCentreDetailsImpl();
				VaccinationCentreDetailsController vaccinationCentreDetailsController=new VaccinationCentreDetailsController(vaccinationCentreDetailsImpl);
				System.out.println("1. Centre code\n"
						+ "2. Centre name\n"
						+ "3. Centre address\n"
						+ "4. Centre city\n"
						+ "5. Centre zip");

				System.out.println("Select an Option");
				String input = scanner.nextLine();
				switch(input) {
				case "1":
					System.out.println("Enter the "+VaccinationCenterDatabaseColumns.centre_code+" value");
					value=scanner.nextLine();
					updateResult=vaccinationCentreDetailsController.updateVaccinationCentreDetailsController(centre_number,VaccinationCenterDatabaseColumns.centre_code,value);
					System.out.println(updateResult);
					break;
				case "2": 
					System.out.println("Enter the "+VaccinationCenterDatabaseColumns.centre_name+" value");
					value=scanner.nextLine();
					updateResult=vaccinationCentreDetailsController.updateVaccinationCentreDetailsController(centre_number,VaccinationCenterDatabaseColumns.centre_name,value);
					System.out.println(updateResult);
					break;
				case "3": 
					System.out.println("Enter the "+VaccinationCenterDatabaseColumns.centre_address+" value");
					value=scanner.nextLine();
					updateResult=vaccinationCentreDetailsController.updateVaccinationCentreDetailsController(centre_number,VaccinationCenterDatabaseColumns.centre_address,value);
					System.out.println(updateResult);
					break;
				case "4": 				
					System.out.println("Enter the "+VaccinationCenterDatabaseColumns.centre_city+" value");
					value=scanner.nextLine();
					updateResult=vaccinationCentreDetailsController.updateVaccinationCentreDetailsController(centre_number,VaccinationCenterDatabaseColumns.centre_city,value);
					System.out.println(updateResult);
					break;
				case "5": 				
					System.out.println("Enter the "+VaccinationCenterDatabaseColumns.centre_zip+" value");
					value=scanner.nextLine();
					updateResult=vaccinationCentreDetailsController.updateVaccinationCentreDetailsController(centre_number,VaccinationCenterDatabaseColumns.centre_zip,value);
					System.out.println(updateResult);
					break;
				}
				if(updateResult.equals("Wrong Centre code"))
				{
					break;
				}
				System.out.println("Do you want to Update more fields?");
				ch=scanner.next().charAt(0);
			}while(ch=='y');
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
