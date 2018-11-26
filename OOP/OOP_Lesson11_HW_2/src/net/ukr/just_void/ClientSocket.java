package net.ukr.just_void;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSocket implements Runnable {
	private Socket socket;
	private String msg;
	private Thread thread;

	public ClientSocket(Socket socket, String msg) {
		super();
		this.socket = socket;
		this.msg = msg;
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		try (InputStream in = socket.getInputStream(); OutputStream out = socket.getOutputStream()) {
			readRequest(in);
			respond(out);
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void readRequest(InputStream in) {
		try {
			byte[] rec = new byte[in.available()];
			in.read(rec);
			for (byte b : rec) {
				System.out.print((char) (b));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void respond(OutputStream out) {
		PrintWriter pw = new PrintWriter(out);
		String response = "HTTP/1.1 200 OK\r\n" + "Server: My_Server\r\n" + "Content-Type: text/html\r\n"
				+ "Content-Length: " + "\r\n" + "Connection: close\r\n\r\n";
		pw.print(response + msg);
		pw.flush();
	}

}
