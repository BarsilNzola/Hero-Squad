package models;

import java.util.Objects;

public class Squad {
    private String name;
    private String cause;
    private int squadSize;
    private int id;

    public Squad (String name, String cause, int size, int id){
        this.name = name;
        this.cause = cause;
        this.squadSize = squadSize;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Squad squad = (Squad) o;
        return squadSize == squad.squadSize &&
                name.equals(squad.name) &&
                cause.equals(squad.cause);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cause, squadSize);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public int getSize() {
        return squadSize;
    }

    public void setSize(int squadSize) {
        this.squadSize = squadSize;
    }
}
