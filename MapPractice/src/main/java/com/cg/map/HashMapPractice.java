package com.cg.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HashMapPractice {

	static HashMap<Integer, String> map = new HashMap<Integer, String>();

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int b = 1;
		while (b > 0) {
			System.out.println("--------------------------------");
			System.out.println("Choose:");
			System.out.println("1. ADD");
			System.out.println("2. GET VALUE");
			System.out.println("3. GET ALL THE KEYS");
			System.out.println("4. GET ALL THE ENTRIES");
			System.out.println("6. EXIT");

			int choose;

			choose = sc.nextInt();
			switch (choose) {
			case 1:
				int i = 1;
				while (i == 1) {
					int key = 0;
					String value = null;

					System.out.println("Enter KEY : ");
					try {
						key = sc.nextInt();
					} catch (Exception e) {
						System.out.println("Only integer key allowed,enter again");
						i = 0;
						b = 1;
						sc.nextLine();
						break;
					}
					sc.nextLine();

					System.out.println("Enter Value:");
					value = sc.nextLine();

					map.put(key, value);
					System.out.println("enter 1 to continue else enter 0 ");

					try {
						i = sc.nextInt();
					} catch (Exception e) {
						System.out.println("Invalid input, only integer value allowed, please enter again");
						i = 0;
						b = 1;
						break;
					}
					if (i != 1 && i != 0) {
						System.out.println("INVALID INPUT ! PLEASE ENTER AGAIN !!");
						i = sc.nextInt();
					}
				}
				break;
			case 2:
				int key = 0;
				System.out.println("Enter Key :");

				try {
					key = sc.nextInt();
				} catch (Exception e) {
					System.out.println("Invalid input, only integer value allowed, please enter again");
					b = 1;
					break;
				}

				String val = map.get(key);
				if (val == null) {
					System.out.println("INVALID KEY !");
				} else
					System.out.println("value:\t" + val);

				break;
			case 3:
				System.out.println("KEYS ARE :");
				Set set1 = map.entrySet();
				Iterator iterator1 = set1.iterator();
				while (iterator1.hasNext()) {
					Map.Entry map = (Map.Entry) iterator1.next();
					System.out.print(map.getKey() + "\t");
				}
				System.out.println();

				break;
			case 4:

				Set set = map.entrySet();
				Iterator iterator = set.iterator();
				System.out.println("KEY\tVALUE");
				System.out.println("-------------------------");
				while (iterator.hasNext()) {
					Map.Entry map = (Map.Entry) iterator.next();
					System.out.println(map.getKey() + "\t" + map.getValue());
				}
				break;
			case 6:
				b = 0;
				break;
			default:
				System.out.println("INVALID INPUT !");
				break;

			}
		}

	}

}
