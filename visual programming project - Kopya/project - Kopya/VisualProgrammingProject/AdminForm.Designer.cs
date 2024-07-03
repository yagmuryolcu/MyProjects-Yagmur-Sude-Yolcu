namespace VisualProgrammingProject
{
    partial class AdminForm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.panel1 = new System.Windows.Forms.Panel();
            this.panel2 = new System.Windows.Forms.Panel();
            this.label1 = new System.Windows.Forms.Label();
            this.insertButton = new System.Windows.Forms.Button();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.dateTimeAdmin = new System.Windows.Forms.DateTimePicker();
            this.label4 = new System.Windows.Forms.Label();
            this.textId = new System.Windows.Forms.TextBox();
            this.textCourse = new System.Windows.Forms.TextBox();
            this.textLecturer = new System.Windows.Forms.TextBox();
            this.editButton = new System.Windows.Forms.Button();
            this.cleanButton = new System.Windows.Forms.Button();
            this.exitButton = new System.Windows.Forms.Button();
            this.dataGridView1 = new System.Windows.Forms.DataGridView();
            this.panel2.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            this.SuspendLayout();
            // 
            // panel1
            // 
            this.panel1.Dock = System.Windows.Forms.DockStyle.Top;
            this.panel1.Location = new System.Drawing.Point(0, 0);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(1366, 73);
            this.panel1.TabIndex = 0;
            this.panel1.Paint += new System.Windows.Forms.PaintEventHandler(this.panel1_Paint);
            // 
            // panel2
            // 
            this.panel2.Controls.Add(this.exitButton);
            this.panel2.Controls.Add(this.cleanButton);
            this.panel2.Controls.Add(this.editButton);
            this.panel2.Controls.Add(this.textLecturer);
            this.panel2.Controls.Add(this.textCourse);
            this.panel2.Controls.Add(this.textId);
            this.panel2.Controls.Add(this.label4);
            this.panel2.Controls.Add(this.dateTimeAdmin);
            this.panel2.Controls.Add(this.label3);
            this.panel2.Controls.Add(this.label2);
            this.panel2.Controls.Add(this.insertButton);
            this.panel2.Controls.Add(this.label1);
            this.panel2.Dock = System.Windows.Forms.DockStyle.Bottom;
            this.panel2.Location = new System.Drawing.Point(0, 482);
            this.panel2.Name = "panel2";
            this.panel2.Size = new System.Drawing.Size(1366, 238);
            this.panel2.TabIndex = 1;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Yu Gothic UI", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.label1.Location = new System.Drawing.Point(86, 52);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(32, 28);
            this.label1.TabIndex = 0;
            this.label1.Text = "ID";
            // 
            // insertButton
            // 
            this.insertButton.Location = new System.Drawing.Point(880, 41);
            this.insertButton.Name = "insertButton";
            this.insertButton.Size = new System.Drawing.Size(95, 33);
            this.insertButton.TabIndex = 1;
            this.insertButton.Text = "INSERT";
            this.insertButton.UseVisualStyleBackColor = true;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Yu Gothic UI", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.label2.Location = new System.Drawing.Point(86, 112);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(86, 28);
            this.label2.TabIndex = 2;
            this.label2.Text = "Lecturer";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Yu Gothic UI", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.label3.Location = new System.Drawing.Point(482, 41);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(75, 28);
            this.label3.TabIndex = 3;
            this.label3.Text = "Course";
            this.label3.Click += new System.EventHandler(this.label3_Click);
            // 
            // dateTimeAdmin
            // 
            this.dateTimeAdmin.Location = new System.Drawing.Point(599, 121);
            this.dateTimeAdmin.Name = "dateTimeAdmin";
            this.dateTimeAdmin.Size = new System.Drawing.Size(200, 22);
            this.dateTimeAdmin.TabIndex = 4;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("Yu Gothic UI", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.label4.Location = new System.Drawing.Point(485, 121);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(50, 28);
            this.label4.TabIndex = 5;
            this.label4.Text = "DAY";
            // 
            // textId
            // 
            this.textId.Location = new System.Drawing.Point(230, 52);
            this.textId.Name = "textId";
            this.textId.Size = new System.Drawing.Size(186, 22);
            this.textId.TabIndex = 6;
            // 
            // textCourse
            // 
            this.textCourse.ForeColor = System.Drawing.Color.DarkSlateGray;
            this.textCourse.Location = new System.Drawing.Point(599, 47);
            this.textCourse.Name = "textCourse";
            this.textCourse.Size = new System.Drawing.Size(200, 22);
            this.textCourse.TabIndex = 7;
            // 
            // textLecturer
            // 
            this.textLecturer.Location = new System.Drawing.Point(230, 128);
            this.textLecturer.Name = "textLecturer";
            this.textLecturer.Size = new System.Drawing.Size(186, 22);
            this.textLecturer.TabIndex = 8;
            // 
            // editButton
            // 
            this.editButton.Location = new System.Drawing.Point(1032, 41);
            this.editButton.Name = "editButton";
            this.editButton.Size = new System.Drawing.Size(96, 33);
            this.editButton.TabIndex = 9;
            this.editButton.Text = "EDIT";
            this.editButton.UseVisualStyleBackColor = true;
            // 
            // cleanButton
            // 
            this.cleanButton.Location = new System.Drawing.Point(1197, 41);
            this.cleanButton.Name = "cleanButton";
            this.cleanButton.Size = new System.Drawing.Size(91, 33);
            this.cleanButton.TabIndex = 10;
            this.cleanButton.Text = "CLEAN";
            this.cleanButton.UseVisualStyleBackColor = true;
            // 
            // exitButton
            // 
            this.exitButton.ForeColor = System.Drawing.Color.DarkSlateGray;
            this.exitButton.Location = new System.Drawing.Point(1037, 145);
            this.exitButton.Name = "exitButton";
            this.exitButton.Size = new System.Drawing.Size(91, 34);
            this.exitButton.TabIndex = 12;
            this.exitButton.Text = "EXIT";
            this.exitButton.UseVisualStyleBackColor = true;
            // 
            // dataGridView1
            // 
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView1.Location = new System.Drawing.Point(0, 70);
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.RowHeadersWidth = 51;
            this.dataGridView1.RowTemplate.Height = 24;
            this.dataGridView1.Size = new System.Drawing.Size(1366, 415);
            this.dataGridView1.TabIndex = 2;
            // 
            // AdminForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.SlateGray;
            this.ClientSize = new System.Drawing.Size(1366, 720);
            this.Controls.Add(this.dataGridView1);
            this.Controls.Add(this.panel2);
            this.Controls.Add(this.panel1);
            this.Name = "AdminForm";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "AdminForm";
            this.WindowState = System.Windows.Forms.FormWindowState.Maximized;
            this.panel2.ResumeLayout(false);
            this.panel2.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.Panel panel2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Button insertButton;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.DateTimePicker dateTimeAdmin;
        private System.Windows.Forms.Button exitButton;
        private System.Windows.Forms.Button cleanButton;
        private System.Windows.Forms.Button editButton;
        private System.Windows.Forms.TextBox textLecturer;
        private System.Windows.Forms.TextBox textCourse;
        private System.Windows.Forms.TextBox textId;
        private System.Windows.Forms.DataGridView dataGridView1;
    }
}