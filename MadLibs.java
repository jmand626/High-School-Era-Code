//Joban Mand
//11/19/22
//Advanced Comp Sci Period 3
//Mad Libs




import java.util.*;
import java.io.*;

public class MadLibs{

    public static void main(String[] args) throws IOException, FileNotFoundException {
        //IO and File Exception because we are using files to create objects and using scanner methods with those files.

        Scanner console = new Scanner(System.in);
        //Main scanner used for code

        System.out.println("Welcome to the game of Mad Libs" + "\n" + "I will ask you to provide various words");
        System.out.println("and phrases to fill in a story." + "\n" + "The result will be written to an output file.");

        while(true){//infinte input loop 
            System.out.println();
            System.out.print( "(C)reate mad-lib, (V)iew mad-lib, (Q)uit? ");
            //the menu
            String s = console.nextLine();
            //getting the line of input given
            System.out.println();
            mainMenu(s, console);
            //actually calling the method
        }

    }

    public static void mainMenu(String s, Scanner console) throws IOException, FileNotFoundException{//The main menu of create, view, and quit
        //IO and File Exception because we are using files to create objects and using scanner methods with those files.

        if(s.equalsIgnoreCase("Q")){
            System.exit(0);
            //Exits execution of the program and terminates any running code
        }

        else if(s.equalsIgnoreCase("C")){
            create(console);
            //leads to create method
        }
        else if(s.equalsIgnoreCase("V")){
            view(console);
            //leads to view method
        }

        else{//last case -> if this is true, this does not end the code, but rather it lets more input come in
            return;
        }
    }

    public static void create(Scanner console) throws IOException, FileNotFoundException{//Creating a mad lib
        //IO and File Exception because we are using files to create objects and using scanner methods with those files.

        System.out.print("Input file name: ");
        //Prompt
        while(true){//Infinte input loop
            String n = console.nextLine();
            //File we take the format from
            File f = new File(n);
            //making a new file object with the name we have
            //This DOES NOT create a new file. Rather, we can use the object to check if the file actually exists
            if(f.exists() && !f.isDirectory() ) { 
                //We want a file, not a directory. A directory is a set of other files
                System.out.print("Output file name: ");
                String o = console.nextLine();
                //Output file name
                System.out.println();
                getWords(console, f, o);
                break;
                //After we come back from getting the words, this method is over
            }else {
                System.out.print("File not found. Try again: ");
                //no break statement here reprompts the while loop
            }
        }
    }

    public static void getWords(Scanner console, File f, String o) throws IOException{//Middleground method
        //IO exception because we are looking at creating new objects with Files and by calling a method with this exception
        //File is already made
        FileWriter writer = new FileWriter(o);
        //setting up filewriter for the method to come
        wordReplace(console, f, writer);        

    }

    public static void wordReplace(Scanner console, File f, FileWriter writer) throws IOException, FileNotFoundException{//Replacing the words
        //IO and File Exception because we are using files to create objects and using scanner methods with those files.

        Scanner fileScan = new Scanner(f);
        //Scanning through a file: in this case, the file with the template
        String p = "";

        while(fileScan.hasNextLine()){//Every line
            String r = fileScan.nextLine();
            Scanner lineScan = new Scanner(r);
            //Scanning through each token in a line so we can keep the lines like this later

            while(lineScan.hasNext()){//Every token in a line
                String t = lineScan.next();
                if(t.charAt(0) == '<' && t.charAt(t.length()-1) == '>'){//if a token has the <>, its a template
                    t = t.replaceAll("-", " ");
                    //automatically removing the - with a space, for presentation
                    System.out.print("Please type a " + t.substring(1, t.length() - 1) + ": ");
                    //Printing out what is in the diamond operator so we can get it
                    p = console.nextLine();
                    writer.write(p + " ");
                    //Adding the response plus a space

                }else{
                    writer.write(t + " ");
                    //otherwise, we want to return the text as we found it
                }
            }

            writer.write(System.getProperty( "line.separator" ));
            //Going to next line after each line is done
        }

        writer.close();
        //We are done with the file

    }

    public static void view(Scanner console) throws FileNotFoundException{//If we just want to view the file
        //File Exception because we are creating file objects and using scanner methods with those files.

        System.out.print("Input file name: ");
        while(true){//infinte input loop
            String n = console.nextLine();
            File f = new File(n);

            if(f.exists() && !f.isDirectory() ) {//For more info, look at create method
                Scanner input = new Scanner(new File(n));
                //scanner a new file based off the same string name
                while(input.hasNextLine()){
                    System.out.println(input.nextLine());
                    //printing each line
                }
                break;
            }else{
                System.out.print("File not found. Try again: ");
            }

        }
        System.out.println();
        //for spacing and presentation
    }

}

