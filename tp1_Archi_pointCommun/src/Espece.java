import java.io.Serializable;
import java.rmi.RemoteException;

/*
 * @author EL ATILLAH Yassine - yassine.el-atillah@etu.umontpellier.fr
 * @author CHEMAOU Doha - doha.chemaou@etu.umontpellier.fr
*/

public class Espece  implements Serializable{
	
   private int age;
   private String nom;
   public Espece(String nom, int agem) throws RemoteException {
	  
	   this.age=agem;
	   this.nom=nom;
   }
   public  String getCategorie() {
	   return nom;
   }
   public String toString() {
	return nom+" leurs age moyen est "+age;
	   
   }
   
   
}
