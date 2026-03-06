package Cliente_veterinario;

public class enunciado {
/*Para practicar los conceptos de excepciones, manejo de fechas y manipulación de Strings sin entrar en la complejidad de matrices u ordenación de arrays, he diseñado el siguiente ejercicio basado en la gestión de una Clínica Veterinaria.

Ejercicio: Gestión de Citas Médicas "Mascota Feliz"
Se desea crear una aplicación para gestionar las citas de una clínica veterinaria. La clínica puede almacenar un máximo de 15 citas en un array.

Parte 1: Clase CitaMédica
Cada objeto CitaMédica debe contener:

Nombre de la mascota.

Fecha y hora de la cita (usando LocalDateTime).

Servicio solicitado (Consulta, Vacunación, Peluquería).

Código de Cita: Se genera automáticamente siguiendo este formato: Las 2 primeras letras del servicio en mayúsculas, un guion, y el día/mes de la cita.

Ejemplo: Si el servicio es "Vacunación" y la fecha es el 15 de marzo, el código será: VA-1503.

Parte 2: Lógica y Excepciones
Implementa los siguientes métodos gestionando posibles errores:

Validar Fecha: Crea un método que compruebe que la fecha de la cita no es anterior a la fecha actual del sistema. Si la fecha es pasada, debe lanzar una excepción personalizada llamada FechaInvalidaException.

Buscar por Mascota: Un método que reciba el nombre de una mascota y devuelva su posición en el array. Si la mascota no tiene ninguna cita programada, debe lanzar una MascotaNoEncontradaException.

Parte 3: Menú Principal
Crea un programa con un menú que permita:

1. Registrar Cita: * Pide el nombre de la mascota, el servicio y la fecha (puedes pedir día, mes, año y hora por separado).

Validación de String: Asegúrate de que el nombre de la mascota no esté vacío y que tenga al menos 3 caracteres.

Genera el Código de Cita automáticamente.

Controla que no se exceda la capacidad del array (máximo 15).

2. Modificar Servicio: * Pide el código de la cita (ej. VA-1503).

Busca la cita en el array. Si existe, permite cambiar el tipo de servicio.

Nota: Al cambiar el servicio, el código de la cita debe actualizarse (ej. si cambia a Peluquería, el código pasaría a ser PE-1503).

3. Cancelar Cita:

Elimina la cita del array desplazando los elementos posteriores para que no queden "huecos" nulos en medio (o gestiona el array de forma que se pueda insertar en el primer espacio libre).

4. Resumen de Citas:

Muestra por pantalla todas las citas programadas con el siguiente formato:

[CÓDIGO] Mascota: (Nombre) | Fecha: (dd/MM/yyyy) | Hora: (HH:mm)

Reto de Programación (Opcional)
Añade una opción en el menú que permita "Ver citas del mes". El usuario introduce un número de mes (1-12) y el programa debe mostrar todas las mascotas que tienen cita en ese mes específico utilizando los métodos de la clase LocalDateTime.*/
}
