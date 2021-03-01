package functionC;

import java.io.IOException;


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sound.sampled.TargetDataLine;

import functionC.Recorder_Thread;
import mainC.Main;



public class Recorder_Thread extends Thread	
{
	public TargetDataLine audio_out = null;	
	public DatagramSocket dataSock;
	byte byte_buff[] = new byte[512];
	public InetAddress server_ip;
	public int server_port;
	
	@Override
	public void run()
	{
		int i=0;
		while(true)
		{
			try 
			{
				audio_out.read(byte_buff, 0, byte_buff.length);
				DatagramPacket data = new DatagramPacket(byte_buff, byte_buff.length, server_ip, server_port);
				System.out.println("Send # " + i++);
				dataSock.send(data);
			} 
			catch (IOException ex)
			{
				Logger.getLogger(Recorder_Thread.class.getName()).log(Level.SEVERE, null, ex); 
			}
			
				if(!Main.calling)
				{
					break;
				}
			
			
		}
		audio_out.close();
		audio_out.drain();
		System.out.println("Thread stop");
	}
}