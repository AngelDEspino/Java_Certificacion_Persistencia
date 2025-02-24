package principal;

import java.util.Optional;

import model.Contacto;
import service.ContactosService;

public class OperacionesContactos {

	public static void main(String[] args) {
		ContactosService service= new ContactosService();
//		Contacto contacto = service.buscarContacto(5);
//		System.out.println("nombre: " + contacto.getNombre());
//		System.out.println("edad: " + contacto.getEdad());
//		System.out.println("email: " + contacto.getCorreo());
				
//		Contacto contacto= new Contacto(0,"juanitoJPA", "jpa@gmads.com",22);
//		service.altaContacto(contacto);
//		System.out.println("Añadido!");
		//Recuperar todos
//		List<Contacto> contactos=service.recuperarTodos();
//		contactos.forEach(c->System.out.println(c.getNombre()));
		//recuperar por email
//		Contacto contacto=service.buscarContactoEmail("email26@gmail.com");
//		if(contacto!=null) {
//			System.out.println(contacto.getNombre());
//		}else {
//			System.out.println("Contacto no exiOptional<T>;
//		}
		
//		Optional<Contacto> contacto=service.buscarContactoEmail("jpa@gmads.com");
//		contacto.ifPresentOrElse(c->System.out.println(c.getNombre()),
//								()->System.out.println("contacto no encontrado"));

		//eliminar por nombre
		service.eliminarContacto("nuevo");
	}

}
