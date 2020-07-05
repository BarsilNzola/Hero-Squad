package models;

import java.util.Objects;

public class Squad {
    private String name;
    private String cause;
    private int size;

    public Squad (String name, String cause, int size){
        this.name = name;
        this.cause = cause;
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Squad squad = (Squad) o;
        return size == squad.size &&
                name.equals(squad.name) &&
                cause.equals(squad.cause);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cause, size);
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
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
