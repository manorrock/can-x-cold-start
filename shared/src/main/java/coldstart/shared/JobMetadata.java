package coldstart.shared;

/**
 * A model object to dump out job statistics.
 * 
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class JobMetadata {
    
    /**
     * Stores the name.
     */
    private String name;

    /**
     * Get the name.
     * 
     * @return the name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name.
     * 
     * @param name the name.
     */
    public void setName(String name) {
        this.name = name;
    }
}
