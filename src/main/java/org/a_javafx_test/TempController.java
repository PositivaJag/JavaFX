/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.a_javafx_test;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class TempController {

    @FXML
    private Label labelTempC;

    @FXML
    private Label labelTempF;

    @FXML
    private Button buttonCalculate;

    @FXML
    private TextField txtTemp;

    @FXML
    private Label labelResultatF;

    @FXML
    void calculateButtonPressed(ActionEvent event) {

        try{
            Double tempC = Double.parseDouble(txtTemp.getText());
            Double tempF = (tempC * 1.8) + 32;
            labelResultatF.setText(tempF.toString());
            
        }
        catch (Exception e){
            txtTemp.setText("Skriv in summa");
            txtTemp.selectAll();
            txtTemp.requestFocus();
        }
            
        }
    
       @FXML
    void emptyTextTemp(MouseEvent event) {
        txtTemp.setText(" ");

    }
        
    }

