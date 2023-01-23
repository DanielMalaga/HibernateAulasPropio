package managers;

import org.hibernate.Session;

import entidades.Aula;
import entidades.Ordenador;

public class ManagerOrdenador {

	// CRUD Create Read Update Delete

	public void createOrdenador(String marca, int anno, String tipo, Aula aula) {
		// genero la instancia a insertar.
		Ordenador ordenador = new Ordenador();
		ordenador.setMarca(marca);
		ordenador.setAnno(anno);
		ordenador.setTipo(tipo);
		ordenador.setAula(aula);

		// genero sesion
		Session session = ManagerPrincipal.sessionFactory.openSession();
		// empiezo la transaccion
		session.beginTransaction();
		// inserto la instancia
		session.persist(ordenador);
		// ejecuto contra la BD
		session.getTransaction().commit();
		// cierro la sesion
		session.close();

	}

	public Ordenador readOrdenador(long id) {

		// abro sesión
		Session session = ManagerPrincipal.sessionFactory.openSession();

		// obtengo ordenador con id como parámetro
		Ordenador ordenador = session.get(Ordenador.class, id);
		// cierro sesión
		session.close();
		// devuelvo ordenador conseguido
		return ordenador;
	}

	public void updateOrdenador(long id, String marca, int anno, String tipo) {
		// obtengo ordenador de id y modifico sus atributos
		Ordenador ordenador = readOrdenador(id);
		ordenador.setMarca(marca);
		ordenador.setAnno(anno);
		ordenador.setTipo(tipo);

		// creo la sesion
		Session session = ManagerPrincipal.sessionFactory.openSession();
		// empiezo la transacción
		session.beginTransaction();
		// actualizo la instancia
		session.merge(ordenador);
		// ejecuto contra la BD
		session.getTransaction().commit();
		// cierro la sesión
		session.close();
	}

	public void deleteOrdenador(long id) {
		// abro sesión
		Session session = ManagerPrincipal.sessionFactory.openSession();

		// preparo la transacción
		session.beginTransaction();
		// borro el ordenador obtenido con el id
		session.remove(readOrdenador(id));
		// ejecuto la acción sobre la BD
		session.getTransaction().commit();
		// cierro la sesión
		session.close();
	}
}
