package BookBrowse;

import java.util.ArrayList;
import java.util.Scanner;
import com.google.api.services.books.v1.model.Volume;
import com.google.api.services.books.v1.model.Volumes;

public class BookBrowseUser {

	private ArrayList<Volume> readingList;
	private Scanner userInput;
	
	public BookBrowseUser() {
		readingList = new ArrayList<>();
		userInput = new Scanner(System.in);
	}

	public void addToReadingList(Volumes vols, String indices) {
		String addedIndices = "";
		int prevListLength = readingList.size();
		for(int i = 0; i < indices.length();i++) {
			for(int j = 1; j < 6; j++) {
				if(indices.substring(i, i+1).equals("" + j)) { 
					addedIndices += (j + " ");
					readingList.add(vols.getItems().get(j-1));
				}
			}
		}
		if(readingList.size() > prevListLength) {
			System.out.println("Added search results " + addedIndices + "to reading list");
			displayReadingList();
		}	
	}
	
	public String getInput() {
		String result = userInput.nextLine();
		return result;
	}
	
	public void endInput() {
		userInput.close();
	}
	
	public ArrayList<Volume> getReadingList(){
		return readingList;
	}
	
	public void displayReadingList() {
		if(!readingList.isEmpty()) {
			int i = 1;
			System.out.println("\nREADING LIST");
			for(Volume vol: readingList) {
				System.out.println(i + " ====================================================+");
				BookBrowseDriver.displayVolumeInfo(vol);
				i++;
			}	
		}
	}
}
