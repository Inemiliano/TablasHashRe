import java.util.ArrayList;

public class HashTable<T> {
    private ArrayList<LinkedList<T>> multiplicationTable;
    private ArrayList<LinkedList<T>> divisionTable;
    private int size;

    public HashTable(int size) {
        this.size = size;
        this.multiplicationTable = new ArrayList<>(size);
        this.divisionTable = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            multiplicationTable.add(new LinkedList<>());
            divisionTable.add(new LinkedList<>());
        }
    }

    // Constructor con tamaño predeterminado
    public HashTable() {
        this(1000); // Tamaño por defecto
    }

    // Método de hashing utilizando multiplicación
    private int hashMultiplication(String key) {
        int hash = Math.abs(key.hashCode()); // Asegurar que el hash sea positivo
        double A = (Math.sqrt(5) - 1) / 2; // Constante A
        return (int) (size * (hash * A % 1)); // Multiplicación y modulación
    }

    // Método de hashing utilizando división
    private int hashDivision(String key) {
        int hash = Math.abs(key.hashCode()); // Asegurar que el hash sea positivo
        return hash % size; // División y módulo
    }

    // Insertar en la tabla utilizando el método de multiplicación
    public void insertMultiplication(String key, T data) {
        int index = hashMultiplication(key);
        multiplicationTable.get(index).insert(key, data);
    }

    // Insertar en la tabla utilizando el método de división
    public void insertDivision(String key, T data) {
        int index = hashDivision(key);
        divisionTable.get(index).insert(key, data);
    }

    // Buscar en la tabla utilizando el método de multiplicación
    public T searchMultiplication(String key) {
        int index = hashMultiplication(key);
        return multiplicationTable.get(index).search(key);
    }

    // Buscar en la tabla utilizando el método de división
    public T searchDivision(String key) {
        int index = hashDivision(key);
        return divisionTable.get(index).search(key);
    }
}
