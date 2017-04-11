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
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedCreamCheckbox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean haswhippedCream = whippedCreamCheckbox.isChecked();
        int price = calculatePrice(quantity, 5, haswhippedCream);
        String priceMessage = createOrderSummary(price, haswhippedCream);
        displayMessage(priceMessage);
    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        quantity += 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        quantity -= 1;
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
    private int calculatePrice(int quantity, int cupPrice, boolean hasWhippedCream) {
        int price = quantity * cupPrice;
        return price;
    }

    /**
     * Generates a summary message.
     *
     * @param price is the total price of the coffee ordered
     * @return the text summary
     */
    private String createOrderSummary(int price, boolean hasWhippedCream) {
        String summary = "Name: Jimmy Jones";
        summary +="\nAdd whipped cream? " + hasWhippedCream;
        summary += "\nQuantity: " + quantity;
        summary += "\nTotal: " + price + " €";
        summary += "\nThank you!";
        return summary;
    }


}