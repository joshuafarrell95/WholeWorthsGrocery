package wholeworthsgrocery;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class FXMLController implements Initializable {

    @FXML
    private Button btnCalculate;

    @FXML
    private Label labelApplicationTitle;

    @FXML
    private TextField txtBreadQty;

    @FXML
    private TextField txtBreadSubtotal;

    @FXML
    private TextField txtEggQty;

    @FXML
    private TextField txtEggSubtotal;

    @FXML
    private TextField txtMilkQty;

    @FXML
    private TextField txtMilkSubtotal;

    @FXML
    private TextField txtTotal;

    @FXML
    private void btnCalculate_onMouseClicked(MouseEvent event) {
        /* Initialize values */
        int eggQty = 0;
        int milkQty = 0;
        int breadQty = 0;
        
        double eggSubtotal = 0.0;
        double milkSubtotal = 0.0;
        double breadSubtotal = 0.0;
        
        double mainTotal = 0.0;
        
        try {
            /* Get text field values if it is not empty */
            if (!txtEggQty.getText().trim().isEmpty()) {
                eggQty = Integer.valueOf(txtEggQty.getText());
            } else {
                txtEggQty.setText("0");
            }
            
            if (!txtMilkQty.getText().trim().isEmpty()) {
                milkQty = Integer.valueOf(txtMilkQty.getText());
            } else {
                txtMilkQty.setText("0");
            }
            
            if (!txtBreadQty.getText().trim().isEmpty()) {
                breadQty = Integer.valueOf(txtBreadQty.getText());
            } else {
                txtBreadQty.setText("0");
            }
            
            /* Calculate subtotals */
            eggSubtotal = calculateItem(eggQty, "Egg");
            milkSubtotal = calculateItem(milkQty, "Milk");
            breadSubtotal = calculateItem(breadQty, "Bread");
            
            mainTotal = eggSubtotal + milkSubtotal + breadSubtotal;
            
            /* Output subtotals to text fields */
            txtEggSubtotal.setText(Double.toString(eggSubtotal));
            txtMilkSubtotal.setText(Double.toString(milkSubtotal));
            txtBreadSubtotal.setText(Double.toString(breadSubtotal));
            
            txtTotal.setText(Double.toString(mainTotal));
        }
        catch (NumberFormatException ex) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Number format exception");
			alert.setContentText("You have entered a non integer character in one or more \"Qty\" text fields, it must be removed before calculation.");
            alert.show();
        }
    }
    
    private double calculateItem(int itemQty) {
        return calculateItem(itemQty, "");
    }
    
    private double calculateItem(int itemQty, String itemName) {      
        double itemSubtotal = 0.0;
        
        switch (itemName) {
            case "Egg":
                /* Input itemQty, price each item, price per bundle, bundle amount */
                itemSubtotal = calculateSubtotalAmount(itemQty, 0.50, 5.00, 12);
                break;
            case "Milk":
                itemSubtotal = calculateSubtotalAmount(itemQty, 2.50, 7.00, 3);
                break;
            case "Bread":
                itemSubtotal = calculateSubtotalAmount(itemQty, 3.50, 6.00, 2);
                break;
            default:
                break;
        }
        
        return itemSubtotal;
    }
    
    private double calculateSubtotalAmount(int itemQty, double individualPrice, double bundlePrice, int bundleCount) {
        double itemSubtotal = 0.0;
        int bundleCheck;
        int bundleRemainder;
        bundleRemainder = itemQty;

        bundleCheck = itemQty % bundleCount;

        if (bundleCheck > 0) {
            itemSubtotal = individualPrice * bundleCheck;
            bundleRemainder = bundleRemainder - bundleCheck;
        }

        while (bundleRemainder > 0) {
            itemSubtotal = itemSubtotal + bundlePrice;
            bundleRemainder = bundleRemainder - bundleCount;
        }

        bundleRemainder = itemQty - bundleCheck;
        bundleRemainder = bundleRemainder / bundleCount;
        
        return itemSubtotal;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
}
