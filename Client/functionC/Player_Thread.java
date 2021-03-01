package functionC;

import java.io.IOException;

import functionC.Player_Thread;
import mainC.Main;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.TargetDataLine;

public class Player_Thread extends Thread
{
	public DatagramSocket din;
	public SourceDataLine audio_in;
	byte[] buffer = new byte[512];
	public int port;
	
	@Override
	public void run()
	{
		DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);
		int i = 0;
		while(true)
		{
			try
			{
				din.receive(incoming);
				buffer = incoming.getData();
				audio_in.write(buffer, 0, buffer.length);
			}
			catch(IOException ex)
			{
				Logger.getLogger(Player_Thread.class.getName()).log(Level.SEVERE, null, ex);
			}
			if(!Main.calling)
			{
				break;
			}
		}
		audio_in.close();
		audio_in.drain();
		System.out.println("Stop");
	}
}