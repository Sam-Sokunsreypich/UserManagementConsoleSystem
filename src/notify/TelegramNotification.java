package notify;

import model.User;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class TelegramNotification {

    // Replace with your bot token from BotFather
    private static final String BOT_TOKEN = "7505598342:AAFE2BNtwKWHibAW0E58BmGx-Ogh-Sir2bI";

    // Replace with your chat ID
    private static final String CHAT_ID = "7889439927";

    // Method to send a notification
    public void sendNotification(String message) {
        try {
            // Encode the message to handle special characters
            String encodedMessage = URLEncoder.encode(message, "UTF-8");

            // Build the Telegram API URL
            String apiUrl = String.format(
                    "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s",
                    BOT_TOKEN, CHAT_ID, encodedMessage
            );

            // Debug: Print the API URL to verify correctness
//            System.out.println("API URL: " + apiUrl);

            // Open an HTTP connection
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Get the response code to check success
            int responseCode = conn.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Read and print the response from Telegram
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Print the Telegram API response
//            System.out.println("Response from Telegram: " + response);
        } catch (Exception e) {
            // Handle any errors that occur during the request
            System.out.println("Error: " + e.getMessage());
        }
    }
}
