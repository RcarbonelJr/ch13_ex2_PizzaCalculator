package murach.pizza_calculator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    // class globals
    private RadioButton smallPizza, mediumPizza, largePizza;
    private CheckBox sausage, pepperoni, salami, olives, mushrooms, anchovies;
    private TextField priceField;
        
    @Override
    public void start(Stage stage) {
        stage.setTitle("Pizza Price Calculator");
        GridPane grid = new GridPane();
        VBox appContainer = new VBox(10);
        
        // size
        Label sizeLabel = new Label("Size");
        ToggleGroup sizeGroup = new ToggleGroup();
        smallPizza = new RadioButton("Small");
        smallPizza.setToggleGroup(sizeGroup);
        mediumPizza = new RadioButton("Medium");
        mediumPizza.setToggleGroup(sizeGroup);
        largePizza = new RadioButton("Large");
        largePizza.setToggleGroup(sizeGroup);
        HBox sizeBox = new HBox(10, smallPizza, mediumPizza, largePizza);
        VBox sizeContainer = new VBox(5, sizeLabel, sizeBox);

        // toppings
        Label toppingsLabel = new Label("Select Toppings:");
        sausage = new CheckBox("Sausage");
        pepperoni = new CheckBox("Pepperoni");
        salami = new CheckBox("Salami");
        olives = new CheckBox("Olives");
        mushrooms = new CheckBox("Mushrooms");
        anchovies = new CheckBox("Anchovies");

        GridPane toppingsGrid = new GridPane();
        toppingsGrid.setHgap(10);
        toppingsGrid.setVgap(10);
        toppingsGrid.add(sausage,0, 0);
        toppingsGrid.add(pepperoni, 0, 1);
        toppingsGrid.add(salami, 0, 2);
        toppingsGrid.add(olives, 1, 0);
        toppingsGrid.add(mushrooms, 1, 1);
        toppingsGrid.add(anchovies, 1, 2);
        VBox toppingsBox = new VBox(5, toppingsLabel, toppingsGrid);

        // price output
        Label priceLabel = new Label("Price:");
        priceField = new TextField();
        priceField.setEditable(false);
        HBox priceBox = new HBox(10, priceLabel, priceField);

        // calculate button
        Button calculateButton = new Button("Calculate");
        calculateButton.setOnAction(event -> calculatePrice());

        appContainer.getChildren().addAll(sizeContainer, toppingsBox, priceBox, calculateButton);
        grid.add(appContainer, 0, 5);
        grid.setPadding(new Insets(10, 10, 0, 10));
        Scene scene = new Scene(grid, 225, 250);
        stage.setScene(scene);
        stage.show();
    }

    public void calculatePrice() {
        double price = 0.0;
        // calculation code here

        // Size price
        if (smallPizza.isSelected()) {
            price += 6.99;
        } else if (mediumPizza.isSelected()) {
            price += 8.99;
        } else if (largePizza.isSelected()) {
            price += 10.99;
        }

        // Toppings price(s)
        if (sausage.isSelected()) {
            price += 1.49;
        }
        if (pepperoni.isSelected()) {
            price += 1.49;
        }
        if (salami.isSelected()) {
            price += 1.49;
        }
        if (olives.isSelected()) {
            price += 0.99;
        }
        if (mushrooms.isSelected()) {
            price += 0.99;
        }
        if (anchovies.isSelected()) {
            price += 0.99;
        }

        // Total price
        priceField.setText(String.format("$%.2f", price));
    }

    public static void main(String[] args) {
        launch();
    }

}