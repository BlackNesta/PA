package HR;

import java.util.Objects;

public class Hospital {
    public String name;
    public int capacity;

    public Hospital(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int compareTo(Hospital h) {
        if (getCapacity() == h.getCapacity()) {
            if (getName().compareTo(h.getName()) < 0) return -1;
            else return 1;
        }
        else if (getCapacity() < h.getCapacity())
            return -1;
        else return 1;
    }
}
