
import java.util.Scanner;
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
   * This method splits the user input string into an array. This method replaces any key words with its counterpart, making sure each key word is not part of a bigger word (e.g. I in Idaho). 
   * @param str
   * @return String containing all replaced words 
   */
  public static String changeWords(String str){
    String[] words = str.split("\\s+");
    
    String mirroredSentence = "";

    
    for (String word : words) {
      switch (word) {
        case "I":
          mirroredSentence += "you ";
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
          mirroredSentence += word + " "; 
          break;
      }
    }

    
    return mirroredSentence.trim();

    
  }

  /**
   * main contains conversation loop
   * @param arguments
   */
  public static void main(String[] arguments) {
    // You will start the conversation here.

    int rounds = 0;
    Random rand = new Random();
  

    String[] responses = {"Hm...", "Cool!", "Very interesting!", "Really?", "Very Profound.."};

    System.out.println("How many rounds?");
    Scanner input = new Scanner(System.in);
  

    rounds = input.nextInt();
    System.out.println("Number of Rounds: " + rounds);
    String[] transcript = new String[rounds* 2 + 2];
    int transcriptIndex = 0;

    System.out.println("Hello! Whats up?");
  
    transcript[transcriptIndex++] = "Hello! Whats up?";
    //conversation loop
    for(int i = 0; i < rounds; i++){
      Scanner input2 = new Scanner(System.in);
      String userInput = input2.nextLine();
      transcript[transcriptIndex++] = userInput;
    

      if(scan(userInput)){
        if(! userInput.equals(changeWords(userInput))){
          System.out.println(changeWords(userInput) + "?");
          transcript[transcriptIndex++] = changeWords(userInput) + "?";
        
        }else{
        
          transcript[transcriptIndex++] = responses[rand.nextInt(responses.length)];
        
          System.out.println(transcript[transcriptIndex-1]);
       
        }

      }else{
      
        transcript[transcriptIndex++] = responses[rand.nextInt(responses.length)];
      
        System.out.println(transcript[transcriptIndex-1]);
      
      }
    


    }// end conversation loop

    System.out.println("OK, Bye!");
  
    transcript[transcriptIndex++] = "OK, Bye!";
    System.out.println("\nTRANSCRIPT:");
  
  

    for(int i = 0; i < transcript.length; i++){
      System.out.println(transcript[i]);
    }



  }
}
