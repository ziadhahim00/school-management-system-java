//Student Name : Zeyad Hashem                 ID:441009463
//Student Name : Abdulmalik Homoud            ID:441011913
//Zeyad
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
class SchoolManagement{
   String SchoolName;
   String Address;
   String ContactNumber;
   String MediumOfStudy;
   boolean open = false ;
   final ArrayList<Department> dept;
   final ArrayList<Student> stud;
   final ArrayList<Bus> bus;
   final ArrayList<Playground> play ;
   final ArrayList<Classroom> room;
   public SchoolManagement(String SchoolName,String Address,String ContactNumber,String MediumOfStudy){
      this.SchoolName=SchoolName;
      this.Address=Address;
      this.ContactNumber=ContactNumber;
      this.MediumOfStudy=MediumOfStudy;
      this.dept=new ArrayList<Department>();
      this.stud=new ArrayList<Student>();
      this.bus=new ArrayList<Bus>();
      this.play=new ArrayList<Playground>();
      this.room=new ArrayList<Classroom>();
   }
   public void setOpen(){
      open = true;
   }
   public void IsOpen(){
      if (open==true)
         System.out.println("School is open");
      else 
         System.out.println("School is closed");
   }
   public void SchoolDetails(){
      System.out.println(SchoolName);
      System.out.println(Address);
      System.out.println(ContactNumber);
      System.out.println(MediumOfStudy);
   }
//Method Of Compostion Department 
   public void setDept(Department dept){
      this.dept.add(dept);
   }
   public ArrayList<Department> getDept(){
      return dept;
   }   
//Method Of Aggregating  Student
   public void setStud(Student stud){
      this.stud.add(stud);
   }
   public ArrayList<Student> getStud(){
      return stud;
   } 
//Method Of Aggregating  Bus
   public void setBus(Bus bus){
      this.bus.add(bus);
   }
   public ArrayList<Bus> getBus(){
      return bus;
   } 
 //Method Of Aggregating  Playground
   public void setPlay(Playground play){
      this.play.add(play);
   }
   public ArrayList<Playground> getPlay(){
      return play;
   } 
   
   public void setroom(Classroom room) {
      this.room.add(room);
   } 
   public ArrayList<Classroom> getRoom(){
      return room;
   } 
  
  
}
//Zeyad
class Classroom{
   String ClassId;
   String ClassName;
   String TeacherId;
   int StudentCount;
   String  EquipmentId;
   public Classroom(){
   
   }
   public Classroom(String ClassId,String ClassName,String TeacherId,int StudentCount,String  EquipmentId){
      this.ClassId=ClassId;
      this.ClassName=ClassName;
      this.TeacherId=TeacherId;
      this.StudentCount=StudentCount;
      this.EquipmentId=EquipmentId;
   
   }
   public void ClassDetails() {
      System.out.println("Class details");
      System.out.println("Class Name: "+ClassName);
      System.out.println("ClassId: "+ClassId);
      System.out.println("Equipment Id: "+EquipmentId);
      System.out.println("Student Count: "+StudentCount);
      System.out.println("Teacher Id: "+TeacherId);
   }
}

// Zeyad
class Department {
   String DepartmentId;
   String DepartmentName;
   String  InchargeName;
   String []MemberList;
   public Department(String DepartmentId,String DepartmentName,String  InchargeName,String []MemberList){
      this.DepartmentId=DepartmentId;
      this.DepartmentName=DepartmentName;
      this.InchargeName=InchargeName;
      this.MemberList=MemberList;
   }
   public void DepartmentDetails(){
      System.out.println(DepartmentId);
      System.out.println(DepartmentName);
      System.out.println(InchargeName);
      System.out.println(MemberList);
   }
}
//Abdulmalik
class Auditorium {
   private int totalSeats;         
   private int seatsOccupied;      
   private String eventName;       
   private String eventDate;       
   private String eventTime;       
   final ArrayList<SchoolManagement> school;
   public Auditorium(int totalSeats) {
      this.totalSeats = totalSeats;
      this.seatsOccupied = 0; 
      this.eventName = "";
      this.eventDate = "";
      this.eventTime = "";
      this.school=new ArrayList<SchoolManagement>();
   }
   public void bookAuditorium(String eventName, String eventDate, String eventTime, int seatsToBook) {
      if (seatsToBook <= 0) {
         System.out.println("Invalid number of seats to book.");
         return;
      }
      if (seatsOccupied + seatsToBook > totalSeats) {
         System.out.println("Not enough available seats to book " + seatsToBook + " seats.");
         return;
      }
      this.eventName = eventName;
      this.eventDate = eventDate;
      this.eventTime = eventTime;
      this.seatsOccupied += seatsToBook;
      System.out.println("Auditorium booked for event: " + eventName);
      System.out.println("Date: " + eventDate + ", Time: " + eventTime);
      System.out.println("Seats booked: " + seatsToBook);
   }
   public void eventDetails() {
      if (eventName.isEmpty()) {
         System.out.println("No event is currently booked.");
      } else {
         System.out.println("Event Name: " + eventName);
         System.out.println("Event Date: " + eventDate);
         System.out.println("Event Time: " + eventTime);
         System.out.println("Seats Occupied: " + seatsOccupied + "/" + totalSeats);
      }
   }
   public void displaySeats() {
      int availableSeats = totalSeats - seatsOccupied;
      System.out.println("Available Seats: " + availableSeats);
   }
//Zeyad : Method Of Assosietion  SchoolManagement
   public void setSchool(SchoolManagement school){
      this.school.add(school);
   }
   public ArrayList<SchoolManagement> getSchool(){
      return school;
   }
}
   
   //Abdulmalik
abstract class Student{
   public String StudentId;
   public String StudentName;
   public String Section;
   public String BusId;
   double fees;
   final ArrayList<Classroom> room; 
   public Student(String StudentId,String StudentName,String Section,String BusId){
      this.StudentId=StudentId;
      this.StudentName=StudentName;
      this.Section=Section;
      this.BusId=BusId;
      this.room=new ArrayList<Classroom>();
   }
   public void StudentDetails(){
      System.out.println(StudentId);
      System.out.println(StudentName);
      System.out.println(Section);
      System.out.println(BusId);
   }
   public void setFees(double fees){
      this.fees=fees;
   }
   public double getFees(){
      return fees;
   }
   public void PayFees(double Paid){
      System.out.println("Total Fees is : "+ fees);
      System.out.println("Amount paid : "+ Paid);
      System.out.println("Remaining fees is :"+(fees - Paid));
      this.fees=fees - Paid;
   }
   
   //Zeyad : Method Of Association  Classroom
   public void setRoom(Classroom room){
      this.room.add(room);
   }
   public ArrayList<Classroom> getRoom(){
      return room;
   } 
     
}


//Zeyad
class PrimaryStudent extends Student {
   public PrimaryStudent(String studentId, String studentName, String section, String busId) {
      super(studentId, studentName, section, busId); 
   }    
   
}
//Zeyad
class HigherSecondaryStudent extends Student {
   public HigherSecondaryStudent(String studentId, String studentName, String section, String busId) {
      super(studentId, studentName, section, busId); 
   }

}
//Abdulmalik
class NoticeBoard {
   private List<String> newsList; 
   private String inchargeName;    
   final ArrayList<Student> stud;
   public NoticeBoard(String inchargeName) {
      this.inchargeName = inchargeName;
      this.newsList = new ArrayList<>(); 
      this.stud=new ArrayList<Student>();
   }
   public void addContent(String content) {
      newsList.add(content);
      System.out.println("New content added: " + content);
   }
   public void display() {
      System.out.println("Notice Board Incharge: " + inchargeName);
      System.out.println("News and Events:");
      if (newsList.isEmpty()) {
         System.out.println("No news or events to display.");
      } else {
         for (String news : newsList) {
            System.out.println("- " + news);
         }
      
      }
   }
      
//Zeyad : Method Of Student
   public void setStud(Student stud){
      this.stud.add(stud);
   }
   public ArrayList<Student> getStud(){
      return stud;
   }    
}
      
          

// Abdulmalik
abstract class Equipment {
   protected String equipmentId; 
   protected double cost;         
   final ArrayList<Lab> lab;
   
   public Equipment(String equipmentId, double cost) {
      this.equipmentId = equipmentId;
      this.cost = cost;
      this.lab=new ArrayList<Lab>();
   }
   public abstract void equipmentDetails();
    
   public void purchaseEquipment(String equipmentId, double cost) {
      this.equipmentId = equipmentId;
      this.cost = cost;
      System.out.println("Purchased Equipment ID: " + equipmentId + " with cost: $" + cost);
   }
   public void repair() {
      System.out.println("Repairing equipment ID: " + equipmentId);
   }
//MZeyad :Method Of Lab
   public void setLap(Lab lab){
      this.lab.add(lab);
   }
   public ArrayList<Lab> getlab(){
      return lab;
   }    
}

//Abdulmalik
class LabEquipment extends Equipment {
   private String equipmentName;  
   private int equipmentCount;     

   public LabEquipment(String equipmentId, double cost, String equipmentName, int equipmentCount) {
      super(equipmentId, cost);
      this.equipmentName = equipmentName;
      this.equipmentCount = equipmentCount;
   }
    
   public void equipmentDetails() {
      System.out.println("Lab Equipment ID: " + equipmentId);
      System.out.println("Name: " + equipmentName);
      System.out.println("Count: " + equipmentCount);
      System.out.println("Cost: $" + cost);
   }
}

class ClassEquipment extends Equipment {
   private String classId;        
   private int benchCount;        
   private int fanCount;          
   private int lightCount;        

   public ClassEquipment(String equipmentId, double cost, String classId, int benchCount, int fanCount, int lightCount) {
      super(equipmentId, cost);
      this.classId = classId;
      this.benchCount = benchCount;
      this.fanCount = fanCount;
      this.lightCount = lightCount;
   }
   public void equipmentDetails() {
      System.out.println("Class Equipment ID: " + equipmentId);
      System.out.println("Class ID: " + classId);
      System.out.println("Benches: " + benchCount);
      System.out.println("Fans: " + fanCount);
      System.out.println("Lights: " + lightCount);
      System.out.println("Cost: $" + cost);
   }
    
}
//Abdulmalik
class Lab {
   private String labId;         
   private String inchargeId;    
   private String labName;        
   private String equipmentId;    
   private boolean isOccupied;     
   public Lab(String labId, String inchargeId, String labName, String equipmentId) {
      this.labId = labId;
      this.inchargeId = inchargeId;
      this.labName = labName;
      this.equipmentId = equipmentId;
      this.isOccupied = false; 
   }

   public void labDetails() {
      System.out.println("Lab ID: " + labId);
      System.out.println("Lab Name: " + labName);
      System.out.println("In-charge ID: " + inchargeId);
      System.out.println("Equipment ID: " + equipmentId);
      System.out.println("Is Occupied: " + (isOccupied ? "Yes" : "No"));
   }

   public boolean isOccupied() {
      return isOccupied;
   }
   public void setOccupied(boolean occupied) {
      this.isOccupied = occupied;
   }
   public void payFine(String studentId, double fineAmount) {
      System.out.println("Student ID: " + studentId);
      System.out.println("Fine Amount for damaged equipment: $" + fineAmount);
   }
}
//Abdulmalik
abstract class Employee {
   protected String employeeId;
   protected String employeeName;
   protected double salary;
   protected String departmentId;
   protected boolean checkedIn;
   public Employee(String employeeId, String employeeName, double salary, String departmentId) {
      this.employeeId = employeeId;
      this.employeeName = employeeName;
      this.salary = salary;
      this.departmentId = departmentId;
      this.checkedIn = false;
   }
   public abstract void employeeDetails();
   public void checkIn() {
      this.checkedIn = true;
      System.out.println(employeeName + " has checked in.");
   }
   public void receiveSalary() {
      System.out.println(employeeName + " has received a salary of $" + salary);
   }
   public boolean isCheckedIn() {
      return checkedIn;
   }
}
class Teacher extends Employee {
   private String subject; 
   final ArrayList<Student> stud;
   public Teacher(String employeeId, String employeeName, double salary, String departmentId, String subject) {
      super(employeeId, employeeName, salary, departmentId);
      this.subject = subject;
      this.stud=new ArrayList<Student>();
   }
   public void employeeDetails() {
      System.out.println("Teacher ID: " + employeeId);
      System.out.println("Name: " + employeeName);
      System.out.println("Salary: $" + salary);
      System.out.println("Department ID: " + departmentId);
      System.out.println("Subject: " + subject);
      System.out.println("Checked In: " + (checkedIn ? "Yes" : "No"));
   }
    //Zeyad :Method Of Student
   public void setStud(Student stud){
      this.stud.add(stud);
   }
   public ArrayList<Student> getStud(){
      return stud;
   }      
}



class SupportStaff extends Employee {
   private String designation;

   public SupportStaff(String employeeId, String employeeName, double salary, String departmentId, String designation) {
      super(employeeId, employeeName, salary, departmentId);
      this.designation = designation;
   }

   public void employeeDetails() {
      System.out.println("Support Staff ID: " + employeeId);
      System.out.println("Name: " + employeeName);
      System.out.println("Salary: $" + salary);
      System.out.println("Department ID: " + departmentId);
      System.out.println("Designation: " + designation);
      System.out.println("Checked In: " + (checkedIn ? "Yes" : "No"));
   }
}

///Abdulmalik
class Bus {
   private String busId;          
   private String driverId;       
   private List<String> areaList; 
   private String busNumber;       
   private int capacity;           

   public Bus(String busId, String driverId, String busNumber, int capacity) {
      this.busId = busId;
      this.driverId = driverId;
      this.busNumber = busNumber;
      this.capacity = capacity;
      this.areaList = new ArrayList<>(); 
   }
    
   public void addArea(String area) {
      areaList.add(area);
   }

   public void busDetails() {
      System.out.println("Bus ID: " + busId);
      System.out.println("Driver ID: " + driverId);
      System.out.println("Bus Number: " + busNumber);
      System.out.println("Capacity: " + capacity);
      System.out.print("Areas Visited: ");
      if (areaList.isEmpty()) {
         System.out.println("No areas added.");
      } else {
         for (String area : areaList) {
            System.out.print(area + " ");
         }
         System.out.println();
      }
   }
}
    
    //Abdulmalik
class Playground {
   private double area;
   private String classId;
   private boolean occupied;
   final ArrayList<Student> stud;
   public Playground(double area, String classId, boolean occupied) {
      this.area = area;
      this.classId = classId;
      this.occupied = occupied;
      this.stud=new ArrayList<Student>();
   }
    
   public boolean isOccupied() {
      return occupied;
   }
    
   public void displayDetails() {
      System.out.println("Playground Area: " + area + " sq. meters");
      System.out.println("Class ID: " + classId);
      System.out.println("Is Occupied: " + (occupied ? "Yes" : "No"));
   }
   public void setOccupied(boolean occupied) {
      this.occupied = occupied;
   }
    //Method Of Student
   public void setStud(Student stud){
      this.stud.add(stud);
   }
   public ArrayList<Student> getStud(){
      return stud;
   }  
    
}

// Zeyad  Main class
   
public class Project {
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
   
        //  School
      System.out.println("Enter School Name:");
      String schoolName = in.nextLine();
      System.out.println("Enter Address:");
      String address = in.nextLine();
      System.out.println("Enter Contact Number:");
      String contactNumber = in.nextLine();
      System.out.println("Enter Medium of Study:");
      String mediumOfStudy = in.nextLine();
   
      SchoolManagement school = new SchoolManagement(schoolName, address, contactNumber, mediumOfStudy);
   
        //  Auditorium
      System.out.println("Enter number of seats in the Auditorium:");
      int totalSeats = in.nextInt();
      in.nextLine(); 
      Auditorium auditorium = new Auditorium(totalSeats);
      school.setOpen();
   
        //  Playground
      System.out.println("Enter the area of the Playground:");
      double playgroundArea = in.nextDouble();
      in.nextLine(); 
      Playground playground = new Playground(playgroundArea, "General", false);
      school.setPlay(playground);
   
        //  Classrooms
      System.out.println("How many classrooms?");
      int numberOfClassrooms = in.nextInt();
      in.nextLine();
      for (int i = 1; i <= numberOfClassrooms; i++) {
         System.out.println("Enter details for Classroom " + i);
         System.out.print("Class ID: ");
         String classId = in.nextLine();
         System.out.print("Class Name: ");
         String className = in.nextLine();
         System.out.print("Teacher ID: ");
         String teacherId = in.nextLine();
         System.out.print("Student Count: ");
         int studentCount = in.nextInt();
         in.nextLine(); 
         System.out.print("Equipment ID: ");
         String equipmentId = in.nextLine();
      
         Classroom classroom = new Classroom(classId, className, teacherId, studentCount, equipmentId);
         school.setroom(classroom);
      }
   
        //  Employees
      System.out.println("How many Teachers?");
      int teacherCount = in.nextInt();
      in.nextLine();
      for (int i = 1; i <= teacherCount; i++) {
         System.out.println("Enter details for Teacher " + i);
         System.out.print("Teacher ID: ");
         String teacherId = in.nextLine();
         System.out.print("Name: ");
         String name = in.nextLine();
         System.out.print("Salary: ");
         double salary = in.nextDouble();
         in.nextLine();
         System.out.print("Department ID: ");
         String deptId = in.nextLine();
         System.out.print("Subject: ");
         String subject = in.nextLine();
      
         Teacher teacher = new Teacher(teacherId, name, salary, deptId, subject);
         school.setDept(new Department(deptId, "General", name, new String[]{})); 
      }
   
        //   Support Staff
      System.out.println("How many Support Staff?");
      int staffCount = in.nextInt();
      in.nextLine();
      for (int i = 1; i <= staffCount; i++) {
         System.out.println("Enter details for Support Staff " + i);
         System.out.print("Staff ID: ");
         String staffId = in.nextLine();
         System.out.print("Name: ");
         String name = in.nextLine();
         System.out.print("Salary: ");
         double salary = in.nextDouble();
         in.nextLine();
         System.out.print("Department ID: ");
         String deptId = in.nextLine();
         System.out.print("Designation: ");
         String designation = in.nextLine();
      
         SupportStaff staff = new SupportStaff(staffId, name, salary, deptId, designation);
         school.setDept(new Department(deptId, "General", name, new String[]{})); 
      }
   
        //Zeyad  Menue
      boolean running = true;
      while (running) {
         System.out.println("\n--- School Management System ---");
         System.out.println("A- Manage Bus");
         System.out.println("B- Manage Students");
         System.out.println("C- Manage Employees");
         System.out.println("D- Manage Classrooms");
         System.out.println("E- Manage Notice Board");
         System.out.println("F- Manage Auditorium");
         System.out.println("G- Show School Details");
         System.out.println("H- Exit");
         System.out.print("Choose an option (A-H): ");
      
         String choice = in.nextLine().toUpperCase();
      
         switch (choice) {
            case "A":
               System.out.println("\n--- Manage Bus ---");
               System.out.println("1- Add Bus");
               System.out.println("2- Show Bus Details");
               System.out.println("3- Show Seats");
               System.out.println("4- Go Back");
               System.out.print("Choose an option: ");
               int busOption = in.nextInt();
               in.nextLine(); 
            
               {
                  switch (busOption) {
                     case 1:
                        System.out.print("Enter Bus ID: ");
                        String busId = in.nextLine();
                        System.out.print("Enter Driver ID: ");
                        String driverId = in.nextLine();
                        System.out.print("Enter Bus Number: ");
                        String busNumber = in.nextLine();
                        System.out.print("Enter Capacity: ");
                        int capacity = in.nextInt();
                        in.nextLine();
                        Bus bus = new Bus(busId, driverId, busNumber, capacity);
                        school.setBus(bus);
                        System.out.println("Bus added successfully!");
                        break;
                     case 2:
                        for (Bus b : school.getBus()) {
                           b.busDetails();
                        }
                        break;
                     case 3:
                        System.out.println("Seat details not implemented yet.");
                        break;
                     case 4:
                        System.out.println("Returning to main menu.");
                        break;
                     default:
                        System.out.println("Invalid option. Try again.");
                  }
               }
            case "B":
               System.out.println("\n--- Manage Students ---");
               System.out.println("1- Add Student");
               System.out.println("2- Show Student Details");
               System.out.println("3- Pay Fee");
               System.out.println("4- Go Back");
               System.out.print("Choose an option: ");
               int studentOption = in.nextInt();
               in.nextLine(); 
            
               {
                  switch (studentOption) {
                     case 1:
                        System.out.print("Enter Student ID: ");
                        String studentId = in.nextLine();
                        System.out.print("Enter Student Name: ");
                        String studentName = in.nextLine();
                        System.out.print("Enter Class ID: ");
                        String classId = in.nextLine();
                        System.out.print("Enter Section: ");
                        String section = in.nextLine();
                        System.out.print("Enter Bus ID: ");
                        String busId = in.nextLine();
                        System.out.print("Is this a Primary Student? (yes/no): ");
                        String isPrimary = in.nextLine();
                        if (isPrimary.equalsIgnoreCase("yes")) {
                           school.setStud(new PrimaryStudent(studentId, studentName, section, busId));
                        } else {
                           school.setStud(new HigherSecondaryStudent(studentId, studentName, section, busId));
                        }
                        System.out.println("Student added successfully!");
                        break;
                     case 2:
                        for (Student s : school.getStud()) {
                           s.StudentDetails();
                        }
                        break;
                     case 3:
                        System.out.println("Fee payment not implemented yet.");
                        break;
                     case 4:
                        System.out.println("Returning to main menu.");
                        break;
                     default:
                        System.out.println("Invalid option. Try again.");
                  }
               }
            case "C":
               System.out.println("\n--- Manage Employees ---");
               System.out.println("1- Add Employee");
               System.out.println("2- Show Employee Details");
               System.out.println("3- Receive Salary");
               System.out.println("4- Go Back");
               System.out.print("Choose an option: ");
               int employeeOption = in.nextInt();
               in.nextLine(); 
            
               {
                  switch (employeeOption) {
                     case 1:
                        System.out.println("1- Add Teacher");
                        System.out.println("2- Add Support Staff");
                        System.out.print("Choose an option: ");
                        int empType = in.nextInt();
                        in.nextLine();
                     
                        System.out.print("Enter Employee ID: ");
                        String empId = in.nextLine();
                        System.out.print("Enter Name: ");
                        String name = in.nextLine();
                        System.out.print("Enter Salary: ");
                        double salary = in.nextDouble();
                        in.nextLine();
                        System.out.print("Enter Department ID: ");
                        String deptId = in.nextLine();
                     
                        if (empType == 1) {
                           System.out.print("Enter Subject: ");
                           String subject = in.nextLine();
                           Teacher teacher = new Teacher(empId, name, salary, deptId, subject);
                           school.setDept(new Department(deptId, "General", name, new String[]{}));
                           System.out.println("Teacher added successfully!");
                        } else if (empType == 2) {
                           System.out.print("Enter Designation: ");
                           String designation = in.nextLine();
                           SupportStaff staff = new SupportStaff(empId, name, salary, deptId, designation);
                           school.setDept(new Department(deptId, "General", name, new String[]{}));
                           System.out.println("Support Staff added successfully!");
                        } else {
                           System.out.println("Invalid option. Returning to Employee Management.");
                        }
                        break;
                  
                     case 2:
                        System.out.println("--- Employee Details ---");
                        for (Department d : school.getDept()) {
                           d.DepartmentDetails();
                        }
                        break;
                  
                     case 3:
                        System.out.print("Enter Employee ID: ");
                        String id = in.nextLine();
                        System.out.println("Salary received for Employee ID: " + id);
                        break;
                  
                     case 4:
                        System.out.println("Returning to main menu.");
                        break;
                  
                     default:
                        System.out.println("Invalid option. Try again.");
                  }}
            case "D":
               System.out.println("\n--- Manage Classrooms ---");
               System.out.println("1- Add Students to Classroom");
               System.out.println("2- Assign Teacher to Classroom");
               System.out.println("3- Show Classroom Details");
               System.out.println("4- Go Back");
               System.out.print("Choose an option: ");
               int classOption = in.nextInt();
               in.nextLine(); 
            
               { 
                  switch (classOption) {
                     case 1:
                        System.out.print("Enter Classroom ID: ");
                        String classId = in.nextLine();
                        System.out.print("Enter Student ID to add: ");
                        String studentId = in.nextLine();
                        System.out.println("Added Student ID " + studentId + " to Classroom ID " + classId);
                        break;
                  
                     case 2:
                        System.out.print("Enter Classroom ID: ");
                        classId = in.nextLine();
                        System.out.print("Enter Teacher ID to assign: ");
                        String teacherId = in.nextLine();
                        System.out.println("Assigned Teacher ID " + teacherId + " to Classroom ID " + classId);
                        break;
                  
                     case 3:
                        System.out.println("--- Classroom Details ---");
                        for (Classroom room : school.getRoom()) {
                           room.ClassDetails();
                        }
                        break;
                  
                     case 4:
                        System.out.println("Returning to main menu.");
                        break;
                  
                     default:
                        System.out.println("Invalid option. Try again.");
                  }
               }  
            case "E":
               System.out.println("\n--- Manage Notice Board ---");
               System.out.println("1- Display Notices");
               System.out.println("2- Add Content to Notice Board");
               System.out.println("3- Go Back");
               System.out.print("Choose an option: ");
               int noticeOption = in.nextInt();
               in.nextLine(); 
            
               { 
                  switch (noticeOption) {
                     case 1:
                        System.out.println("--- Notice Board ---");
                        System.out.println("Displaying current notices:");
                        System.out.println("No new notices.");
                        break;
                  
                     case 2:
                        System.out.print("Enter Notice Content: ");
                        String content = in.nextLine();
                        System.out.println("Notice added: " + content);
                        break;
                  
                     case 3:
                        System.out.println("Returning to main menu.");
                        break;
                  
                     default:
                        System.out.println("Invalid option. Try again.");
                  }
               }
            case "F":
               System.out.println("\n--- Manage Auditorium ---");
               System.out.println("1- Book Auditorium");
               System.out.println("2- Show Event Details");
               System.out.println("3- Show Seats");
               System.out.println("4- Go Back");
               System.out.print("Choose an option: ");
               int auditoriumOption = in.nextInt();
               in.nextLine(); 
            
               { 
                  switch (auditoriumOption) {
                     case 1:
                        System.out.print("Enter Event Name: ");
                        String eventName = in.nextLine();
                        System.out.print("Enter Event Date: ");
                        String eventDate = in.nextLine();
                        System.out.print("Enter Event Time: ");
                        String eventTime = in.nextLine();
                        System.out.print("Enter Number of Participants: ");
                        int participants = in.nextInt();
                        in.nextLine();
                        auditorium.bookAuditorium(eventName, eventDate, eventTime, participants);
                        break;
                     case 2:
                        auditorium.eventDetails();
                        break;
                     case 3:
                        auditorium.displaySeats();
                        break;
                     case 4:
                        System.out.println("Returning to main menu.");
                        break;
                     default:
                        System.out.println("Invalid option. Try again.");
                  }
               }
            
            case "G":
               school.SchoolDetails();
               break;
            case "H":
               running = false;
               System.out.println("Exiting the program.");
               break;
            default:
               System.out.println("Invalid option. Please try again.");
         }
      }
   
      in.close();
   }
}
    
