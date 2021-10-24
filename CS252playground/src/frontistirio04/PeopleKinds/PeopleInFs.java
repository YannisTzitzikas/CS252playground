package csd.uoc.gr.PeopleKinds;

public class PeopleInFs {

    private String name;
    protected double salary = 500;

    public PeopleInFs(){}

    public PeopleInFs(String name) {
        this.name = name;
    }

    /*
     * Όλες οι κλάσεις που θα κληρονομήσουν την PeopleInFs δεν θα έχουν απευθείας πρόσβαση στο
     * πεδίο name διότι είναι ιδιωτικό. Για να έχουμε πρόσβαση ακολουθούμε την αρχή της ενθυλάκωσης
     * καλώντας κάθε φορά την συνάρτηση getName() ώστε να έχουμε πρόσβαση στο πεδίο name
     */
    public String getName() {
        return name;
    }

    /*
     * Μπορούμε να θέσουμε την τιμή του name και μέσω της setName() όπου κάνουμε και τους απαραίτητους
     * ελέγχους πριν δώσουμε τιμή στη μεταβλητή. Ακολουθούμε πάλι την αρχή της ενθυλάκωσης.
     */
    public void setName(String name) {
        if(name.isEmpty())
            System.out.println("Error empty name");
        else
            this.name = name;
    }

    @Override
    public String toString() {
        return "Name " + this.name;
    }

}
