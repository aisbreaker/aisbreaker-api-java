package org.aisbreaker.api.model;

// TODO: Class not needed, can be deleted?

/**
 * Parts of a serviceId = '<task>:<vendor>/<engine>'
 */
public class TaskVendorEngine {
    public String task;
    public String vendor;
    public String engine;


    //
    // Getters and Setters
    //

    public String getTask() {
        return task;
    }
    public TaskVendorEngine setTask(String task) {
        this.task = task;
        return this;
    }

    public String getVendor() {
        return vendor;
    }
    public TaskVendorEngine setVendor(String vendor) {
        this.vendor = vendor;
        return this;
    }

    public String getEngine() {
        return engine;
    }
    public TaskVendorEngine setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public String toString() {
        return "TaskVendorEngine{" +
                "task='" + task + '\'' +
                ", vendor='" + vendor + '\'' +
                ", engine='" + engine + '\'' +
                '}';
    }
}
