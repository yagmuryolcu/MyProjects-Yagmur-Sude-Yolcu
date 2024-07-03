using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace VisualProgrammingProject
{
    public partial class LoginForm : Form
    {
        public LoginForm()
        {
            InitializeComponent();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void label1_Click_1(object sender, EventArgs e)
        {

        }

        private void label5_Click(object sender, EventArgs e)
        {

        }

        private void loginButton_Click(object sender, EventArgs e)
        {
            string username = usernameTextBox.Text;
            string password = passwordTextBox.Text;

            // Kullanıcı adı ve şifre boş olmamalı
            if (string.IsNullOrEmpty(username) || string.IsNullOrEmpty(password))
            {
                MessageBox.Show("Please enter both username and password.");
                return;
            }

            // Veritabanından kullanıcıları al
            GymDb gymDb = new GymDb();
            var users = gymDb.GetUsers();

            // Veritabanında kullanıcı yoksa
            if (users == null || users.Count == 0)
            {
                MessageBox.Show("No users found in the database.");
                return;
            }

            // Kullanıcıyı kontrol et
            var user = users.FirstOrDefault(u => u.username == username && u.password == password);

            if (user != null)
            {
                // Kullanıcı varsa ana forma yönlendir
               
                MainForm mainForm = new MainForm();
                mainForm.ShowDialog();
                this.Hide();
            }
            else
            {
                // Kullanıcı yoksa hata mesajı göster
                MessageBox.Show("Invalid username or password. Please try again or sign up.");
            }
        }
        private void signupButton_Click(object sender, EventArgs e)
        {

           
            RegistrationForm registrationForm = new RegistrationForm();
            registrationForm.ShowDialog();
            this.Hide();
        }
        private void LoginForm_Load(object sender, EventArgs e)
        {

        }
    }
}
