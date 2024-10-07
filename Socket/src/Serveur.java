import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Serveur {
    public static void main(String[] args) throws Exception {
        /*
         * Commencer par implanter un serveur simple qui s’exécute sur le port 1600
         * reçoit une chaîne de caractère et la renvoie à au client. */
        ServerSocket socketserver;
        Socket socketduserveur ;
        BufferedReader in;
		PrintWriter out;

		try {
		
			socketserver = new ServerSocket(1600);
			socketduserveur = socketserver.accept(); 
            System.out.println("Le serveur est connecté");

            out = new PrintWriter(socketduserveur.getOutputStream());
            in = new BufferedReader (new InputStreamReader (socketduserveur.getInputStream()));

            //Réception du message
		    String message_client = in.readLine();
		    System.out.println(message_client);

            out.println("Réponse du serveur");
		    out.flush();


		    socketserver.close();
		    socketduserveur.close();

		}catch (IOException e) {
			e.printStackTrace();
		}
	
	}
    
}
