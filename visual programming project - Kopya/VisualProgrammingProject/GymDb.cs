using MySqlConnector;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Linq;
using System.Linq.Expressions;
using System.Text;
using System.Threading.Tasks;
using static System.Windows.Forms.VisualStyles.VisualStyleElement.StartPanel;

namespace VisualProgrammingProject
{
    internal class GymDb
    {
        string username;
        string password;
        string connectionUrl;a



        public GymDb()
        {
            username = "yagmur123";
            password = "123";
            MySqlConnectionStringBuilder mcb= new MySqlConnectionStringBuilder();
            mcb.Server = "127.0.0.1";
            mcb.Database = "gymreservation";
            mcb.UserID= username;
            mcb.Password= password;
            mcb.AllowUserVariables = true;
            connectionUrl = mcb.ConnectionString;
        }
        public List<Users> GetUsers()
        {
            List<Users> users = new List<Users>();
            string command = "SELECT 'ID', 'Username' , 'E mail', 'Password', 'Phone Number' FROM users ; ";

            try
            {
                MySqlConnection connection = new MySqlConnection(connectionUrl);
                connection.Open();
                MySqlCommand cmd = new MySqlCommand(command, connection);
                MySqlDataReader mdr = cmd.ExecuteReader();

                while (mdr.Read())
                {
                    Users u = new Users();
                    // ID sütununu okurken dönüşüm işlemini gerçekleştir
                    if (int.TryParse(mdr.GetString(0), out int id))
                    {
                        u.id = id;
                    }
                    else
                    {
                        // Dönüşüm hatası olduğunda uygun bir işlem yap
                        // Örneğin, varsayılan bir değer atayabilir veya hata mesajını işleyebilirsiniz
                        Console.WriteLine("Error converting ID to integer for user: " + mdr.GetString(0));
                        // Devam etmek için isteğe bağlı olarak bu kullanıcıyı atlayabilir veya işlemi durdurabilirsiniz
                        continue; // Veya break;
                    }
                    u.username = mdr.GetString(1);
                    u.email = mdr.GetString(2);
                    u.password = mdr.GetString(3);
                    u.phonenumber = mdr.GetString(4);
                    users.Add(u);
                }

            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
            return users;
        }
        public List<GymAdmin> GetGymAdmin()
        {
            List<GymAdmin> gymAdmins = new List<GymAdmin>();
            string command = "SELECT `ID`, `LECTURER`, `COURSE`, `DAY` FROM gymadmin;";

            try
            {
                MySqlConnection connection = new MySqlConnection(connectionUrl);
                connection.Open();
                MySqlCommand cmd = new MySqlCommand(command, connection);
                MySqlDataReader mdr = cmd.ExecuteReader();

                while (mdr.Read())
                {
                    GymAdmin admin = new GymAdmin();
                    admin.ID = mdr.GetInt32(0);
                    admin.LECTURER = mdr.GetString(1);
                    admin.COURSE = mdr.GetString(2);
                    admin.DAY = mdr.GetString(3);
                    gymAdmins.Add(admin);
                }
            }
            catch (Exception e)
            {
         

                Console.WriteLine(e.Message);
            }
            return gymAdmins;
        }



        public int Add(Users u, out string err_msg)
        {
            err_msg = string.Empty;
            if (u == null)
            {
                return 0;

            }
            string command = "INSERT INTO `users` (`ID`, `Username`, `E mail`, `Password`, `Phone Number`)" +
                " VALUES ( @ID ,@USERNAME, @EMAIL, @PASSWORD , @PHONENUMBER );";
           
            Console.WriteLine(command);
            int c = 0;


            try
            {
                MySqlConnection connection = new MySqlConnection(connectionUrl);
                connection.Open();
                MySqlCommand cmd = new MySqlCommand(command, connection);
                MySqlParameterCollection msp = cmd.Parameters;

                msp.AddWithValue("ID", NextId());
                msp.AddWithValue("USERNAME", u.username);
                msp.AddWithValue("EMAIL", u.email);
                msp.AddWithValue("PASSWORD", u.password);
                msp.AddWithValue("PHONENUMBER", u.phonenumber);

                c = cmd.ExecuteNonQuery();
            }


            catch (Exception e)
            {
                err_msg=e.Message;
                Console.WriteLine(e.Message);

            }

            return c;
            }

           public int Delete(Users u)
        {
            return 0;

        }
        public int Update(Users u, out string err_msg)
        {
            err_msg =string.Empty;
            if ( u == null) {  return 0; }
            string command = "UPDATE 'users'  SET 'Username'= @USERNAME , 'E mail'= @EMAIL , 'Password'= @PASSWORD, 'Phone Number'= @PHONENUMBER WHERE 'ID'= @ID;";
            int c = 0;

            try
            {
                MySqlConnection connection = new MySqlConnection(connectionUrl);
                connection.Open();
                MySqlCommand cmd = new MySqlCommand(command, connection);
                MySqlParameterCollection msp = cmd.Parameters;

                msp.AddWithValue("ID", u.id);
                msp.AddWithValue("Username", u.username);
                msp.AddWithValue("E mail", u.email);
                msp.AddWithValue("Password", u.password);
                msp.AddWithValue("Phone Number", u.phonenumber);
                c = cmd.ExecuteNonQuery();
            }
            catch (Exception e)
            {
                err_msg=e.Message;
            }

            return c;
            }
           
        protected int NextId()
        {
            string command = "SELECT MAX(CAST(id AS SIGNED)) FROM users";
            int c = 0;

            try
            {
                MySqlConnection connection = new MySqlConnection(connectionUrl);
                connection.Open();
                MySqlCommand cmd = new MySqlCommand(command, connection);
                object result = cmd.ExecuteScalar();

                if (result != null && result != DBNull.Value)
                {
                    c = Convert.ToInt32(result);
                }

                // Mevcut en yüksek ID'ye 1 ekleyerek bir sonraki ID'yi belirle
                c += 1;
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
            }

            return c;
        }

    }


      
    }


        
        
