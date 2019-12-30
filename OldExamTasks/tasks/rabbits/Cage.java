package rabbits;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;
    private int count;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
        this.count = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int count() {
        return this.count;
    }

    public void add(Rabbit rabbit) {
        if (this.getCapacity() > this.data.size()) {
            data.add(rabbit);
            this.count++;
        }
    }


    public boolean removeRabbit(String rabbitName) {
        boolean isRemoved = false;
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getName().equals(rabbitName)) {
                isRemoved = true;
                data.remove(data.get(i));
                this.count--;
            }
        }
        return isRemoved;
    }

    public void removeSpecies(String species) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getSpecies().contains(species)){
                data.remove(data.get(i));
                this.count--;
            }
        }

    }


    public Rabbit sellRabbit(String bunny) {
        Rabbit rabbit = null;
        for (int i = 0; i < this.data.size(); i++) {
            if (data.get(i).getName().contains(bunny)) {
                rabbit = data.get(i);
                this.data.get(i).setAvailable(false);
                break;
            }
        }
        return rabbit;
    }


    public List<Rabbit> sellRabbitBySpecies(String rabbits) {
        List<Rabbit> currentRabbits = new ArrayList<>();

        for (int i = 0; i < data.size(); i++) {
            if (this.data.get(i).getSpecies().equals(rabbits)) {
                this.data.get(i).setAvailable(false);
                currentRabbits.add(data.get(i));
            }
        }
        return currentRabbits;
    }


    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Rabbits available at %s:%n",this.name));
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).isAvailable()){
                sb.append(String.format("%s%n",this.data.get(i)));
            }
        }
        return sb.toString();
    }
}
