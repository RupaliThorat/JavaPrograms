namespace Testing;
using HR;
using MySql.Data.MySqlClient;

public class DbTestManager{

    public static string conString=@"server=localhost;port=3306;user=root; password=root;database=transflower";       
    public  static List<Department> GetAllDepartments(){
            List<Department> allDepartments=new List<Department>();
            MySqlConnection con=new MySqlConnection();
            con.ConnectionString=conString;
            try{
                con.Open();
                //fire query to database
                MySqlCommand cmd=new MySqlCommand();
                cmd.Connection=con;
                string query="SELECT * FROM departments";
                cmd.CommandText=query;
                MySqlDataReader reader=cmd.ExecuteReader();
                while(reader.Read()){
                    int id = int.Parse(reader["id"].ToString());
                    string name = reader["name"].ToString();
                    string location = reader["location"].ToString();

                    Department dept=new(id, name, location);
                /*Department{
                                                Id = id,
                                                Name = name,
                                                Location = location
                };*/
                allDepartments.Add(dept);
                }
            }
            catch(Exception ee){
                Console.WriteLine(ee.Message);
            }
            finally{
                    con.Close();
            }
        Console.WriteLine("getAll");

            return allDepartments;
    }

    public static Department GetDeparmentDetails(int id){
        Department dept = null;
        MySqlConnection con = new MySqlConnection();
        con.ConnectionString = conString;
        try
        {
            string query = "SELECT * FROM departments WHERE id=" + id;
            con.Open();
            MySqlCommand command = new MySqlCommand(query, con);
            MySqlDataReader reader = command.ExecuteReader();
            if (reader.Read())
            {
                id = int.Parse(reader["id"].ToString());
                string name = reader["name"].ToString();
                string location = reader["location"].ToString();
                /*  dept = new Department
                  {
                      Id = id,
                      Name = name,
                      Location = location
                  };*/
                dept = new Department(id,name,location); 
            }

        }
        catch (Exception e)
        {
            throw e;
        }
        finally
        {
            con.Close();
        }
        return dept;
    }

     public static bool Insert(Department dept){
        bool status=false;
        string query = "INSERT INTO departments(name,location)" +
                            "VALUES('" + dept.Name + "','" + dept.Location + "')";

        MySqlConnection con = new MySqlConnection();
        con.ConnectionString = conString;
        try{
            con.Open();
            MySqlCommand command = new MySqlCommand(query, con);
            command.ExecuteNonQuery();  //DML
            status = true;
        } 
        catch (Exception e)
        {
            throw e;
        }
        finally
        {
            con.Close();
        }               
        return status;
     }

    public static bool Update(Department dept)
    {
        bool status = false;
        MySqlConnection con = new MySqlConnection();
        con.ConnectionString = conString;
        try
        {
            string query = "UPDATE departments SET location='" + dept.Location + "', name='" + dept.Name + "' WHERE id=" + dept.Id;
            MySqlCommand command = new MySqlCommand(query, con);
            con.Open();
            command.ExecuteNonQuery();
            status = true;
        }
        catch (Exception e)
        {
            throw e;
        }
        finally
        {
            con.Close();
        }
        return status;
    }

    public static bool Delete(int id){
        bool status=false;
        MySqlConnection con = new MySqlConnection();
        con.ConnectionString = conString;
        try
        {
            string query = "DELETE FROM departments WHERE id=" + id;
            MySqlCommand command = new MySqlCommand(query, con);
            con.Open();
            command.ExecuteNonQuery();
        }
        catch (Exception e)
        {
            throw e;
        }
        finally
        {
            con.Close();
        }
      return status;
    }
}
