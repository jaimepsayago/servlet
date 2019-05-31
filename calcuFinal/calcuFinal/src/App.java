
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leer dat1=new Leer();
		System.out.println("Ingrese la expresión aritmetica por favor ");
		String expreAr=dat1.datoStr();
		listaSimNor exArit=new listaSimNor();
		String preparado=exArit.preparaCadena(expreAr);
		exArit.llenaLista(preparado);
		//exArit.mostrar();
		boolean a=exArit.valida();//valida la operación retorna un dato booleano
		//String k=exArit.enviaKaesimo(5);//45+98+7
		//exArit.mostrar();
		String res=exArit.resolver(a);
		System.out.println(" = "+res);
		  
		 
	}

}
