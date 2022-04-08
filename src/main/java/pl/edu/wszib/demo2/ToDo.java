package pl.edu.wszib.demo2;

import java.nio.ReadOnlyBufferException;

public class ToDo {
    private Integer id;
    private String nazwa;
     enum Status {
        NEW,
        IN_PROGRESS,
        DONE
    }

    private Status Status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public ToDo.Status getStatus() {
        return Status;
    }

    public void setStatus(ToDo.Status status) {
        Status = status;
    }
}
