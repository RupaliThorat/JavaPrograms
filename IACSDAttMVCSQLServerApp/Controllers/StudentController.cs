using IACSDAttMVCSQLServerApp.Data;
using IACSDAttMVCSQLServerApp.Models;
using Microsoft.AspNetCore.Mvc;


namespace IACSDAttMVCSQLServerApp.Controllers
{
    public class StudentController : Controller
    {
        private readonly ApplicationDbContext _db;

        public StudentController(ApplicationDbContext db) {
            _db = db;
        }


        public IActionResult Index()
        {
            IEnumerable<Student> objStudentList = _db.students;
            return View(objStudentList);
        }
    }
}
