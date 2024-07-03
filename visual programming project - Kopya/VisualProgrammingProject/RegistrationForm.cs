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
    public partial class RegistrationForm : Form
    {
        GymDb gymdb;
        List<Users> Users;

        public RegistrationForm()
        {
            InitializeComponent();
            gymdb = new GymDb();
            Users = new List<Users>();



        }
        
        private void ClearForm()
        {
            textBoxId.Text = string.Empty;
            textBoxUsername.Text = string.Empty;
            textBoxEmail.Text = string.Empty;
            textBoxPassword.Text = string.Empty;
            textBoxPhonenumber.Text = string.Empty;
            textBoxResult.Text = string.Empty;

        }


        private void RegistrationForm_Load(object sender, EventArgs e)
        {
        }

        private void label6_Click(object sender, EventArgs e)
        {

        }

        private void label7_Click(object sender, EventArgs e)
        {

        }



        private void button1_Click(object sender, EventArgs e)
        {
          


            Users u = new Users();
           // u.id = int.Parse(textBoxId.Text);
            u.username = textBoxUsername.Text;
            u.email = textBoxEmail.Text;
            u.password = textBoxPassword.Text;
            u.phonenumber = textBoxPhonenumber.Text;


            string emsg;
            int d = gymdb.Add(u, out emsg);
            if (d > 0)
            {
                ClearForm();
                textBoxResult.Text = "Registration Succesfull";
                //LoginForm loginForm = new LoginForm();
                //loginForm.ShowDialog();
                MainForm mainForm = new MainForm();
                
                mainForm.ShowDialog();
                this.Hide();

            }
            else
            { textBoxResult.Text = emsg; }
        }

 
        }
    }

