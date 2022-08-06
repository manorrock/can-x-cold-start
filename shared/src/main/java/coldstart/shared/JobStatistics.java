package coldstart.shared;

import java.util.ArrayList;
import java.util.List;

/**
 * A model object for job metadata.
 * 
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class JobStatistics {
    
    /**
     * Stores the metadata.
     */
    private List<JobMetadata> metadata = new ArrayList<>();
    
    /**
     * Stores the measurements.
     */
    private List<JobMeasurement> measurements = new ArrayList<>();

    /**
     * Get the measurements.
     * 
     * @return the measurements.
     */
    public List<JobMeasurement> getMeasurements() {
        return measurements;
    }
    
    /**
     * Get the metadata.
     * 
     * @return the metadata.
     */
    public List<JobMetadata> getMetadata() {
        return metadata;
    }

    /**
     * Set the measurements.
     * 
     * @param measurements the measurements.
     */
    public void setMeasurements(List<JobMeasurement> measurements) {
        this.measurements = measurements;
    }
    
    /**
     * Set the metadata.
     * 
     * @param metadata the metadata.
     */
    public void setMetadata(List<JobMetadata> metadata) {
        this.metadata = metadata;
    }
}
