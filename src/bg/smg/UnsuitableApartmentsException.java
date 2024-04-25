package bg.smg;

class UnsuitableApartmentsException extends Exception {
    public UnsuitableApartmentsException() {
        super("No apartments fit the desired characteristics");
    }

}