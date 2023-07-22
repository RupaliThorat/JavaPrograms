using Testing;
using HR;
Department d = new Department(3, "PROD", "Mumbai");
DbTestManager.Insert(d);
List<Department> departments=DbTestManager.GetAllDepartments();
foreach ( Department dept in departments){
    Console.WriteLine(dept.Name + "  " + dept.Location);
}
 d= DbTestManager.GetDeparmentDetails(1);
Console.WriteLine(d.Name + "  " + d.Location);
//d = new Department(2, "MRKT", "Mumbai");
//DbTestManager.Insert(d);
//Database Operations unit Testing

