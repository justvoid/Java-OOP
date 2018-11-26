package net.ukr.just_void;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSocket implements Runnable {
	private Socket socket;
	private Thread thread;
	private Group group;

	public ClientSocket(Socket socket, Group group) {
		super();
		this.socket = socket;
		this.group = group;
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		try (InputStream in = socket.getInputStream(); OutputStream out = socket.getOutputStream()) {
			String message = getInputMessage(in);
			System.out.println(message);
			switch (getLinkFromMessage(message)) {
			case "getName.html":
				sendMessage(out, group.getName());
				break;
			case "toString.html":
				sendMessage(out, group.toString());
				break;
			default:
				sendMessage(out, generateInitialMessage());
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private String getInputMessage(InputStream in) {
		try {
			byte[] input = new byte[in.available()];
			in.read(input);
			return new String(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	private String getLinkFromMessage(String msg) {
		if (msg.indexOf("Referer:") != -1) {
			int start, end;
			msg = msg.substring(msg.indexOf("Referer:"));
			start = msg.lastIndexOf("/") + 1;
			end = msg.indexOf("\n") - 1;
			if (start < end) {
				msg = msg.substring(start, end);
				return msg;
			}
		}
		return "";
	}

	private void sendMessage(OutputStream out, String text) {
		PrintWriter pw = new PrintWriter(out);
		String response = "HTTP/1.1 200 OK\r\n" + "Server: My_Server\r\n" + "Content-Type: text/html\r\n"
				+ "Content-Length: " + "\r\n" + "Connection: close\r\n\r\n";
		pw.print(response + text);
		pw.flush();
	}
	
	private String generateInitialMessage() {
		StringBuilder sb = new StringBuilder();
		sb.append("<html><head><title>" + group.getName() + "</title><meta charset='utf-8'></head><body><p>Доступные методы</p><br>");
		sb.append("<a href=\"getName.html\">getName</a><br>");
		sb.append("<a href=\"toString.html\">toString</a><br>");
		sb.append("</body></html>");
		return sb.toString();
	}
}
