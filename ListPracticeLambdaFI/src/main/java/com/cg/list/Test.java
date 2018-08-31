package com.cg.list;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		 int b = 1;
		while (b != 0) {

			System.out.println("Choose:");
			System.out.println("1.Add an element");
			System.out.println("2.ValueAtIndex");
			System.out.println("3.index of Value");
			System.out.println("4.Delete an Element");
			System.out.println("5.View All");
			System.out.println("6.View All the Even Values");
			System.out.println("7.Exit");
			// sc.nextLine();
			int a = sc.nextInt();
			switch (a) {
			case 1:

				int i;
				int next = 1;
				while (next != 0) {
					System.out.println("Enter integer value to add into list.....\n");
					i = sc.nextInt();
					IAdd obj = (int e) -> list.add(e);
					obj.add(i);
					System.out.println("Enter 0 stop adding, else type any number.....\n");
					next = sc.nextInt();
				}
				break;
			case 2:
				System.out.println("Enter index to find value:");
				int index = sc.nextInt();
				try {
				IGetIndex getIndex=	(int e)-> {
					System.out.println("Value at index " + e + " is:\t" + list.get(e));
				};
				getIndex.get(index);
				} catch (Exception e) {
					System.out.println("Invalid index...try later");
				}
				break;
			case 3:
				System.out.println("Enter value to find index:");
				int val = sc.nextInt();
				try {
					IGetValue getValue=	(int e)-> System.out.println("Value at index " + e + " is:\t" + list.get(e));
					getValue.get(val);
				} catch (Exception e) {
					System.out.println("Invalid value...try later");
				}
				break;
				
			case 4:
				System.out.println("Enter index to delete:");
				int rem = sc.nextInt();
			    IDelete delete=(int e) -> list.remove(e);
			    delete.delete(rem);
				break;
				
			case 5:
				System.out.println("print all the values inside list");
			    IView view = ()->{
					ListIterator<Integer> iterator = list.listIterator();
					System.out.println("inside retrieve mtd...........................");
					System.out.println("VALUES ARE :\n ");
					int count = 0;
					while (iterator.hasNext()) {
						System.out.println(count + "	:	" + iterator.next());
						count++;
					}
				};
				view.view();
				break;
				
			case 6:
				System.out.println("print all the values inside list");
				IViewEven even=()->{
					List<Integer> list1 = list.stream().filter(e -> e % 2 == 0).collect(Collectors.toList());
					ListIterator<Integer> iterator1 = list1.listIterator();
					System.out.println("EVEN VALUES ARE :\n ");
					int count = 0;
					while (iterator1.hasNext()) {
						System.out.println(count + "	:	" + iterator1.next());
						count++;
					}
				};
				even.viewEven();
				break;
			case 7:
				b = 0;
				break;
			default:
				System.out.println("Wrong Option");

			}
			
		}

		sc.close();
	}

}
