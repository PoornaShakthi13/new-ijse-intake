package controller;

import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import model.Student;
import util.CrudUtil;

import java.sql.SQLException;

public class StudentFormcontroller {
    public JFXTextField txtStuentName;
    public JFXTextField txtAddress;
    public JFXTextField txtContact;
    public JFXRadioButton rdoMale;
    public JFXRadioButton rdoFemale;
    public JFXButton btnStudentTable;
    public JFXButton btnDelete;
    public JFXButton btnUpdate;
    public JFXComboBox cmbStudent;
    public JFXDatePicker Date;
    public JFXButton btnAddStudent;
    public JFXTextField txtNic;
    public JFXTextField txtEmail;


    public void btnDeleteOnAction(ActionEvent actionEvent) {
        Student s=new Student(txtId.getText(), txtName.getText(), txtMail.getText(),txtContact.getText(), txtAddress.getText(),txtNic.getText());

        try{
            if(CrudUtil.execute("UPDATE student SET student_Name=?,email=?,contact=?, address=?, nic=?  WHERE student_Id=?",s.getName(), s.getMail(), s.getContact(), s.getAddress(), s.getNic(), s.getId())){
                new Alert(Alert.AlertType.CONFIRMATION, "Student Updated Successfully...!").show();
            }
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Try Again....!").show();
        }
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        Student s=new Student(txtId.getText(), txtName.getText(), txtMail.getText(),txtContact.getText(), txtAddress.getText(),txtNic.getText());

        try{
            if(CrudUtil.execute("UPDATE student SET student_Name=?,email=?,contact=?, address=?, nic=?  WHERE student_Id=?",s.getName(), s.getMail(), s.getContact(), s.getAddress(), s.getNic(), s.getId())){
                new Alert(Alert.AlertType.CONFIRMATION, "Student Updated Successfully...!").show();
            }
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Try Again....!").show();
        }
    }

    public void btnAddStudentOnAction(ActionEvent actionEvent) {
        Student student = new Student(cmbStudent.getValue(), txtStuentName.getText(), txtEmail.getText(),txtContact.getText(), txtAddress.getText(),txtNic.getText());

        try {
            if (CrudUtil.execute("INSERT INTO student VALUES (?,?,?,?,?,?)",student.getId(), student.getName(), student.getMail(), student.getContact(), student.getAddress(), student.getNic())){
                new Alert(Alert.AlertType.CONFIRMATION, "Student Saved Successfully...!");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Try Again....!");
        }
    }
}
