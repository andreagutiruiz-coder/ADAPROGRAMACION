
<<<<<<< HEAD
public class Residuo implements Comparable<Residuo> {
	private String estudiante;
	private String Nombre;
	private double Peso;
	
	

	
	public Residuo(String estudiante, String Nombre, double Peso) {
		super();
		this.estudiante = estudiante;
		this.Nombre = Nombre;
		this.Peso = Peso;
		
	}

	

	public Residuo() {

		// TODO Auto-generated constructor stub
	}

	public String getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(String estudiante) {
		this.estudiante = estudiante;
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



	public void setPeso(double peso) {
		Peso = peso;
	}



	@Override
	public int compareTo(Residuo o) {
		// TODO Auto-generated method stub
		 return Double.compare(this.Peso, o.Peso);
	 }
	 
	 @Override
	 public String toString() {
	     return estudiante+ ""+Nombre + " - " + Peso + " kg";
	 }

=======
public class Residuo implements Comparable <Residuo>{
	private String estudiante;
	 private String Nombre;
     private double Peso;
     
   

	 public Residuo(String tipo, double peso, String nombre) {
		this.estudiante = tipo;
		Nombre = nombre;
		Peso = peso;
	}


	 public Residuo() {
	
		// TODO Auto-generated constructor stub
	 }



	 public String getEstudiante() {
		return estudiante;
	}


	 public void setEstudiante(String estudiante) {
		 this.estudiante = estudiante;
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


	 public void setPeso(double peso) {
		 Peso = peso;
	 }


	 @Override
	 public int compareTo(Residuo o) {
		// TODO Auto-generated method stub
	 return Double.compare(this.Peso, o.Peso);
	 }
	 
	 @Override
	 public String toString() {
	     return estudiante + " - " + Nombre + " - " + Peso + " kg";
	 }


	
>>>>>>> refs/remotes/origin/master
}
