package training.osms.util;

import java.io.IOException;
import java.sql.SQLException;

import org.h2.tools.Server;

public class RunDB {
	public static void main(String[] args) throws SQLException, IOException {
		Server server = Server.createTcpServer(); // Vamos usar um BD que fica
													// escutando a porta TCP
		server.start();
		System.out.println("DB On-line!");
		System.in.read(); // o processo vai ficar rodando até eu pressionar
							// enter
		server.stop();
	}
}
