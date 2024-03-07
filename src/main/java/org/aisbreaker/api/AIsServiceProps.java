package org.aisbreaker.api;

/**
 * Every AIsService can be parameterized with these 
 * or (in very rare cases) with a service-specific extension of these properties.
 */
public class AIsServiceProps {
    /**
     * Unique identifier of the AIsBreaker service,
     * see: https://aisbreaker.org/docs/serviceId
     */
    public String serviceId;
    /**
     * URL of the AI service (optional).
     */
    public String url;
    /**
     * Service implementation specific options.
     * Try to avoid using them because they are NOT portable!!!
     */
    public Object internServiceOptions;
    /**
     * Optional field, e.g. for Google Cloud (Vertex AI) services.
     */
    public String project;
    /**
     * Optional field, e.g. for Google Cloud (Vertex AI) services.
     */
    public String location;
    /**
     * Optional field, e.g. for Google Cloud (Vertex AI) services.
     */
    public AIsServiceProps forward2ServiceProps;

    //
    // Getters and Setters
    //

    public String getServiceId() {
        return serviceId;
    }
    public AIsServiceProps setServiceId(String serviceId) {
        this.serviceId = serviceId;
        return this;
    }

    public String getUrl() {
        return url;
    }
    public AIsServiceProps setUrl(String url) {
        this.url = url;
        return this;
    }

    public Object getInternServiceOptions() {
        return internServiceOptions;
    }
    public AIsServiceProps setInternServiceOptions(Object internServiceOptions) {
        this.internServiceOptions = internServiceOptions;
        return this;
    }

    public String getProject() {
        return project;
    }
    public AIsServiceProps setProject(String project) {
        this.project = project;
        return this;
    }

    public String getLocation() {
        return location;
    }
    public AIsServiceProps setLocation(String location) {
        this.location = location;
        return this;
    }

    public AIsServiceProps getForward2ServiceProps() {
        return forward2ServiceProps;
    }
    public AIsServiceProps setForward2ServiceProps(AIsServiceProps forward2ServiceProps) {
        this.forward2ServiceProps = forward2ServiceProps;
        return this;
    }

    public String toString() {
        String optionalInternServiceOptions = (internServiceOptions == null) ? "" : ", internServiceOptions="+internServiceOptions+"'";
        String optionalProject = (project == null) ? "" : ", project='"+project+"'";
        String optionalLocation = (location == null) ? "" : ", location='"+location+"'";
        String optionalForward2ServiceProps = (forward2ServiceProps == null) ? "" : ", forward2ServiceProps="+forward2ServiceProps+"'";
        return "AIsServiceProps{" +
                "serviceId='" + serviceId + '\'' +
                ", url='" + url + '\'' +
                optionalInternServiceOptions +
                optionalProject +
                optionalLocation +
                optionalForward2ServiceProps +
                '}';
    }

}
