package DefiningClassesExercise.Google;

import java.util.ArrayList;
import java.util.List;

public class Person_ {
    private String name;
    private Company company;
    private Car car;
    private List<Children> children;
    private List<Pokemon> pokemons;
    private List<Parents> parents;


    public Person_(String name) {
        this.name = name;
        this.children = new ArrayList<>();
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void add(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public void add(Parents parents) {
        this.parents.add(parents);
    }

    public void add(Children children) {
        this.children.add(children);
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Company getCompany() {
        return company;
    }

    public Car getCar() {
        return car;
    }

    public List<Children> getChildren() {
        return children;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public List<Parents> getParents() {
        return parents;
    }

    public String getName() {
        return name;
    }
 
}
