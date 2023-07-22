import java.util.List;
import java.util.Scanner;

import Service.StudentDao;
import model.Student;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			StudentDao service = new StudentDao();
			
			System.out.println("Welcome to Student Management Appliction");
			boolean flag = true;
			
			Student stu = null;
			int id;
			String name, city, phone;
			boolean check;
			
			while(flag) {
				System.out.println("-----------------------------------------------------------------------------------------");
				System.out.println("|\t\t\t\t\tMENU\t\t\t\t\t\t|");
				System.out.println("-----------------------------------------------------------------------------------------");
				System.out.println("| 1. Insert Student to the Database.\t|\t 2. Update Student to the Database.\t|");
				System.out.println("| 3. Delete Student to the Database.\t|\t 4. View all Student from the Database.\t|");
				System.out.println("| 5. Check Student Information.\t\t|\t 6. Close the Application.\t\t|");
				System.out.println("-----------------------------------------------------------------------------------------");
				System.out.print("Enter Choice --> ");
				//sc.nextLine();
				int choice = Integer.parseInt(sc.nextLine());
					switch(choice) {
					case 1:
						System.out.print("Enter Student Name --> ");
						name = sc.nextLine();
						System.out.print("Enter Student Phone Number --> ");
						phone = sc.nextLine();
						System.out.print("Enter Student Current City --> ");
						city =sc.nextLine();
						boolean data = service.insertStudent(new Student(name, phone, city));
						if(data)
							System.out.println("Insertion Successfully !!!");
						else 
							System.out.println("Insertion not done !!!");
						break;
					case 2:
						System.out.println("Enter id to update");
						id  = sc.nextInt();
						stu = service.viewStudent(id);
						if(stu == null) {
							System.out.println("Invalid Id !!! ID Not Found !!!");
							sc.nextLine();
							break;
						}
						System.out.println("Current Information -->");
						System.out.println("Name: "+stu.getStudentName());
						System.out.println("Phone Number: "+stu.getStudentPhNumber());
						System.out.println("City: "+stu.getStudentCity());
						System.out.println("---------------------------------------------------------------------------");
						System.out.println("|\t\t\t\tUPDATE MENU\t\t\t\t|");
						System.out.println("---------------------------------------------------------------------------");
						System.out.println("| 1. Update all Information.\t|\t 2. Update Student Name.\t|");
						System.out.println("| 3. Update Student Phone.\t|\t 4. Update Student City.\t|");
						System.out.println("---------------------------------------------------------------------------");
						System.out.println("Which one to Update --> ");
						sc.nextLine();
						int uchoice = Integer.parseInt(sc.nextLine()); 
						switch(uchoice){
						case 1:
							System.out.print("Enter Student Name --> ");
							name = sc.nextLine();
							System.out.print("Enter Student Phone Number --> ");
							phone = sc.nextLine();
							System.out.print("Enter Student Current City --> ");
							city =sc.nextLine();
							check = service.updateStudent(id, name, phone, city);
							if(check)System.out.println("Updation done!!!");
							else System.out.println("updation not done!!!");
							break;
						case 2:
							System.out.print("Enter Student Name --> ");
							name = sc.nextLine();
							check = service.updateStudentName(id, name);
							if(check)System.out.println("Updation done!!!");
							else System.out.println("updation not done!!!");
							break;
						case 3:
							System.out.print("Enter Student Phone Number --> ");
							phone = sc.nextLine();
							check = service.updateStudentPhone(id, phone);
							if(check)System.out.println("Updation done!!!");
							else System.out.println("updation not done!!!");
							break;
						case 4:
							System.out.print("Enter Student Current City --> ");
							city =sc.nextLine();
							check = service.updateStudentCity(id, city);
							if(check)System.out.println("Updation done!!!");
							else System.out.println("updation not done!!!");
							break;
						default:
							System.out.println("Not Possible...");
							break;
						}
						break;
					case 3:
						System.out.print("Enter Student Id --> ");
						id  = Integer.parseInt(sc.nextLine());
						stu = service.viewStudent(id);
						if(stu == null) {
							System.out.println("Enter Valid Id..."); 
							break;
						}
						System.out.println("Id: "+stu.getStudentId());
						System.out.println("Name: "+stu.getStudentName());
						System.out.println("Phone Number: "+stu.getStudentPhNumber());
						System.out.println("City: "+stu.getStudentCity());
						check = service.deleteStudent(id);
						if(check) {
							System.out.println("\nDeletion done!!!");
						}
						else System.out.println("Deletion not done!!!");
						break;
					case 4:
						List<Student> record = service.viewAllStudent();
						if(record.isEmpty()) {
							System.out.println("No Record Found.........."); 
							break;
						}
						System.out.println("All Students Information -->");
						System.out.println("id\t\tName\t\t\tPhone\t\t\t   City");
						System.out.println();
						for(Student st : record)
							System.out.println(+st.getStudentId()+"\t\t"+st.getStudentName()
									+"\t\t"+st.getStudentPhNumber()+"\t\t"+st.getStudentCity());
						break;
					case 5:
						System.out.println("Enter Student Id");
						id  = Integer.parseInt(sc.nextLine());
						stu = service.viewStudent(id);
						System.out.println("Student Detalis.......");
						System.out.println("Name: "+stu.getStudentName());
						System.out.println("Phone Number: "+stu.getStudentPhNumber());
						System.out.println("City: "+stu.getStudentCity());
						break;
					case 6:
						flag = false;
						System.out.println("Application Closed !");
						System.out.println("Thank You For Visiting Application");
						break;
					default:
						System.out.println("Wrong Choice!!! Enter Valid Choice.......");
						break;
					}
			}
			service.close(); // connection closed
		} catch (Exception e) {
			System.out.println("Something went wrong.......");
			e.printStackTrace();
		}
		
		sc.close();
	}

}
