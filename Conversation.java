
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

class Conversation {

  /**
   * Scans users input to determine if a word change needs to occur
   * @param str
   * @return T/F depending on whether there are any key words
   */
  public static boolean scan(String str){
    return str.contains("I") || str.contains("am") || str.contains("me")|| str.contains("you") || str.contains("my") || str.contains("your");
  }
  /**
   * This method replaces any key words with its counterpart, making sure each key word is not part of a bigger word (e.g. I in Idaho)
   * @param str
   * @return String containing all replaced words w/ a question mark if any words were switched
   */
  public static String changeWords(String str){
    String[] words = str.split("\\s+");

    // Create an empty string to store the mirrored sentence
    String mirroredSentence = "";

    // Iterate through each word and mirror it if necessary
    for (String word : words) {
      switch (word) {
        case "I":
          mirroredSentence += "You ";
          break;
        case "me":
          mirroredSentence += "you ";
          break;
        case "am":
          mirroredSentence += "are ";
          break;
        case "you":
          mirroredSentence += "I ";
          break;
        case "my":
          mirroredSentence += "your ";
          break;
        case "your":
          mirroredSentence += "my ";
          break;
        default:
          mirroredSentence += word + " "; // Keep the word unchanged
          break;
      }
    }

    // Trim the trailing space and return the mirrored sentence
    return mirroredSentence.trim();

    /*returnStr = returnStr.replaceAll("\\bI\\b", "You");
    returnStr = returnStr.replaceAll("\\bam\\b", "are");
    returnStr = returnStr.replaceAll("\\bme\\b", "you");
    returnStr = returnStr.replaceAll("\\byou\\b", "I");
    returnStr = returnStr.replaceAll("\\bmy\\b", "your");
    returnStr = returnStr.replaceAll("\\byour\\b", "my");
````*/
    /*if(returnStr != str){
      return returnStr + "?";
    }
    return str;*/
  }

  /**
   * main
   * @param arguments
   */
  public static void main(String[] arguments) {
    // You will start the conversation here.

  int rounds = 0;
  Random rand = new Random();
  ArrayList<String> transcript = new ArrayList<>();
  String[] responses = {"Hm...", "Cool!", "Very interesting!", "Really?", "Very Profound.."};

  System.out.println("How many rounds?");
  Scanner input = new Scanner(System.in);
  

  rounds = input.nextInt();
  System.out.println("Number of Rounds: " + rounds);


  System.out.println("Hello! Whats up?");
  transcript.add("Hello! Whats up?");

  //conversation loop
  for(int i = 0; i < rounds; i++){
    Scanner input2 = new Scanner(System.in);
    String userInput = input2.nextLine();
    transcript.add(userInput);

    if(scan(userInput)){
      if(! userInput.equals(changeWords(userInput))){
        System.out.println(changeWords(userInput) + "?");
        transcript.add(changeWords(userInput) + "?");
      }else{
        transcript.add(responses[rand.nextInt(responses.length)]);
        System.out.println(transcript.getLast());
       
      }

    }else{
      transcript.add(responses[rand.nextInt(responses.length)]);
      System.out.println(transcript.getLast());
      
    }
    


  }// end conversation loop

  System.out.println("OK, Bye!");
  transcript.add("OK, Bye!");
  System.out.println("\nTRANSCRIPT:");
  

  for(int i = 0; i<transcript.size(); i++){
    System.out.println(transcript.get(i));
  }



  }
}
