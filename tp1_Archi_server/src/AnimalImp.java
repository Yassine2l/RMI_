import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/*
 * @author EL ATILLAH Yassine - yassine.el-atillah@etu.umontpellier.fr
 * @author CHEMAOU Doha - doha.chemaou@etu.umontpellier.fr
*/

public class AnimalImp extends UnicastRemoteObject implements Animal{
	private String name;
	private String master;
	private DossierSuivi dossier;
	Espece espece;
    String race;
	protected AnimalImp(String name, String Master, DossierSuiviImp d,Espece e , String race) throws RemoteException {
		super();
		this.name=name;
		this.master=Master;
		this.dossier=d;
		this.espece=e;
		this.race=race;
	}
    public void setName(String name)
    {
    	this.name = name;
    }
    
    public void setMaster(String master)
    {
    	this.master = master;
    }
    
	@Override
	public String getName() throws RemoteException{
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public String getMaitre() throws RemoteException{
		// TODO Auto-generated method stub
		return master;
	}
	public DossierSuivi getDossier() throws RemoteException {
		// TODO Auto-generated method stub
		return  dossier;
	}

	public void setDossier(DossierSuivi d) throws RemoteException{
		// TODO Auto-generated method stub
		this.dossier=d;
	}
	
	@Override
	public Espece getEspece() throws RemoteException {
		// TODO Auto-generated method stub
		return this.espece;
	}
	
	public void setEspece(Espece e) throws RemoteException{
		this.espece=e;
	}
	@Override
	public String getRace() throws RemoteException {
		// TODO Auto-generated method stub
		return this.race;
	}

}
