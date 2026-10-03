
public class Residuo implements Comparable <Residuo>{
	 private String Nombre;
     private int Peso;
     private int Tamaño;
     
     
	 public Residuo(String nombre, int peso, int tamaño) {
		Nombre = nombre;
		Peso = peso;
		Tamaño = tamaño;
	}


	 public Residuo() {
	
		// TODO Auto-generated constructor stub
	 }


	 public String getNombre() {
		 return Nombre;
	 }


	 public void setNombre(String nombre) {
		 Nombre = nombre;
	 }


	 public int getPeso() {
		 return Peso;
	 }


	 public void setPeso(int peso) {
		 Peso = peso;
	 }


	 public int getTamaño() {
		 return Tamaño;
	 }


	 public void setTamaño(int tamaño) {
		 Tamaño = tamaño;
	 }


	 @Override
	 public int compareTo(Residuo o) {
		// TODO Auto-generated method stub
		return 0;
	 }
     
}
