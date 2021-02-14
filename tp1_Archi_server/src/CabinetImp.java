import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/*
 * @author EL ATILLAH Yassine - yassine.el-atillah@etu.umontpellier.fr
 * @author CHEMAOU Doha - doha.chemaou@etu.umontpellier.fr
*/

public class CabinetImp extends UnicastRemoteObject implements Cabinet {
    private ArrayList<Animal> animals = new ArrayList<Animal>();
    private ArrayList<Iclient> clients = new ArrayList<Iclient>();
	protected CabinetImp() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
    public void add(Animal a) {
    	animals.add(a);
    }
    
    public void  remove(Animal a) {
    	animals.remove(a);
    }
	@Override
	public String search(String name, String master) throws RemoteException {
		for(int i=0;i<animals.size();i++)
		{
			if( animals.get(i).getName().equals(name) && 
					animals.get(i).getMaitre().equals(master)
					) {
				return "J'ai trouver l'animale "+animals.get(i).getName() +" il est de cat�gorie "+animals.get(i).getEspece().getCategorie() ;
			}
		}
		return "J'ai pas trouver l'animal "+name;
	}
	@Override
	public void addPatient(String name,String Master, String Dossier,Espece e, String race) throws RemoteException {
		
		AnimalImp a = new AnimalImp(name,Master,new DossierSuiviImp(Dossier),e,race);
		
		this.add(a);
		System.out.println("Bienvenue a "+ name +" au Cabinet !");
		switch(this.animals.size()) {
		case 2: alert(); //Pour le test
		break;
		case 10: alert(); 
		break;
		case 500: alert();
		break;
		case 1000: alert();
		break;
		}
	}
	@Override
	public void register(Iclient client) throws RemoteException {
		this.clients.add(client);
		
	}
	
	@Override
	public void alert() throws RemoteException {
		for(Iclient c : clients) {
			c.inform(this.animals.size());
		}
		
	}
	@Override
	public void unregister(Iclient client) throws RemoteException {
		this.clients.remove(client);
		
	}
	@Override
	public void remove(String nom, String Master) throws RemoteException {
		for(Animal a:animals) {
			if(a.getMaitre().equals(Master) && a.getName().equals(nom)) this.remove(a);
		}
		
	}

	@Override
	public Animal getAnimal(String name, String master, String Race) throws RemoteException {
		for (Animal animal : animals) {
			if(animal.getName().equals(name)  && animal.getMaitre().equals(master) && animal.getRace().equals(Race))
			return animal;

		}
		return null;
	}
	

}
