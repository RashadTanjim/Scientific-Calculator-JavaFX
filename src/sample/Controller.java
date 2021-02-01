package sample;
// controller class that implements all call-able methods
import java.net.URL;
import java.util.ResourceBundle;

//FX Screen  Builder Libraries
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.lang.Math; // math library


public class Controller implements Initializable {

    Double temp = 0.0, sum = 0.0;
    boolean isOperatorPressed;
    String operatorPressed = "";

    @FXML
    TextField outputTF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        outputTF.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*([\\.]\\d*)?")) {
                    outputTF.setText(oldValue);
                }
            }
        });
    }

    @FXML
    private void onNumberClick(ActionEvent event) {    // click action listener for number type parameter
        if(event.getSource() instanceof Button) {
            Button btn = (Button)event.getSource();
            if(isOperatorPressed) {
                outputTF.setText(btn.getText().trim());
            } else {
                outputTF.setText(outputTF.getText().trim() + btn.getText().trim());
            }
            isOperatorPressed = false;
        }
    }

    @FXML
    private void onOperatorClick(ActionEvent event) {   // click action listener for operator type parameter
        if(event.getSource() instanceof Button) {
            Button btn = (Button)event.getSource();
            if (!outputTF.getText().isEmpty()) {
                temp = Double.valueOf(outputTF.getText());
                if (btn.getText().equals("%")) {
                    temp = sum * temp / 100;
                }
                switch (operatorPressed) {
                    case "/":
                        sum /= temp;
                        break;
                    case "X":
                        sum *= temp;
                        break;
                    case "+":
                        sum += temp;
                        break;
                    case "-":
                        sum -= temp;
                        break;
                    default:
                        sum = temp;
                }
            }

            if (btn.getText().equals("=") || btn.getText().equals("%")) {
                outputTF.setText(String.valueOf(sum));
                operatorPressed = "";
            }else if(btn.getText().equals("square")){   // implements all MATH library equations
                sum = temp * temp;
                outputTF.setText(String.valueOf(sum));
                operatorPressed = "";
            }else if(btn.getText().equals("sqroot")){
                sum = Math.sqrt(temp);
                outputTF.setText(String.valueOf(sum));
                operatorPressed = "";
            }else if(btn.getText().equals("sin")){
                sum = Math.sin(temp);
                outputTF.setText(String.valueOf(sum));
                operatorPressed = "";
            }else if(btn.getText().equals("cos")){
                sum = Math.cos(temp);
                outputTF.setText(String.valueOf(sum));
                operatorPressed = "";
            }else if(btn.getText().equals("tan")){
                sum = Math.tan(temp);
                outputTF.setText(String.valueOf(sum));
                operatorPressed = "";
            }else if(btn.getText().equals("mod")){
                sum = Math.abs(temp);
                outputTF.setText(String.valueOf(sum));
                operatorPressed = "";
            }else if(btn.getText().equals("1/x")){
                sum = 1/temp;
                outputTF.setText(String.valueOf(sum));
                operatorPressed = "";
            }else if(btn.getText().equals("log")){
                sum = Math.log(temp);
                outputTF.setText(String.valueOf(sum));
                operatorPressed = "";
            }else if(btn.getText().equals("exp")){
                sum = Math.exp(temp);
                outputTF.setText(String.valueOf(sum));
                operatorPressed = "";
            }else if(btn.getText().equals("radian")){
                sum = Math.toRadians(temp);
                outputTF.setText(String.valueOf(sum));
                operatorPressed = "";
            }else {
                outputTF.setText("");
                operatorPressed = btn.getText().trim();
            }
            isOperatorPressed = true;
        }
    }

    @FXML
    private void onDELClick(ActionEvent event) {
        if(outputTF.getText().length() > 0) {
            outputTF.setText(outputTF.getText(0, outputTF.getText().length() - 1));
        }
    }

    @FXML
    private void onCEClick(ActionEvent event) {
        outputTF.setText("");
        temp = 0.0;
        sum = 0.0;
        isOperatorPressed = false;
        operatorPressed = "";
    }
}
