package pe.edu.unsch.infraestructura;




import pe.edu.unsch.aplicacion.MovimientoRepository;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class ArchivoMovimientoRepository
        implements MovimientoRepository {

    @Override
    public void guardar(String movimiento) {

        try (FileWriter archivo =
                     new FileWriter("movimientos.txt", true)) {

            archivo.write(
                    LocalDateTime.now() + " | " +
                            movimiento + "\n"
            );

        } catch (IOException e) {

            throw new RuntimeException(
                    "Error al guardar el movimiento", e
            );
        }
    }
}
