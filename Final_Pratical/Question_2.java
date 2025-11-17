import java.sql.*;
import java.util.Scanner;

public class Question_2 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/emp";
        String user = "root";  
        String pass = "root"; 

        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, user, pass);

            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine(); 

            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Employee Salary: ");
            double salary = sc.nextDouble();

            String insertQuery = "INSERT INTO employee VALUES (?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(insertQuery);

            pst.setInt(1, id);
            pst.setString(2, name);
            pst.setDouble(3, salary);

            pst.executeUpdate();
            System.out.println("Record Inserted Successfully!\n");

            System.out.println("Employee Records:");
            String selectQuery = "SELECT * FROM employee";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(selectQuery);

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getDouble("salary")
                );
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        sc.close();
    }
}
