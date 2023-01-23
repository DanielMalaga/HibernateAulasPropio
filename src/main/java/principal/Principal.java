package principal;

import managers.ManagerAula;
import managers.ManagerOrdenador;
import managers.ManagerPrincipal;

public class Principal {

	public static void main(String[] args) {

		ManagerPrincipal.inicioSessionFactory();

		ManagerAula managerAula = new ManagerAula();
		managerAula.createAula("Aula1", 30f);
		managerAula.createAula("Aula2", 60f);
		managerAula.createAula("Aula3", 90f);

		ManagerOrdenador managerOrdenador = new ManagerOrdenador();
		managerOrdenador.createOrdenador("HP", 2000, "Sobremesa", managerAula.readAula(1));
		managerOrdenador.createOrdenador("Lenovo", 2001, "Sobremesa", managerAula.readAula(1));
		managerOrdenador.createOrdenador("Packard Bell", 2002, "Sobremesa", managerAula.readAula(1));

		managerOrdenador.createOrdenador("HP", 2003, "Portatil", managerAula.readAula(2));
		managerOrdenador.createOrdenador("Lenovo", 2004, "Portatil", managerAula.readAula(2));
		managerOrdenador.createOrdenador("Packard Bell", 2005, "Portatil", managerAula.readAula(2));

		managerOrdenador.createOrdenador("HP", 2006, "AllinOne", managerAula.readAula(3));
		managerOrdenador.createOrdenador("Lenovo", 2007, "AllinOne", managerAula.readAula(3));
		managerOrdenador.createOrdenador("Packard Bell", 2008, "AllinOne", managerAula.readAula(3));

		ManagerPrincipal.finSessionFactory();

	}

}
