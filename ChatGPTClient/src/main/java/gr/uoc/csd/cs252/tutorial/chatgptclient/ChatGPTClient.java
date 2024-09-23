package gr.uoc.csd.cs252.tutorial.chatgptclient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.codehaus.jettison.json.JSONObject;

/** A small client that interacts with openAI API (chatGPT). 
 *  To use it, add your personal OpenAI API usage key (from https://platform.openai.com) and execute the main method
 * 
 * @author Yannis Marketakis (marketak 'at' ics 'dot' forth 'dot' gr)
 */
public class ChatGPTClient {

    public static final String OPEN_AI_METHOD_URL="https://api.openai.com/v1/chat/completions";
    public static final String OPEN_AI_MODEL="gpt-4o-mini"; // gpt-3.5-turbo
    public static final String OPEN_AI_USAGE_KEY=""; // Put yout openAI API Key here
    
    
    /** The method asks openAI API the question provided as a parameter. 
     * The result is returned to the user in plain text format, stripped from any structural or complementary information.
     * 
     * @param text the question that openAI API will be asked for
     * @return the response from openAI API in plain text format 
     * @throws Exception if any error occurs while communicating with openAI API */
    public String askChatGPT(String text) throws Exception {
        HttpURLConnection con = (HttpURLConnection) new URL(OPEN_AI_METHOD_URL).openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Authorization", "Bearer "+OPEN_AI_USAGE_KEY);


        JSONObject data = new JSONObject();
        data.put("model", OPEN_AI_MODEL);
        data.put("messages", "[{'role': 'user', 'content': 'MyText'}]");
        data.put("temperature", 1.0);
        data.put("max_tokens", 1000);

        String body=data.toString().replace("\"[", "[").replace("]\"", "]").replace("'","\"").replace("MyText", text);
//        System.out.println(body);     
        con.setDoOutput(true);
        con.getOutputStream().write(body.getBytes());

        String output=new BufferedReader(new InputStreamReader(con.getInputStream()))
                .lines()
                .reduce((a, b) -> a + b)
                .get();
        return new JSONObject(output).getJSONArray("choices").getJSONObject(0).getJSONObject("message").getString("content");
    }

    /** Initiates an interactive session between openAI API and the user
     * 
     * @throws Exception if any error occurs while communicating with openAI API */
    public void startDialogue() throws Exception {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        String userQuestion;
        while(true) {
            System.out.println("Ask ChatGPT: ");
            userQuestion = myObj.nextLine();  // Read user input
            String answer=askChatGPT(userQuestion);
            System.out.println("Answer:");
            System.out.println(answer);
            System.out.println("--------------------------------");
        }
    }

    public static void main(String[] args) throws Exception {
        ChatGPTClient chatgpt = new ChatGPTClient();
        chatgpt.startDialogue();
    }
}