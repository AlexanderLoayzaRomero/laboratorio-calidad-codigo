package com.tecsup.labs;

/**
 * Clase principal para probar el servicio de registro.
 */
public final class Main {

    /**
     * Constructor privado para evitar instanciación (Utility Class).
     */
    private Main() {
        // Constructor vacío
    }

    /**
     * Método principal de ejecución.
     *
     * @param args Argumentos de línea de comando.
     */
    public static void main(final String[] args) {
        UserRegistrationService service = new UserRegistrationService();

        // Caso 1: Contraseña muy corta
        service.registerUser("juan", "123", "juan@correo.com");
        System.out.println("Error esperado: " + service.getLastErrorMessage());

        // Caso 2: Username null
        service.registerUser(null, "12345678", "correo@test.com");
        System.out.println("Error esperado: " + service.getLastErrorMessage());

        // Caso 3: Usuario no permitido
        service.registerUser("error", "12345678", "error@correo.com");
        System.out.println("Error esperado: " + service.getLastErrorMessage());

        // Caso 4: Registro exitoso (Línea cortada para Checkstyle)
        boolean success = service.registerUser("maria", "12345678",
                "maria@correo.com");
        if (success) {
            System.out.println("¡Registro exitoso para Maria!");
        }
    }
}


