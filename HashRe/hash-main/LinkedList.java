// LinkedList.java
public class LinkedList<T> {
    // Clase interna para el nodo de la lista
    private static class Node<T> {
        String key;
        T data;
        Node<T> next;

        Node(String key, T data) {
            this.key = key;
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head;

    // Método para insertar un nuevo nodo al principio de la lista
    public void insert(String key, T data) {
        Node<T> newNode = new Node<>(key, data);
        newNode.next = head; // El nuevo nodo apunta al anterior primer nodo
        head = newNode; // Ahora, el nuevo nodo es la cabeza de la lista
    }

    // Método para buscar un nodo por su clave
    public T search(String key) {
        Node<T> current = head;
        while (current != null) {
            if (current.key.equals(key)) {
                return current.data;
            }
            current = current.next;
        }
        return null; // Si no se encuentra, se devuelve null
    }
}
