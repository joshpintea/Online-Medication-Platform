
package core.recommendation_web_service;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the core.recommendation_web_service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: core.recommendation_web_service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ActivityRecommendationRequest }
     * 
     */
    public ActivityRecommendationRequest createActivityRecommendationRequest() {
        return new ActivityRecommendationRequest();
    }

    /**
     * Create an instance of {@link ActivityRecommendationResponse }
     * 
     */
    public ActivityRecommendationResponse createActivityRecommendationResponse() {
        return new ActivityRecommendationResponse();
    }

    /**
     * Create an instance of {@link ActivityRecommendation }
     * 
     */
    public ActivityRecommendation createActivityRecommendation() {
        return new ActivityRecommendation();
    }

    /**
     * Create an instance of {@link Activity }
     * 
     */
    public Activity createActivity() {
        return new Activity();
    }

}
