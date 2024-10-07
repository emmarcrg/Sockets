import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client {
	
	public static void main(String[] zero) {
        /*
         * Ecrire un client simple qui envoie une chaine de caractère au récepteur
         * qui va réagir à cette chaine en renvoyant une chaine de caractère         * 
         */
		
		Socket socket;
        BufferedReader in;
		PrintWriter out;

		try {
		
		    socket = new Socket(InetAddress.getLocalHost(),1600);
            in = new BufferedReader (new InputStreamReader (socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());

	        System.out.println("Demande de connexion");
            //Envoit du message 
		    out.println("Le client envoit un message !");
            out.flush();
            
		    
		    String message_serveur = in.readLine();
		    System.out.println(message_serveur);
		        
		    socket.close();

		}catch (UnknownHostException e) {
			
			e.printStackTrace();
		}catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}