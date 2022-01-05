package ls.com.webapp.jaxws.services;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import ls.com.webapp.jaxws.models.Curso;

import java.util.Arrays;
import java.util.List;

@WebService(endpointInterface = "ls.com.webapp.jaxws.services.ServicioWs")
public class ServicioWsImpl implements ServicioWs {

    private int contador;

    @WebMethod
    @Override
    public String saludar(String persona) {
        System.out.println("Imprimiendo dentro del servicio web con instancia: " + this);
        contador++;
        System.out.println("El valor del contador en el método saludar es: " + contador);
        return "Hola que tal " + persona;
    }

    @WebMethod
    @Override
    public List<Curso> listar() {
        return Arrays.asList(
                new Curso("Java"),
                new Curso("Spring"),
                new Curso("Jakarta EE")
        );
    }

    @WebMethod
    @Override
    public Curso crear(Curso curso) {
        System.out.println("Curso guardado con éxito... " + curso.getNombre());
        Curso nuevoCurso = new Curso();
        nuevoCurso.setNombre(curso.getNombre());
        return nuevoCurso;
    }
}
