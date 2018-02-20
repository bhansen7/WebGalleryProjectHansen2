package view;

import java.util.List;
import java.util.Scanner;

import controller.ArtworkHelper;

import model.Artwork;

public class ArtworkStartProgram {

	static Scanner in = new Scanner(System.in);
	static ArtworkHelper lih = new ArtworkHelper();

	private static void addAnItem() {
		// TODO Auto-generated method stub
		System.out.print("Enter artist's name : ");
		String artistName = in.nextLine();
		System.out.print("Enter title of art: ");
		String title = in.nextLine();
		System.out.print("Enter type of media: ");
		String mediaType = in.nextLine();
		System.out.print("Enter year created: ");
		String year = in.nextLine();
		System.out.print("Enter the price of the piece of art: ");
		double value = in.nextDouble();
		in.nextLine();

		Artwork toAdd = new Artwork(title, artistName,mediaType,year, value);
		lih.insertItem(toAdd);
	}

	private static void deleteAnItem() {
		// TODO Auto-generated method stub
		System.out.print("Enter the artist name to delete: ");
		String artistName = in.nextLine();
		System.out.print("Enter the title of the art to delete: ");
		String title = in.nextLine();

		Artwork toDelete = new Artwork(title, artistName);
		lih.deleteItem(toDelete);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();

	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to our gallery list! ---");
		while (goAgain) {
			System.out.println("*  Select an item:");
			System.out.println("*  1 -- Add an item"); 
			System.out.println("*  3 -- Delete an item");
			System.out.println("*  4 -- View the list");
			System.out.println("*  5 -- Exit the awesome program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addAnItem();
			} else if (selection == 3) { 
				deleteAnItem();
			} else if (selection == 4) { 
				viewTheList();
			} else {
				// lih.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}

		}

	}

	private static void viewTheList() {
		// TODO Auto-generated method stub
		List<Artwork> allItems = lih.showAllItems();
		for (Artwork li : allItems) {
			System.out.println(li.returnItemDetails());
		}
	}

}
