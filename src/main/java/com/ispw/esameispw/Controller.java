package com.ispw.esameispw;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class Controller {
    @FXML
    private Label resultLabel;
    @FXML
    private Label historyLabel;

    private double firstOperand = 0;

    private String operationToDo = "";

    private boolean start = true;
    private boolean startFromResult = false;
    private boolean positiveSign = true;

    private final Calculation calculation = new Calculation();


    @FXML
    public void insertValue(ActionEvent event){
        if(start){
            resultLabel.setText("");
            historyLabel.setText("");
            positiveSign = true;
            start = false;
        }
        startFromResult = false;
        String value=((Button)event.getSource()).getText();
        resultLabel.setText(resultLabel.getText() + value);
    }

    @FXML
    public void changeSign() {
        if(positiveSign){
            resultLabel.setText("-" + resultLabel.getText());
            positiveSign = false;
        }else {
            String substring = resultLabel.getText().substring(1);
            resultLabel.setText(substring);
            positiveSign = true;
        }
    }

    @FXML
    public void singleMemberOperation(ActionEvent event) {
        positiveSign = true;
        String value=((Button)event.getSource()).getText();
        if(!operationToDo.isEmpty())
            return;
        operationToDo = value;
        firstOperand = Float.parseFloat(resultLabel.getText());
        resultLabel.setText("");

        if(startFromResult)
            historyLabel.setText("");

        if(operationToDo.equals("x²")) {
            historyLabel.setText(historyLabel.getText() + "(" + firstOperand + ")" + "²");

        }else if(operationToDo.equals("√x")){
            historyLabel.setText(historyLabel.getText() + "√" + "(" + firstOperand + ")");

        }else {
            historyLabel.setText(historyLabel.getText() + operationToDo + "(" + firstOperand + ")");
        }

        double result = calculation.calculateSingleMemberOperations(firstOperand, operationToDo);
        if(result<0){
            positiveSign = false;
        }
        resultLabel.setText(String.valueOf(result));
        historyLabel.setText(historyLabel.getText() + "=" + result);
        operationToDo = "";
        startFromResult = true;
    }

    @FXML
    public void simpleOperation(ActionEvent event){
        positiveSign = true;
        String value=((Button)event.getSource()).getText();
        if(!value.equals("=")) {
            if(!operationToDo.isEmpty())
                return;
            operationToDo = value;
            firstOperand = Float.parseFloat(resultLabel.getText());
            if(startFromResult)
                historyLabel.setText("");
            historyLabel.setText(historyLabel.getText() + firstOperand + operationToDo );
            resultLabel.setText("");

        }else{
            if(operationToDo.isEmpty())
                return;
            double secondOperand = Float.parseFloat(resultLabel.getText());
            double result = calculation.calculateSimpleOperations(firstOperand, secondOperand, operationToDo);
            if(result<0){
                positiveSign = false;
            }
            historyLabel.setText(historyLabel.getText() + secondOperand + "=" + result);
            resultLabel.setText(String.valueOf(result));
            startFromResult = true;
            operationToDo = "";
        }
    }

    @FXML
    public void clearAll(){
        resultLabel.setText("");
        historyLabel.setText("");
        operationToDo = "";
        start = true;
        startFromResult = false;
        positiveSign = true;
    }
}