import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	//variavel que armazena a conexao
		private static Connection conexao = null;
		private String bancoDados = "Banco_pw";
		
		public Conexao() throws ClassNotFoundException, SQLException{
			//carregar o drive mysql que faz a conexao
			Class.forName("com.mysql.jdbc.Driver");
				
			//estabelece a conexao>
			//servidor:porta, banco de dados, usuario, senha
			this.conexao=DriverManager.getConnection("jdbc:derby://localhost:1527;create=true"+this.bancoDados,"admin","admin");
			conexao.setAutoCommit(false);				
			
		}
		
		/*try {
			//Aqui você também pode utilizar um caminho relativo, porém lembre-se de que esse
			//caminho inicia no mesmo diretório onde você iniciou a aplicação.
			System.setProperty("derby.system.home", "/home/usuario/derby");
			NetworkServerControlImpl networkServer = new NetworkServerControlImpl();
			networkServer.start(new PrintWriter(System.out));
			System.out.println("Conectado ao banco de dados.");
			} catch (Exception ex) {
			System.out.println("Não conseguiu conectar no banco de dados.");
			}
		
		*/
		//obtem a conexao
		public static Connection getInstance() throws ClassNotFoundException, SQLException{
			if(conexao == null){
				new Conexao(); 
			}
			return conexao; 
		}
		
	
	
}
