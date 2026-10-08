
public class Residuo implements Comparable <Residuo>{
	 private String Nombre;
     private double Peso;
     
     
	 public Residuo(String nombre, double peso) {
		Nombre = nombre;
		Peso = peso;
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


	 public double getPeso() {
		 return Peso;
	 }


	 public void setPeso(int peso) {
		 Peso = peso;
	 }


	 @Override
	 public int compareTo(Residuo o) {
		// TODO Auto-generated method stub
	 return Double.compare(this.Peso, o.Peso);
	 }
	 
	 @Override
	 public String toString() {
	     return Nombre + " - " + Peso + " kg";
	 }
}
