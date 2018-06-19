
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class RacaDao {
	
   public void cadastrarRaca(RacaBean raca) throws SQLException, ClassNotFoundException{
		
		
		String sql = "INSERT INTO raca VALUES (?,?)";
		
			
			PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
			comandoSql.setInt(1,0); 
			comandoSql.setString(2,raca.getNomeRaca()); 
						
			
			comandoSql.execute(); 
			Conexao.getInstance().commit(); 
	}

   
   public void alterarRaca(RacaBean raca) throws SQLException, ClassNotFoundException{
		String sql="UPDATE raca SET nomeraca=? WHERE codraca=?";
		PreparedStatement comandoSql=Conexao.getInstance().prepareStatement(sql);
		comandoSql.setString(1,raca.getNomeRaca());
		comandoSql.execute();
		Conexao.getInstance().commit();
	}
   
   public void excluirRaca(int codraca) throws SQLException, ClassNotFoundException{
		String sql="DELETE FROM raca WHERE codraca = ?";
		PreparedStatement comandoSql= Conexao.getInstance().prepareStatement(sql);
		comandoSql.setInt(1, codraca);
		comandoSql.execute();
		Conexao.getInstance().commit();
		
	}
   
   public List<RacaBean> consultarRacas(String nome) throws SQLException, ClassNotFoundException{
		List<RacaBean> listaRacas = null;
		String sql="SELECT * FROM raca WHERE nomeraca LIKE ?";
		
		PreparedStatement comandoSql= Conexao.getInstance().prepareStatement(sql);
		comandoSql.setString(1, "%" + nome + "%" );
		ResultSet rs=comandoSql.executeQuery(); 
			
		listaRacas = new ArrayList<RacaBean>();
		
		
		while(rs.next()){
			RacaBean raca = new RacaBean();
			raca.setCodRaca(rs.getInt("codraca"));
			raca.setNomeRaca(rs.getString("nomeraca"));
						
			listaRacas.add(raca);
		
		}
				
		return listaRacas;
	}


}
