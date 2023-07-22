namespace HRService.DAL;
using HRService.BOL;
public class DBManager:IDBManager{
    public List<Employee> GetAll(){
        using(var context=new CollectionContext()){
            var employees=from emps in context.Employees select emps;
            return employees.ToList<Employee>();
            //tolist(), used to convert the data elements of an array into a list.            
        }
    }
}