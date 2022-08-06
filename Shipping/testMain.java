package Shipping;

import java.util.ArrayList;
import java.util.Scanner;

public class testMain {

	public static void main(String[] args) {
	// READ ORDER
		//Variables
		ArrayList<Items> itemsList = new ArrayList<Items>();
		int nItems;
		String itemName;
		String itemShape;
		int ItemShapeIndex = 0;
		String[] shapes = {"cubic", "rectangular", "cylindrical", "pentagon"};

		double itemWidth = 0;
		double itemLength = 0;
		double itemHeight = 0;
		double itemWeight;
		int nOrder;
		Scanner input = new Scanner(System.in);

		// Input user
		System.out.println("How many unique items would you like to ship?\n////  ");
		nItems = input.nextInt();
		

		for (int i = 0; i < nItems; i++) {
			System.out.print("Enter the "+ (i + 1)+ "th name of your item\n////  ");
			itemName = input.next();
			boolean state = false;
			
			while (state == false) {
				System.out.print("What shape is: '"+itemName+"'?\n");
				for (int j = 0; j < shapes.length; j++) {
					System.out.println((j+1) + ") - " + shapes[j]);
				}
				System.out.println("Please select the index of the shape, for example 1 for Cubic \n////  ");
				ItemShapeIndex = input.nextInt();
				if(ItemShapeIndex >= 1 && ItemShapeIndex <= shapes.length) {
					state = true;
				}else {
					System.out.println("The integer selected is not in the range, please select again.");
				}
			} 
			
			if (ItemShapeIndex == 1) {
				itemShape = "cub";
				
				System.out.print("What width is: '"+itemName+"' in m?\n////  ");
				itemWidth = Double.parseDouble(input.next());
				
			} else if (ItemShapeIndex == 2) {
				itemShape = "rect";
				
				System.out.print("What width is: '"+itemName+"' in m?\n////  ");
				itemWidth = Double.parseDouble(input.next());

				System.out.print("What length is: '"+itemName+"' in m?\n////  ");
				itemLength = Double.parseDouble(input.next());
				
				System.out.print("What height is: '"+itemName+"' in m?\n////  ");
				itemHeight = Double.parseDouble(input.next());
				
			} else if (ItemShapeIndex == 3) {
				itemShape = "cyl";
				
				System.out.print("What width is: '"+itemName+"' in m?\n////  ");
				itemWidth = Double.parseDouble(input.next());

				System.out.print("What height is: '"+itemName+"' in m?\n////  ");
				itemHeight = Double.parseDouble(input.next());

			} else if (ItemShapeIndex == 4) {
				itemShape = "penta";

				System.out.print("What width is: '"+itemName+"' in m?\n////  ");
				itemWidth = Double.parseDouble(input.next());

				System.out.print("What height is: '"+itemName+"' in m?\n////  ");
				itemWidth = Double.parseDouble(input.next());
			} else {
				itemShape = "Wrong";
			}
			
			System.out.print("What weight is: '"+itemName+"' in kg?\n////  ");
			itemWeight = Double.parseDouble(input.next());
			
			System.out.print("How many orders of '"+itemName+"' will you ship?\n////  ");
			nOrder = input.nextInt();
			
			itemsList.add(new Items(itemName,itemShape,itemWidth,itemLength,itemHeight,itemWeight,nOrder));
			
		}
		input.close();
		
	// Compute total Volume & total Weight	
		double total_volume_shipment = 0;
		double total_weight_shipment = 0;
		
		for (Items item: itemsList) {
			System.out.println("Name: " + item.getItem_name());
			System.out.println("Shape: " + item.getShape());
			System.out.println("Width: " + item.getWidth());
			System.out.println("Length: " + item.getLength());
			System.out.println("Height: " + item.getHeight());
			System.out.println("Weight: " + item.getWeight());
			System.out.println("Nmb ordered: " + item.getN_Order());
			System.out.println("--------");
			System.out.println("Total Volume: " + item.totalVolume());
			System.out.println("Total Weight: " + item.totalWeight());
		}
		
		for (Items item: itemsList) {
			total_volume_shipment = total_volume_shipment + item.totalVolume();
			total_weight_shipment = total_weight_shipment + item.totalWeight();
		}
		
		Container container_L = new Container(12.01);
		container_L.setPrice(1800);
		Container container_S = new Container(6.06);
		container_S.setPrice(1000);
		
		double volume_container_L = container_L.calculateVolume();
		double volume_container_S = container_S.calculateVolume();
		
		compare(total_volume_shipment, total_weight_shipment, container_L, container_S);
		
		
	}
	
	
	public static void compare(double total_volume_shipment, double total_weight_shipment, Container container_L, Container container_S) {
		
		int nContainerL = (int) Math.ceil(total_volume_shipment/container_L.calculateVolume());
		int nContainerS = 0;
		
		double check = (total_volume_shipment - (nContainerL - 1) * container_L.calculateVolume());
		if (check <= container_S.calculateVolume()) {
			nContainerL = nContainerL - 1;
			nContainerS = 1;
		}
		
		if (nContainerL == 1 && nContainerS == 0) {
			nContainerS = (int)Math.ceil((total_volume_shipment / container_S.calculateVolume()));
			if (nContainerS == 1) {
				if (total_weight_shipment > 500) {
					container_S.setPrice(1200);
				}
			}
		}
		double total_cost = nContainerL * container_L.getPrice() + nContainerS * container_S.getPrice();
		System.out.println("The shipping of your order from China to Germany will cost " + total_cost + ",- EUR with "
				+ nContainerL + " big container(s) and " + (int)nContainerS + " small container(s).");

		
	}
		

}