package frontistirio04.PeopleKinds;

public class PeopleInFs {

    private String name;
    protected double salary = 500;

    public PeopleInFs(){}

    public PeopleInFs(String name) {
        this.name = name;
    }

    /*
     * ÎŒÎ»ÎµÏ‚ Î¿Î¹ ÎºÎ»Î¬ÏƒÎµÎ¹Ï‚ Ï€Î¿Ï… Î¸Î± ÎºÎ»Î·Ï�Î¿Î½Î¿Î¼Î®ÏƒÎ¿Ï…Î½ Ï„Î·Î½ PeopleInFs Î´ÎµÎ½ Î¸Î± Î­Ï‡Î¿Ï…Î½ Î±Ï€ÎµÏ…Î¸ÎµÎ¯Î±Ï‚ Ï€Ï�ÏŒÏƒÎ²Î±ÏƒÎ· ÏƒÏ„Î¿
     * Ï€ÎµÎ´Î¯Î¿ name Î´Î¹ÏŒÏ„Î¹ ÎµÎ¯Î½Î±Î¹ Î¹Î´Î¹Ï‰Ï„Î¹ÎºÏŒ. Î“Î¹Î± Î½Î± Î­Ï‡Î¿Ï…Î¼Îµ Ï€Ï�ÏŒÏƒÎ²Î±ÏƒÎ· Î±ÎºÎ¿Î»Î¿Ï…Î¸Î¿Ï�Î¼Îµ Ï„Î·Î½ Î±Ï�Ï‡Î® Ï„Î·Ï‚ ÎµÎ½Î¸Ï…Î»Î¬ÎºÏ‰ÏƒÎ·Ï‚
     * ÎºÎ±Î»ÏŽÎ½Ï„Î±Ï‚ ÎºÎ¬Î¸Îµ Ï†Î¿Ï�Î¬ Ï„Î·Î½ ÏƒÏ…Î½Î¬Ï�Ï„Î·ÏƒÎ· getName() ÏŽÏƒÏ„Îµ Î½Î± Î­Ï‡Î¿Ï…Î¼Îµ Ï€Ï�ÏŒÏƒÎ²Î±ÏƒÎ· ÏƒÏ„Î¿ Ï€ÎµÎ´Î¯Î¿ name
     */
    public String getName() {
        return name;
    }

    /*
     * ÎœÏ€Î¿Ï�Î¿Ï�Î¼Îµ Î½Î± Î¸Î­ÏƒÎ¿Ï…Î¼Îµ Ï„Î·Î½ Ï„Î¹Î¼Î® Ï„Î¿Ï… name ÎºÎ±Î¹ Î¼Î­ÏƒÏ‰ Ï„Î·Ï‚ setName() ÏŒÏ€Î¿Ï… ÎºÎ¬Î½Î¿Ï…Î¼Îµ ÎºÎ±Î¹ Ï„Î¿Ï…Ï‚ Î±Ï€Î±Ï�Î±Î¯Ï„Î·Ï„Î¿Ï…Ï‚
     * ÎµÎ»Î­Î³Ï‡Î¿Ï…Ï‚ Ï€Ï�Î¹Î½ Î´ÏŽÏƒÎ¿Ï…Î¼Îµ Ï„Î¹Î¼Î® ÏƒÏ„Î· Î¼ÎµÏ„Î±Î²Î»Î·Ï„Î®. Î‘ÎºÎ¿Î»Î¿Ï…Î¸Î¿Ï�Î¼Îµ Ï€Î¬Î»Î¹ Ï„Î·Î½ Î±Ï�Ï‡Î® Ï„Î·Ï‚ ÎµÎ½Î¸Ï…Î»Î¬ÎºÏ‰ÏƒÎ·Ï‚.
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
