using Microsoft.EntityFrameworkCore;
using HRService.BOL;

namespace HRService.DAL;
public class CollectionContext:DbContext{
    public DbSet<Employee> Employees{get;set;}
    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder){
        string conString=@"server=localhost;port=3306;user=root;password=root;database=dac22";
        optionsBuilder.UseMySQL(conString);
    }
    protected override void OnModelCreating(ModelBuilder modelBuilder){
        base.OnModelCreating(modelBuilder);
        modelBuilder.Entity<Employee>(entity=>{
            entity.HasKey(e => e.emp_id);
            entity.Property(e=>e.name).IsRequired();
            entity.Property(e=>e.department).IsRequired();
            entity.Property(e=>e.work_location).IsRequired();
       
        });
        modelBuilder.Entity<Employee>().ToTable("emps");
    }
}