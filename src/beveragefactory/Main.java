package beveragefactory;

/*
 * author : Mayur Yadav
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	//Ingredients Prices
	private static final HashMap<String, Double> ingredRateMap = new HashMap<String, Double>() {{
		put("milk",  1.0);
		put("sugar", 0.5);
		put("soda", 0.5);
		put("mint", 0.5);
		put("water", 0.5);
	}};

	//Menu items
	private static final List<String>menuItems = new ArrayList<String>(Arrays.asList("coffee", "chai", "bananasmoothie", "strawberryshake", "mojito"));

	//Items Rate Map
	private static final HashMap<String, Double> itemRateMap = new HashMap<String, Double>() {{
		put("coffee",  (double) 5);
		put("chai", (double) 4);
		put("bananasmoothie", (double) 6);
		put("strawberryshake", (double) 7);
		put("mojito", 7.5);
	}};

	/**
	 * validates order items 
	 * @param order in a string format
	 * returns true if order format is valid
	 */
	public static boolean validateOrder(String order) {
		if(!order.isEmpty()) {
			String orderItems[] = order.split(",");

			if(menuItems.contains(orderItems[0].toLowerCase())) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	//main method
	public static void main(String[] args) {
		String order = "chai,-sugar";
		calculateBillAmount(order);
	}

	/**
	 * Calculates the finalBill after deduction 
	 * @param order in a string format
	 * return the bill amount in Double
	 */
	public static Double calculateBillAmount(String order) {
		Double finalBill = 0.00;

		if(validateOrder(order)) {
			order = order.replace(" ", "");
			String orderItems[] = order.split(",");

			if(orderItems.length == 1) {
				finalBill = itemRateMap.get(orderItems[0].toLowerCase());
			} else {
				finalBill = itemRateMap.get(orderItems[0].toLowerCase());

				for(int i = 1; i < orderItems.length; i++) {
					String ingred = (orderItems[i].replace("-", "")).toLowerCase();

					for(Map.Entry<String, Double> menu : ingredRateMap.entrySet()) {
						if(menu.getKey().equals(ingred)) {
							finalBill -= menu.getValue();
						}
					}
				}
			}  
		}
		return finalBill;
	}
}
