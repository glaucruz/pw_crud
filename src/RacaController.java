import java.sql.SQLException;
import java.util.List;

public class RacaController {

	private RacaDao racaDao;
	
	public RacaController(){
		racaDao = new RacaDao();
	}
	
	public void cadastrarRaca(RacaBean raca) throws SQLException, ClassNotFoundException{
		racaDao.cadastrarRaca(raca);
	}
	
	public void excluirRaca(int codRaca) throws SQLException, ClassNotFoundException{
		racaDao.excluirRaca(codRaca);
	}
	
	public void alterarRaca(RacaBean raca) throws SQLException, ClassNotFoundException{
		racaDao.alterarRaca(raca);
	}
	
	public List<RacaBean> consultarRacas(String nome) throws SQLException, ClassNotFoundException{
		 return racaDao.consultarRacas(nome);
	}
	
	
	
}
