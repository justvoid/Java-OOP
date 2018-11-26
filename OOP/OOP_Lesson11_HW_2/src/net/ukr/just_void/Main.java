package net.ukr.just_void;

import java.io.IOException;
import java.net.ServerSocket;

public class Main {

	public static void main(String[] args) {
		int n = 1;
		try (ServerSocket server = new ServerSocket(8083)) {
			for (;;) {
				ClientSocket cs = new ClientSocket(server.accept(), generateSystemMessage(n++));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static String generateSystemMessage(int n) {
		StringBuilder sb = new StringBuilder();
		Runtime rt = Runtime.getRuntime();
		sb.append("<html><head><title>System Information</title>");
		sb.append("<p style = \"font-size:22px\">System Information</p>");
		sb.append("<p>OS: " + System.getProperty("os.name") + "</p>");
		sb.append("<p>JRE Version: " + Runtime.version() + "</p>");
		sb.append("<p>Available Processors: " + rt.availableProcessors() + "</p>");
		sb.append("<p>Total Memory: " + rt.totalMemory() + "</p>");
		sb.append("<p>Free Memory: " + rt.freeMemory() + "</p>");
		sb.append("<p>Request #: " + n + "</p>");
		sb.append("</body></html>");
		return sb.toString();
	}

}
