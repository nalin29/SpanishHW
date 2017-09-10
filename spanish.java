import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class spanish{
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	        

	            try {
					
	            			//Takes in date to parse from downloaded webpage as a .txt
	                   String month = JOptionPane.showInputDialog("Enter Month: ", null);	//gets month
	                   String day = JOptionPane.showInputDialog("Enter Day: ", null);	// gets day
	                   month = month(month);	//translates into spanish
	                   String date = "el "+day+" de "+month;	// formats it to parse for in txt doc
	                   System.out.println(date);	//for debugging date
	                        
	           
		            ArrayList<String> txt = convert("spanish.txt"); //using convert method takes lines in txt and put into arrayList for easier parsing
		            String fullText =""; //text to be displayed at end
					for(int i=0;i<txt.size();i++) // checks through all of arrayList
					{
						if(contains(txt.get(i),date)) { //checks using contains method if string in array contains date
							System.out.println("found It");
							while(i<txt.size() && !contains(txt.get(i), "Próxima clase:")) { //checks for when the end of that day's information is 
							
								fullText +=" "+txt.get(i)+"\n"; //adds lines into string
								i++;
								}
							}
						}
					//displays found text in a scrollable popup box
					JTextArea textArea = new JTextArea(fullText);
					JScrollPane scrollPane = new JScrollPane(textArea);  
					textArea.setLineWrap(true);  
					textArea.setWrapStyleWord(true); 
					scrollPane.setPreferredSize( new Dimension( 900, 500 ) );
					JOptionPane.showMessageDialog(null, scrollPane, "Spanish Homework",  
					                                       JOptionPane.YES_NO_OPTION);
			} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println(e.getMessage());
				}
	            	

	            


	        }
	/**
	 * Takes in original(orig) string and checks if at any point the String contains the passed in String variable(var)
	 * @param orig
	 * @param var
	 * @return True/False
	 */
	public static boolean contains(String orig, String var ) {
		if(orig.length() < var.length())
			return false;
		for(int i=0;i<orig.length();i++) {
			if(i+var.length() <= orig.length() && orig.substring(i,i + var.length()).equals(var))
				return true;
		}
		return false;
	}
	/**
	 * Given a string variable for a month in english will return in spanish
	 * @param month
	 * @return Translated version in spanish
	 */
	public static String month(String month) {
		  if(month.toLowerCase().equals("january"))
      		month = "enero";
      else if(month.toLowerCase().equals("feburary"))
      		month = "febrero";
      else if(month.toLowerCase().equals("march"))
  		month = "marzo";
      else if(month.toLowerCase().equals("april"))
  		month = "abril";
      else if(month.toLowerCase().equals("may"))
  		month = "mayo";
      else if(month.toLowerCase().equals("june"))
  		month = "junio";
      else if(month.toLowerCase().equals("july"))
  		month = "julio";
      else if(month.toLowerCase().equals("august"))
  		month = "agosto";
      else if(month.toLowerCase().equals("september"))
  		month = "septiembre";
      else if(month.toLowerCase().equals("october"))
  		month = "octubre";
      else if(month.toLowerCase().equals("november"))
  		month = "noviembre";
      else if(month.toLowerCase().equals("december"))
  		month = "diciembre";
      else
    	  	month = "incorrect layout";
      return month;
	}
	/**
	 * 
	 * @param Scanner s
	 * @return ArrayList<String> of lines in text file
	 * @throws FileNotFoundException 
	 */
	public static ArrayList<String> convert(String fileName) throws FileNotFoundException{
		
	 	Scanner s = new Scanner(System.in);
        File file = new File(fileName);
        s = new Scanner(file);
        ArrayList<String> text = new ArrayList<String>();
		while(s.hasNextLine()) {
			text.add(s.nextLine());
		}
		s.close();
		return text;
	}
}

