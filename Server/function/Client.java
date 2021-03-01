package function;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileSystemView;

import function.Client;
import function.Method;
import message.Message;

public class Client extends Thread {

    private Socket socket;
    private String userName;
    private ObjectInputStream in;  //menyra qysh nje Pc komunikon me nje pc tjeter behet permes Streams
    private ObjectOutputStream out; //kemi dy lloje te streams: OutputStream dhe InputStream
    private ImageIcon profile;		//Pra pasi qe jemi ne Client.java me Output te dhenat shkojn prej klientit ne Server(Pcja tjeter)
    private int ID;	//Psh kur une shenoj nje mesazh "Hello",so ky mesazh dergohet ne InputStream te PCs tem
    private String time; //Me inputStream te dhenat prej serverit shkojne ne kete PC(pra Client)

    public Client(Socket socket) {
        this.socket = socket;
        execute();
    }

    private void execute() {
        this.start();
    }

    @Override
    public void run() {
        try {
            in = new ObjectInputStream(socket.getInputStream()); //pranon mesazhe
            out = new ObjectOutputStream(socket.getOutputStream()); //Te dhenat bahen flow ne Server
            ID = Method.addClient(this);
            //  loop starting get message from client
            while (true) {
                Message ms = (Message) in.readObject();//dmth lexon cfaredo mesazhi qe ka me ardh tek ne
                //in eshte streami apo soketi ku ata dergojne mesazhin qe e shtypin dhe qe ka me hy ne te
                String status = ms.getStatus();
                if (status.equals("New")) {
                    userName = ms.getName().split("!")[0];
                    time = ms.getName().split("!")[1];
                    profile = ms.getImage();
                    Method.getTxt().append("New Client name : " + userName + " has connected ...\n");
                    //  liston te gjithe shoket qe dergohen te klientat e ri te loguar
                    for (Client client : Method.getClients()) {
                        ms = new Message();
                        ms.setStatus("New");
                        ms.setID(client.getID());
                        ms.setName(client.getUserName() + "!" + client.getTime());
                        ms.setImage(client.getProfile());
                        out.writeObject(ms);
                        out.flush();
                    }
                    //  send new client to old client
                    for (Client client : Method.getClients()) {
                        if (client != this) {
                            ms = new Message();
                            ms.setStatus("New");
                            ms.setName(userName + "!" + time);
                            ms.setID(ID);
                            ms.setImage(profile);
                            client.getOut().writeObject(ms);
                            client.getOut().flush();//gjate dergimit te mesazhit,disa bytes mbesin ne buffer apo disa te dhena,
                            //dhe qe mu dergu keto te dhena duhet mi ba flush prej streamit tan,dhe mi dergu te personi tjeter
                        }
                    }
                } else if (status.equals("File")) {
                    int fileID = Method.getFileID();
                    String fileN = ms.getName();
                    SimpleDateFormat df = new SimpleDateFormat("ddMMyyyyhhmmssaa");
                    String fileName = fileID + "!" + df.format(new Date()) + "!" + ms.getName().split("!")[0];
                    Method.getTxt().append(fileName);
                    FileOutputStream output = new FileOutputStream(new File("data/" + fileName));
                    output.write(ms.getData());
                    output.close();//mbyll streamin perfundimisht
                    Method.setFileID(fileID + 1);
                    ms = new Message();
                    ms.setStatus("File");
                    ms.setName(fileID + "!" + fileN);
                    ms.setImage((ImageIcon) FileSystemView.getFileSystemView().getSystemIcon(new File("data/" + fileName)));
                    ms.setID(ID);
                    for (Client client : Method.getClients()) {
                        client.getOut().writeObject(ms);
                        client.getOut().flush();
                    }
                } else if (status.equals("download")) {
                    sendFile(ms);
                } 
                else if(status.equals("Voice"))
                {
                	// kerkesa
                	if(ms.getMessage().split("!")[1].equals("1"))
                	{
	            		for (Client client : Method.getClients()) 
	                    {
	                        if(client.getID()==Integer.parseInt(ms.getMessage().split("!")[0]))
	                        {
	                        	ms.setStatus("Voice");
	                        	// ms.getID per te ditur se kush i ka derguar kerkese per voice call
	                        	ms.setMessage("" + ms.getID() + "!" + "1");
	                        	client.getOut().writeObject(ms);
		                        client.getOut().flush();
		                        break;
	                        }
	                    }
                	}
                	// pranimi
                	else
                	{
                		String IPAddrPranues = "";
                		int portPranues = -1;
                		String IPAddrKerkues = "";
                		int portKerkues = -1;
                		for (Client client : Method.getClients()) 
	                    {
                			// pranuesi
                			if(client.getID()==ms.getID())
                			{
                				IPAddrPranues = client.getSocket().getInetAddress().getHostAddress();
                				portPranues = client.getSocket().getPort();
                				continue;
                			}
                			// kerkuesi
	                        if(client.getID()==Integer.parseInt(ms.getMessage().split("!")[0]))
	                        {
	                        	IPAddrKerkues = client.getSocket().getInetAddress().getHostAddress();
                				portKerkues = client.getSocket().getPort();
	                        }
	                    }
                		int ID = ms.getID();
                		String ID2 = ms.getMessage().split("!")[0];
                		for (Client client : Method.getClients()) 
	                    {
                			// pranuesi
                			if(client.getID()==ID)
                			{
                				ms.setStatus("Voice");
	                        	ms.setMessage("" + IPAddrKerkues + "!2!" + portKerkues);
	                        	client.getOut().writeObject(ms);
		                        client.getOut().flush();
                				continue;
                			}
                			// kerkuesi
	                        if(client.getID()==Integer.parseInt(ID2))
	                        {
	                        	ms.setStatus("Voice");
	                        	ms.setMessage("" + IPAddrPranues + "!2!" + portPranues);
	                        	client.getOut().writeObject(ms); //dergon mesazhin ne server
		                        client.getOut().flush();
	                        }
	                    }
                	}
                }
                else 
                {
                    for (Client client : Method.getClients()) 
                    {
                        client.getOut().writeObject(ms);
                        client.getOut().flush();
                    }
                }
            }

        } catch (Exception e) {
            try {
                Method.getClients().remove(this);
                Method.getTxt().append("Client Name : " + userName + " has been out of this server ...\n");
                for (Client s : Method.getClients()) {
                    Message ms = new Message();
                    ms.setStatus("Error");
                    ms.setID(ID);
                    ms.setName(userName);
                    s.getOut().writeObject(ms);
                    s.getOut().flush();
                }
            } catch (Exception e1) {
                Method.getTxt().append("Error : " + e1);
            }
        }
    }

    private void sendFile(Message ms) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String fID = ms.getMessage();
                File file = new File("data");
                for (File f : file.listFiles()) {
                    if (f.getName().startsWith(fID)) {
                        try {
                            FileInputStream ins = new FileInputStream(f);
                            byte data[] = new byte[ins.available()];
                            ins.read(data);
                            ins.close();
                            ms.setData(data);
                            ms.setStatus("GetFile"); //writeObject dergon te dhenat permes output...e krijon object dhe dergon mesazhin ne outPutStreamin tan
                            out.writeObject(ms); //out i dergon te dhenat larg prej neve dmth te dikush tjeter
                            out.flush();//ban write permbatjen e bufferit ne destinacion dhe e zbraz ate buffer per tDhana tjera qe kane mu rujt por qe nuk e mbyll ate stream perfundimisht.
                            //Kjo i bie qe ende mundesh me shenu te dhena ne stream
                            break;
                        } catch (Exception e) {
                            //  dergo error te klienti

                        }
                    }
                }
            }
        }).start();
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ObjectInputStream getIn() {
        return in;
    }

    public void setIn(ObjectInputStream in) {
        this.in = in;
    }

    public ObjectOutputStream getOut() {
        return out;
    }

    public void setOut(ObjectOutputStream out) {
        this.out = out;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public ImageIcon getProfile() {
        return profile;
    }

    public void setProfile(ImageIcon profile) {
        this.profile = profile;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

}
