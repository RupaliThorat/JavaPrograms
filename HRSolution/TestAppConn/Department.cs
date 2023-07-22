namespace HR;

public class Department
{

    public int Id {get;set;}
    public string Name{get;set;}  //naullable type
    public string Location{get;set;}

    public Department(int id, string name, string location)
    {
        Id = id;
        Name = name;
        Location = location;
    }
    //public Department() { }
}