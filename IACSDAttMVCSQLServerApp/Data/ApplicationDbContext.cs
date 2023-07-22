using Microsoft.EntityFrameworkCore;
using IACSDAttMVCSQLServerApp.Models;


namespace IACSDAttMVCSQLServerApp.Data
{
    public class ApplicationDbContext : DbContext
    {
        public  ApplicationDbContext(DbContextOptions <ApplicationDbContext> options):base(options)
        {

        }
        DbSet<Student> students { get; set; }

    }
}
