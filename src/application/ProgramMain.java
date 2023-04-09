package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.xml.crypto.Data;
import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.Enum.OrderStatus;

public class ProgramMain {

	public static void main(String[] args) throws ParseException {
		Scanner sc= new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		System.out.println("------------System Product---------------");
		System.out.println("Enter client data:");
		System.out.print("Name:");
		sc.next();
		String name=sc.nextLine();
		
		System.out.print("Email:");
		String email=sc.nextLine();
		System.out.print("DD/MM/YYYY:");
		Date birthDate=sdf.parse(sc.next());
		
		Client client=new entities.Client(name,email,birthDate);
		
		System.out.println();
		System.out.println("Enter order data:");
		System.out.print("Status:");
		OrderStatus status= OrderStatus.valueOf(sc.next());
		
		Order order= new Order(new Date(),status,client);
		
		System.out.println();
		System.out.print("How many items to this order?");
		int n=sc.nextInt();	
		
		for(int i=1; i<=n; i++) {
			System.out.println("Enter # "+ i + " item data: ");
			System.out.print("Product name:");
			String prodName=sc.next();
			System.out.print("Product price:");
			double price=sc.nextDouble();
			
			Product product= new Product(prodName,price);
			
			System.out.print("Quantity:");
			int qtty=sc.nextInt();
			OrderItem orderItem= new OrderItem(qtty,price,product);
			order.addItem(orderItem);
			
	}
		System.out.println();
		System.out.println("ORDER SUMMARY");
		System.out.println(order);
		
		sc.close();
			
		}
	}


