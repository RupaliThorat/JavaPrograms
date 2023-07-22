using System.ComponentModel.DataAnnotations;

namespace IACSDAttMVCSQLServerApp.Models
{
    public class Student
    {
        [Key]
       public int StudId { get; set; }
        public int Roll { get; set; }
        public string FirstName { get; set; }
        public string LastName { get; set; }
        public string Email { get; set; }
        public string Password { get; set; }
        public long MobileNo { get; set; }
        public DateTime Dob { get; set; }
        public DateTime Doa { get; set; }

    }
}
