import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by anmol on 2/7/17.
 */
public class joystick {

    private static final int PORT=1200;


    public static void main(String[] args) throws IOException, AWTException {
        ServerSocket serverSocket=new ServerSocket(PORT);
        while(true){
            Socket socket=serverSocket.accept();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String comm=bufferedReader.readLine();
            if (comm.equals("up")){
                     Up();
            }
            else if (comm.equals("down")){

                Down();

            }
            else if (comm.contains("left")){

                left();

            }
            else if (comm.equals("right")){

                Right();

            }
            else if (comm.equals("z")){
                Z();
            }
            else if (comm.equals("x")){
                X();
            }

        }}

        public static void Up() throws AWTException {

            Robot robot=new Robot();
            robot.keyPress(38);
            robot.keyRelease(38);
            System.out.println("UP PRESS");
        }

       public static void Down() throws AWTException {

        Robot robot=new Robot();
        robot.keyPress(40);
        robot.keyRelease(40);
        System.out.println("Down PRESS");
       }

    public static void left() throws AWTException {

        Robot robot=new Robot();
        robot.keyPress(37);
        robot.keyRelease(37);
        System.out.println("Left PRESS");
    }

    public static void Right() throws AWTException {

        Robot robot=new Robot();
        robot.keyPress(39);
        robot.keyRelease(39);
        System.out.println("Right PRESS");
    }


    public static void Z() throws AWTException {

        Robot robot=new Robot();
        robot.keyPress(90);
        robot.keyRelease(90);
        System.out.println("z PRESS");
    }


    public static void X() throws AWTException {

        Robot robot=new Robot();
        robot.keyPress(88);
        robot.keyRelease(88);
        System.out.println("x PRESS");
    }


}
