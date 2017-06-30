import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by anmol on 30/6/17.
 */
public class Server {

    private static final int PORT=9999;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(PORT);
        while(true){
            Socket socket=serverSocket.accept();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String comm=bufferedReader.readLine();
            if (comm.equals("up")){
                  IncreaseVolume();
            }
            else if (comm.equals("down")){
                DecreaseVolume();
            }
            else if (comm.contains("backLight")){
                backLight(comm);
            }
            else if (comm.equals("suspend")){
                Suspend();
            }
//            BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//            bufferedWriter.write("Done Command");
//            bufferedWriter.flush();
//            bufferedWriter.close();
        }
    }



    public static void IncreaseVolume() throws IOException {

        Runtime.getRuntime().exec("amixer -D pulse sset Master 5%+");
        System.out.println("Increasing Volume");
    }

    public static void DecreaseVolume() throws IOException {
        Runtime.getRuntime().exec("amixer -D pulse sset Master 5%-");
        System.out.println("Decrease Volume");
    }

    public static void backLight(String a) throws IOException {
        Runtime.getRuntime().exec("xbacklight ="+a.replace("backLight",""));
        System.out.println(a);
    }

    public static void Suspend() throws IOException {
        Runtime.getRuntime().exec("systemctl suspend");
        System.out.println("Suspended");
    }


}
