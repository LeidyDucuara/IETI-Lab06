package co.edu.escuelaing.ieti.parte2.dto;

public class TaskDto {

    private String mane;
    private String description;
    private Status status;
    private String assignedTo;
    private String dueDate;

    enum Status{ TOD, DOING, REVIEW, DONE}

    public TaskDto(String mane, String description, Status status, String assignedTo, String dueDate) {
        this.mane = mane;
        this.description = description;
        this.status = status;
        this.assignedTo = assignedTo;
        this.dueDate = dueDate;
    }

    public String getMane() {
        return mane;
    }

    public void setMane(String mane) {
        this.mane = mane;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}
