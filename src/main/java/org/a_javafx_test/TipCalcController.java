/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.a_javafx_test;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class TipCalcController {

    private static final NumberFormat currency
            = NumberFormat.getCurrencyInstance();
    private static final NumberFormat percent
            = NumberFormat.getPercentInstance();

    private BigDecimal tipPercentage = new BigDecimal(0.15);//Default 15%

    @FXML
    private Label labelSumma;

    @FXML
    private Label labelPercent;

    @FXML
    private Label labelDricks;

    @FXML
    private Button buttonCalculate;

    @FXML
    private Label labelTotal;

    @FXML
    private TextField txtSumma;

    @FXML
    private TextField txtDricks;

    @FXML
    private TextField txtTotal;

    @FXML
    private Slider sliderPercent;

    @FXML
    void calculateButtonPressed(ActionEvent event) {

        try {
            BigDecimal amount = new BigDecimal(txtSumma.getText());
            BigDecimal tip = amount.multiply(tipPercentage);
            BigDecimal tot = amount.add(tip);

            txtDricks.setText(currency.format(tip));
            txtTotal.setText(currency.format(tot));
        } catch (NumberFormatException ex) {
            txtSumma.setText("Skriv in summa");
            txtSumma.selectAll();
            txtSumma.requestFocus();

        }
    }

    public void initialize() {
        currency.setRoundingMode(RoundingMode.HALF_UP);

        //Listener
        sliderPercent.valueProperty().addListener(
                new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov,
                    Number oldValue, Number newValue) {
                tipPercentage = BigDecimal.valueOf(newValue.intValue() / 100.0);
                labelPercent.setText(percent.format(tipPercentage));
            }
        }
        );
    }

}
