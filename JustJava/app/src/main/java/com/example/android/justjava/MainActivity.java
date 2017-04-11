/**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava;
 */
package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    int cupPrice = 5;
    int whippedCreamPrice = 1;
    int chocolatePrice = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        //Find the user's name
        EditText userNameText = (EditText) findViewById(R.id.name_text);
        String userName = userNameText.getText().toString();

        //Figure out if the user wants whipped cream topping
        CheckBox whippedCreamCheckbox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean haswhippedCream = whippedCreamCheckbox.isChecked();

        //Figure out if the user wants chocolate topping
        CheckBox chocolateCheckbox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate= chocolateCheckbox.isChecked();

        int price = calculatePrice(quantity, haswhippedCream, hasChocolate);
        String priceMessage = createOrderSummary(price, haswhippedCream, hasChocolate, userName);
        displayMessage(priceMessage);
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        if (quantity<=1){
            Toast.makeText(this, "The number of coffees can't be smaller than 1", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity -= 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        if (quantity>=100){
            Toast.makeText(this, "The number of coffees can't be higher than 100", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity += 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void resetValues(View view) {
        quantity = 0;
        displayQuantity(quantity);
        displayMessage("");
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int amount) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + amount);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    /**
     * Calculates the price of the order.
     *
     * @param quantity is the number of cups of coffee ordered
     */
    private int calculatePrice(int quantity, boolean hasWhippedCream, boolean hasChocolate) {
        int final_price=0;

        // Add price of whipped cream
        if (hasWhippedCream){
            final_price = final_price + whippedCreamPrice;
        }

        // Add price of chocolate
        if (hasChocolate){
            final_price = final_price + chocolatePrice;
        }
        final_price = quantity * (cupPrice + final_price);

        return final_price;
    }

    /**
     * Generates a summary message.
     * @param hasWhippedCream is whether or not the user wants whipped cream topping
     * @param hasChocolate is whether or not the user wants whipped cream topping
     * @param price of the order
     * @return the text summary
     */
    private String createOrderSummary(int price, boolean hasWhippedCream, boolean hasChocolate, String userName) {
        String summary = "Name: " + userName;
        summary +="\nAdd whipped cream? " + hasWhippedCream;
        summary +="\nAdd chocolate? " + hasChocolate;
        summary += "\nQuantity: " + quantity;
        summary += "\nTotal: " + price + " €";
        summary += "\nThank you!";
        return summary;
    }


}