package com.example.calcvm;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_0;

    @FXML
    private Button btn_1;

    @FXML
    private Button btn_2;

    @FXML
    private Button btn_3;

    @FXML
    private Button btn_4;

    @FXML
    private Button btn_5;

    @FXML
    private Button btn_6;

    @FXML
    private Button btn_7;

    @FXML
    private Button btn_8;

    @FXML
    private Button btn_9;

    @FXML
    private Button btn_AC;

    @FXML
    private Button btn_change;

    @FXML
    private Button btn_coma;

    @FXML
    private Button btn_div;

    @FXML
    private Button btn_equals;

    @FXML
    private Button btn_minus;

    @FXML
    private Button btn_mult;

    @FXML
    private Button btn_percent;

    @FXML
    private Button btn_plus;

    @FXML
    private Label label_field;

    private String str_num = "";
    private float number;
    private char operation;
    private float res;

    @FXML
    void initialize() {
        btn_0.setOnAction(event -> addNumber(0));

        btn_1.setOnAction(event -> addNumber(1));

        btn_2.setOnAction(event -> addNumber(2));

        btn_3.setOnAction(event -> addNumber(3));

        btn_4.setOnAction(event -> addNumber(4));

        btn_5.setOnAction(event -> addNumber(5));

        btn_6.setOnAction(event -> addNumber(6));

        btn_7.setOnAction(event -> addNumber(7));

        btn_8.setOnAction(event -> addNumber(8));

        btn_9.setOnAction(event -> addNumber(9));

        btn_plus.setOnAction(actionEvent -> mathAct('+'));
        btn_minus.setOnAction(actionEvent -> mathAct('-'));
        btn_div.setOnAction(actionEvent -> mathAct('/'));
        btn_mult.setOnAction(actionEvent -> mathAct('*'));

        btn_equals.setOnAction(actionEvent -> equalMethod());
        btn_coma.setOnAction(actionEvent -> {
            if(!this.str_num.contains(".")){
                this.str_num+=".";
                label_field.setText(str_num);
            }
        });
        btn_percent.setOnAction(actionEvent -> {
            if(!Objects.equals(this.str_num, "")){
                float num = Float.parseFloat(this.str_num) * 0.01f;
                this.str_num = Float.toString(num);
                label_field.setText(str_num);
            }
        });

        btn_change.setOnAction(actionEvent -> {
            if(!Objects.equals(this.str_num, "")){
                float num = Float.parseFloat(this.str_num) *-1;
                this.str_num = Float.toString(num);
                label_field.setText(str_num);
            }
        });
        btn_AC.setOnAction(actionEvent -> {
            label_field.setText("0");
            this.str_num="";
            this.number=0;
            this.operation='A';
        });
    }

    void equalMethod(){
        switch (this.operation){
            case '+':
                res = this.number + Float.parseFloat(this.str_num);
                break;
            case '-':
                res = this.number - Float.parseFloat(this.str_num);
                break;
            case '*':
                res = this.number * Float.parseFloat(this.str_num);
                break;
            case '/':
                if (Integer.parseInt(this.str_num)!=0)
                    res = this.number / Float.parseFloat(this.str_num);
                else
                    res = 99999999;
                break;

        }
        label_field.setText(Float.toString(res));
        this.str_num="";
        this.operation = 'A';
        this.number= 0;
    }

    void mathAct(char operation) {
        if (this.operation != '+' && this.operation != '-' &&
                this.operation != '/' && this.operation != '*') {
            this.number = Float.parseFloat(this.str_num);
            label_field.setText(String.valueOf(operation));
            this.str_num = "";
            this.operation = operation;
        }
    }

    void addNumber(int number){
        this.str_num +=Integer.toString(number);
        label_field.setText(str_num);

    }

}
