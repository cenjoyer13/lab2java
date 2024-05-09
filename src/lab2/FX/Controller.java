package lab2.FX;

import lab2.main.*;

import java.net.URL;
import java.text.NumberFormat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.stage.*;

public class Controller {

	double a = -0.7;
	double b = 0.3;
	double x = 2;

	final Function expression2 = Multiplication.of(X.x(),Exponential.of(Cos.of(Exponential.of(Abs.of(Sum.of(Multiplication.of(Const.of(a),X.x()), Const.of(b))), 3)), 2));
	final Function expression1 = Sum.of(Multiplication.of(Exponential.of(
			Sinh.of(X.x()),3), Const.of(b)), Multiplication.of(Const.of(-1),Abs.of(Cosh.of(Exponential.of(Sum.of(X.x(), Const.of(a)), 2.5)))));

	Function inUse;

    public RadioButton rb1;
    public RadioButton rb2;
    ToggleGroup toggleGroup;

    public Label calc;
    public Label der;
    public TextField Xin;
    public TextField start;
    public TextField fin;

    @FXML
    public void initialize() {
    	toggleGroup = new ToggleGroup();
       rb1.setToggleGroup(toggleGroup);
       rb2.setToggleGroup(toggleGroup);
       inUse=expression1;
    }

    @FXML
    public void Select(ActionEvent actionEvent) {
    	if (rb1 == toggleGroup.getSelectedToggle()) inUse=expression1;
    	else inUse=expression2;
    }

    @FXML
    public void Calculate(ActionEvent actionEvent) {
    	x = Double.parseDouble(Xin.getText());
    	calc.setText("f(" + x + "): " + inUse.calculate(x));
    }

    @FXML
    public void Derivative(ActionEvent actionEvent) {
    	x = Double.parseDouble(Xin.getText());
    	der.setText("f`(" + x + "): " + inUse.derivative().calculate(x));
    }


    public LineChart<String, Double> chart;
    @FXML
    public void createChart(ActionEvent actionEvent) {
        final XYChart.Series<String, Double> series = new XYChart.Series<>();
        series.setName(null);
        final XYChart.Series<String, Double> series1 = new XYChart.Series<>();
        series1.setName(null);
        final XYChart.Series<String, Double> series2 = new XYChart.Series<>();
        series2.setName(null);

        final int beg = Integer.parseInt(start.getText());
        final int end = Integer.parseInt(fin.getText());

        for (int i = beg*10; i < end*10; i++) {
            final double x = (double) i / 10;
            final double y = inUse.calculate(x);
            final double y1 = inUse.derivative().calculate(x);
            final double y2 = inUse.derivative().derivative().calculate(x);
            series.getData().add(new XYChart.Data<>(String.format("%.2f", x), y));
            series1.getData().add(new XYChart.Data<>(String.format("%.2f", x), y1));
            series2.getData().add(new XYChart.Data<>(String.format("%.2f", x), y2));
        }
        chart.setCreateSymbols(false); // remove all dots
        chart.getData().clear();
        chart.getData().add(series);
        chart.getData().add(series1);
        chart.getData().add(series2);
    }
}

