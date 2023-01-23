package managers;

import org.hibernate.Session;

import entidades.Aula;

public class ManagerAula {

	// CRUD Create Read Update Delete

	public void createAula(String nombre, Float metros) {
		Aula aula = new Aula();
		aula.setTituloAula(nombre);
		aula.setMetros(metros);

		// abro la sesion para interactuar con la BD
		Session session = ManagerPrincipal.sessionFactory.openSession();
		// empiezo la transacción a través de la sesion
		session.beginTransaction();

		// guardo la instancia grabada en aula
		session.persist(aula);
		// ejecuto lo guardado, ahora si se guarda en la BD
		session.getTransaction().commit();

		// cierro la sesion al terminar de interactuar con la BD
		session.close();
	}

	public Aula readAula(long id) {

		// abro la sesion
		Session session = ManagerPrincipal.sessionFactory.openSession();

		// obtengo la instancia de la clase Aula con el id dado
		Aula aula = session.get(Aula.class, id);

		// cierro la sesion
		session.close();

		return aula;
	}

	public void updateAula(long id, String nombre, Float metros) {

		// guardo en aula la instancia de la BD obtenida con id
		Aula aula = readAula(id);
		// modifico metros y titulo segun parametros pasados
		aula.setMetros(metros);
		aula.setTituloAula(nombre);

		// genero la sesion
		Session session = ManagerPrincipal.sessionFactory.openSession();
		session.beginTransaction();
		// guardo la nueva instancia aula, id dado y nombre y metros introducidos
		session.merge(aula);
		// hago commit para hacer efectivos los cambios
		session.getTransaction().commit();
		// cierro la sesion
		session.close();

	}

	public void deleteAula(long id) {
		Aula aula = readAula(id);

		// abro sesion
		Session session = ManagerPrincipal.sessionFactory.openSession();
		// comienzo la transaccion a traves de la sesion abierta
		session.beginTransaction();
		// ejecuto el borrado
		session.remove(aula);
		// hago efectivo el borrado
		session.getTransaction().commit();
		// cierro sesion
		session.close();
	}
}
