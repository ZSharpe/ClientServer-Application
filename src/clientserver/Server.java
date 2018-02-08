
package clientserver;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.ExecutorService;

public class Server implements Runnable {
    
    String productFile="Record.txt";
    Socket socketThreaded;
    
    public ServerSocket startSocket(){
        
        try{
        ServerSocket ssocket = new ServerSocket(9001);
        System.out.println(ssocket);
        return ssocket;
                
        }catch(Exception e){
            System.out.println("Exception: " + e);
            return null;
        }
    }
    
    public Socket socketConnect(ServerSocket server){
        try{
            System.out.println("Waiting for connection from client....");
            Socket s = server.accept();
            System.out.println(s);
            return s;
            
            
        }catch(Exception e){
            System.out.println("Exception: " + e);
            return null;
        }
        
    }
    
    synchronized public String reader(int recordLine) throws FileNotFoundException {
        Scanner reader = new Scanner(new File(productFile));
        int index=0;
        
        while(reader.hasNext()){
            System.out.println(recordLine);
            String record = reader.nextLine();
            if (index==recordLine){
                return record;}
            index++;
        }
        
        return "EOF";
    }
    
    synchronized public int recordCount()throws FileNotFoundException{
        Scanner scan = new Scanner(new File(productFile));
        int index=0;
        while(scan.hasNext()){
            scan.nextLine();
            index++;
        }
        return index;
    }
    
    synchronized public void updateRow(int row,String data){
        try{
            
        Scanner scan = new Scanner(new File(productFile));
        FileWriter writer = new FileWriter(productFile, false);
        List<String> allRows = new ArrayList<String>();
        
        int index = 0;
        while(scan.hasNext()){
            String rec = scan.nextLine();
            allRows.add(rec);
            System.out.println("List Index: " + allRows.get(index));
        }
        scan.close();
        allRows.remove(row);
        allRows.add(row,data);
        
        for(String rowx : allRows){
            writer.write(rowx + "\r\n");
            System.out.println(rowx);
        }
        writer.close();
        
        }catch(Exception e){
            System.out.println("Update Exception! " + e);
            e.printStackTrace();

        }
    }
    
    synchronized public void listen(Socket s){
        
        try{
        ObjectInputStream input = new ObjectInputStream(s.getInputStream());
        ObjectOutputStream output = new ObjectOutputStream(s.getOutputStream());
        
        System.out.println("Welcome Check");
        output.writeObject("Welcome, we are now connected.");
        String command="";
        int recordLine=0;
        
        while(command.equals("exit")==false){
            
            System.out.println("Now listening for commands...");
            command = (String)input.readObject();
            System.out.println("Received command: " + command);
            
            
            if(command.equals("Retrieve")){
                System.out.println("Retrieved Record!");
                String record = reader(recordLine);
                System.out.println("Current row's value is: " + reader(recordLine));
                output.writeObject(record);
                output.flush();}
            else if(command.equals("Next")){
                recordLine++;
                System.out.println("Retrieved Record!");
                String record = reader(recordLine);
                if(record.equals("EOF")){
                    recordLine=0;
                    record = reader(recordLine);}
                System.out.println("Current row's value is: " + reader(recordLine));
                output.writeObject(record);
                output.flush();}
            else if(command.equals("Previous")){
                recordLine--;
                System.out.println("Retrieved Record!");
                String record = reader(recordLine);
                if(recordLine < 0){
                    recordLine = recordCount() - 1;
                    record = reader(recordLine);}
                System.out.println("Current row's value is: " + reader(recordLine));
                output.writeObject(record);
                output.flush();}
            /*
            else if(command.equals("Update")){
                System.out.println(recordLine);
                String newField = (String)input.readObject();
                updateRow(recordLine,newField);
            }*/
        }
        
        
        
        }catch(Exception e){
            System.out.println("Exception: " + e);
        }
    }
    
    
    @Override
    public void run(){
        listen(socketThreaded);
    }
    
    public static void main(String [] args){
        
        //Variable declaration for runtime.
        Server server = new Server();
        ServerSocket ss = (server.startSocket());
        
        
        //Utilization of methods for connecting server socket to client socket, and acception messages & commands.
        while(true){
           
        Socket s = server.socketConnect(ss);
        
        Server serverThreaded = new Server();
        serverThreaded.socketThreaded = s;
        
        System.out.println("This Socket Is: " + serverThreaded.socketThreaded);
        ExecutorService serv = java.util.concurrent.Executors.newCachedThreadPool();
        serv.execute(serverThreaded);
        
        
        
        }
        
    }
    
}
